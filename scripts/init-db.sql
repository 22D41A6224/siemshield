CREATE DATABASE IF NOT EXISTS siemshield;
USE siemshield;

CREATE TABLE IF NOT EXISTS scans (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    target VARCHAR(255),
    open_ports VARCHAR(255),
    threat_level VARCHAR(50),
    risk_score INT,
    scan_time DATETIME
);