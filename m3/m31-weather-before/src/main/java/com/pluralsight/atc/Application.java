package com.pluralsight.atc;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        var weatherService = new AtcWeatherService();
        String sectorName = "EAST";
        String eastWeatherReport = null;

        try {
            eastWeatherReport = weatherService.getWeatherReport(sectorName);
        } catch (FileNotFoundException e) {
            System.out.println("Can not get main weather report, trying backup");
            eastWeatherReport = weatherService.getWeatherReport(sectorName + "_backup");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(eastWeatherReport);
    }
}
