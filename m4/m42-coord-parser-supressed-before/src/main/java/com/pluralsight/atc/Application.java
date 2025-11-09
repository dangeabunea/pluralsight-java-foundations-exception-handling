package com.pluralsight.atc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * When both the main code AND cleanup code throw exceptions,
 * the original exception is LOST (suppressed) - only the cleanup exception is visible.
 * This makes debugging extremely difficult!
 */
public class Application {
    public static void main(String[] args) {
        InputStream inputStream = null;
        ProblematicScanner scanner = null;

        try {
            inputStream = Application.class
                    .getClassLoader()
                    .getResourceAsStream("radar-output.txt");

            scanner = new ProblematicScanner(new Scanner(inputStream), true);

            // Line 5,9 from radar-output.txt are invalid - will throw exception
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                LatLon coord = new LatLon(line);
                System.out.println("Read coordinate: " + coord.getLatitude() + "," + coord.getLongitude());
            }

        } catch (IllegalArgumentException e) {
            // We catch the original exception here
            // Re-throw to propagate the error
            throw new RuntimeException("Re-throwing from catch block", e);

        } finally {
            try {
                if (scanner != null) {
                    // Cleanup code that ALSO throws an exception
                    System.err.println("Attempting to close scanner...");
                    scanner.close(); // This throws IOException!
                }
            } catch (Exception closeEx) {
                // PROBLEM: This exception REPLACES the original one!
                throw new RuntimeException("Error during cleanup..", closeEx);
            }
        }
    }
}