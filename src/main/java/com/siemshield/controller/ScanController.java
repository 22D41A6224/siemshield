package com.siemshield.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siemshield.model.ScanResult;
import com.siemshield.repository.ScanRepository;
import com.siemshield.service.NmapScannerService;
import com.siemshield.service.RiskScoreService;
import com.siemshield.service.ThreatDetectionService;

@RestController
@RequestMapping("/scan")
@CrossOrigin
public class ScanController {

    private final NmapScannerService scannerService;
    private final ThreatDetectionService threatService;
    private final RiskScoreService riskService;
    private final ScanRepository scanRepository;

    public ScanController(
            NmapScannerService scannerService,
            ThreatDetectionService threatService,
            RiskScoreService riskService,
            ScanRepository scanRepository) {

        this.scannerService = scannerService;
        this.threatService = threatService;
        this.riskService = riskService;
        this.scanRepository = scanRepository;
    }

    @GetMapping("/{target}")
    public ScanResult scan(@PathVariable String target) {

        String output = scannerService.scanTarget(target);

        String threat = threatService.detectThreat(output);

        int risk = riskService.calculateRisk(threat);

        ScanResult result = new ScanResult(target, output, threat, risk);

        scanRepository.save(result);

        return result;
    }

    @GetMapping("/history")
    public List<ScanResult> history() {
        return scanRepository.findAll();
    }
}
