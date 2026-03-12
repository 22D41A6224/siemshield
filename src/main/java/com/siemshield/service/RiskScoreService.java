package com.siemshield.service;

import org.springframework.stereotype.Service;

@Service
public class RiskScoreService {

    public int calculateRisk(String threatLevel) {

        switch (threatLevel) {

            case "HIGH":
                return 90;

            case "MEDIUM":
                return 60;

            default:
                return 20;
        }
    }
}