package com.pluralsight.atc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        try (InputStream inputStream = Application.class
                .getClassLoader()
                .getResourceAsStream("radar-output.txt");
             ProblematicScanner scanner = new ProblematicScanner(
                     new Scanner(inputStream), true)) {

            // Line 5,9 from radar-output.txt are invalid - will throw exception
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                LatLon coord = new LatLon(line);
                System.out.println("Read coordinate: " + coord.getLatitude() + "," + coord.getLongitude());
            }

        } catch (IllegalArgumentException | IOException e) {
            System.err.println("Exception caught: " + e.getClass().getSimpleName() + ": " + e.getMessage());

            Throwable[] suppressed = e.getSuppressed();
            if (suppressed.length > 0) {
                System.err.println("\nSupressed exceptions:");
                for (int i = 0; i < suppressed.length; i++) {
                    System.err.println("  [" + i + "] " + suppressed[i].getClass().getSimpleName() +
                            ": " + suppressed[i].getMessage());
                }
            }
        }
    }
}