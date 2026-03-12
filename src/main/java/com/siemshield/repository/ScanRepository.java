package com.siemshield.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siemshield.model.ScanResult;

public interface ScanRepository extends JpaRepository<ScanResult, Long> {
}
