package com.pluralsight.atc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AtcWeatherService {
    public String getWeatherReport(String sectorCode) throws IOException {
        String filename = "weather_" + sectorCode + ".txt";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);

        if (inputStream == null) {
            // FileNotFoundException extends IOException
            throw new FileNotFoundException("Weather report not found: " + filename);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        try {
            StringBuilder report = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                report.append(line).append("\n");
            }
            return report.toString();
        } finally {
            reader.close();
        }
    }

    public String getBackupWeatherReport(String sectorCode) throws IOException {
        String filename = "weather_" + sectorCode + "_backup.txt";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);

        if (inputStream == null) {
            // FileNotFoundException extends IOException
            throw new FileNotFoundException("Backup weather report not found: " + filename);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        try {
            StringBuilder report = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                report.append(line).append("\n");
            }
            return report.toString();
        } finally {
            reader.close();
        }
    }

}
