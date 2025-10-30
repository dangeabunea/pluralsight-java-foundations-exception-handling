package com.pluralsight.atc;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        var weatherService = new AtcWeatherService();

        String sectorName = "EAST";
        String eastWeatherReport = null;
        try {
            eastWeatherReport = weatherService.getWeatherReport(sectorName);
        } catch (IOException e) {
            try {
                // Remediation
                eastWeatherReport = weatherService.getBackupWeatherReport(sectorName);
            } catch (IOException ex) {
                // Nothing we can do => throw runtime exception
                throw new RuntimeException("Unable to get backup weather report for");
            }
        }
        System.out.println(eastWeatherReport);
    }
}
