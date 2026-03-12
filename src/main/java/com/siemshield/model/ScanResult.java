package com.siemshield.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "scans")
public class ScanResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String target;

    @Column(columnDefinition = "TEXT")
    private String openPorts;

    private String threatLevel;

    private int riskScore;

    private LocalDateTime scanTime;

    public ScanResult() {
        this.scanTime = LocalDateTime.now();
    }

    public ScanResult(String target, String openPorts, String threatLevel, int riskScore) {
        this.target = target;
        this.openPorts = openPorts;
        this.threatLevel = threatLevel;
        this.riskScore = riskScore;
        this.scanTime = LocalDateTime.now();
    }

    // getters and setters
    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getOpenPorts() {
        return openPorts;
    }

    public void setOpenPorts(String openPorts) {
        this.openPorts = openPorts;
    }

    public String getThreatLevel() {
        return threatLevel;
    }

    public void setThreatLevel(String threatLevel) {
        this.threatLevel = threatLevel;
    }

    public int getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(int riskScore) {
        this.riskScore = riskScore;
    }

    public LocalDateTime getScanTime() {
    return scanTime;
    }

    public void setScanTime(LocalDateTime scanTime) {
    this.scanTime = scanTime;
    }

}