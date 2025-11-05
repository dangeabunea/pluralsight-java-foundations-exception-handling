package com.pluralsight.atc;

import java.io.InputStream;
import java.util.Scanner;


public class Application {
    public static void main(String[] args) {
        try (InputStream inputStream = Application.class
                .getClassLoader()
                .getResourceAsStream("radar-output.txt");
             Scanner scanner = new Scanner(inputStream)) {

            // Line 5,9 from radar-output.txt are invalid
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                LatLon coord = new LatLon(line);
                System.out.println("Read coordinate: " + coord.getLatitude() + "," + coord.getLongitude());
            }

        } catch (Exception e) {
            System.err.println("Error reading coordinates: " + e.getMessage());
        }
    }
}