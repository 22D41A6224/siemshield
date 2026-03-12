package com.siemshield.engine;

import org.springframework.stereotype.Component;

@Component
public class CorrelationEngine {

    public String correlateEvents(String scanOutput) {

        if (scanOutput.contains("22/tcp") && scanOutput.contains("80/tcp")) {
            return "Possible web server exposed";
        }

        if (scanOutput.contains("21/tcp")) {
            return "FTP service exposed";
        }

        return "No critical correlation";
    }
}
