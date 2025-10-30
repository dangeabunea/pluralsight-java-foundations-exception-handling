package com.pluralsight.atc;

import java.util.Scanner;


public class Application {
    public static void main(String[] args) {
        Scanner scanner = null;

        try {
            // Line 5,9 from radar-output.txt are invalid
            var inputStream = Application.class
                    .getClassLoader()
                    .getResourceAsStream("radar-output.txt");
            scanner = new Scanner(inputStream);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                LatLon coord = new LatLon(line);
                System.out.println("Read coordinate: " + coord.getLatitude() + "," + coord.getLongitude());
            }

            scanner.close();
        } catch (Exception e) {
            System.err.println("Error reading coordinates: " + e.getMessage());
            // Resources NOT closed here - memory leak when exception occurs!
            // Look in debug mode.
        }
    }
}
