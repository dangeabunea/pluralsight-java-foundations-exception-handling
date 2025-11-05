package com.pluralsight.atc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;


public class Application {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = null;

        try {
            inputStream = Application.class
                    .getClassLoader()
                    .getResourceAsStream("radar-output.txt");

            Scanner scanner = null;
            try {
                scanner = new Scanner(inputStream);

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    LatLon coord = new LatLon(line);
                    System.out.println("Read coordinate: " + coord.getLatitude() + "," + coord.getLongitude());
                }
            } finally {
                if (scanner != null) {
                    scanner.close();
                }
            }
        } catch (Exception e) {
            System.err.println("Error reading coordinates: " + e.getMessage());
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}
