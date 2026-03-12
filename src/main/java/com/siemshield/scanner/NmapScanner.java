package com.siemshield.scanner;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NmapScanner {

    public String runScan(String target) {

        StringBuilder result = new StringBuilder();

        try {

            ProcessBuilder builder = new ProcessBuilder(
                    "nmap", "-sV", target
            );

            Process process = builder.start();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );

            String line;

            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result.toString();
    }
}
