package com.pluralsight.atc;

import java.io.*;

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
            // Can throw IOException
            while ((line = reader.readLine()) != null) {
                report.append(line).append("\n");
            }
            return report.toString();
        } finally {
            if(reader != null) {
                reader.close();
            }
        }
    }

}
