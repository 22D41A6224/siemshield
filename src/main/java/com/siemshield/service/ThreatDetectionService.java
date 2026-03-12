package com.siemshield.service;

import org.springframework.stereotype.Service;

@Service
public class ThreatDetectionService {

    public String detectThreat(String openPorts) {

        if (openPorts.contains("3389")) {
            return "HIGH";
        }

        if (openPorts.contains("21")) {
            return "HIGH";
        }

        if (openPorts.contains("22")) {
            return "MEDIUM";
        }

        return "LOW";
    }
}
