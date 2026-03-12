package com.siemshield.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.siemshield.scanner.NmapScanner;

@Service
public class NmapScannerService {

    private final NmapScanner scanner = new NmapScanner();

    public String scanTarget(String target) {

        String output = scanner.runScan(target);

        return extractOpenPorts(output);
    }

    private String extractOpenPorts(String nmapOutput) {

        List<String> ports = new ArrayList<>();

        String[] lines = nmapOutput.split("\n");

        for(String line : lines) {

            if(line.contains("/tcp") && line.contains("open")) {

                String port = line.split("/")[0].trim();
                ports.add(port);
            }
        }

        return String.join(",", ports);
    }
}
