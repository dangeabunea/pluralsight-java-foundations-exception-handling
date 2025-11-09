package com.pluralsight.atc;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        List<String> rawPositions = loadPositionFeed();
        List<AircraftPosition> parsedPositions;

        // Solution 1: Handle exception inside the lambda
        System.out.println("\n--- Solution 1: Try-Catch Inside Lambda ---");
        parsedPositions = rawPositions.stream()
            .map(line -> {
                try {
                    return PositionParser.parse(line);
                } catch (ParseException e) {
                    System.err.println("Skipping invalid position: " + e.getMessage());
                    return null;
                }
            })
            .filter(pos -> pos != null)
            .toList();

        parsedPositions.forEach(System.out::println);

        // Solution 2: Wrapper method that converts checked to unchecked exception
        System.out.println("\n--- Solution 2: Wrapper Method ---");
        parsedPositions = rawPositions.stream()
            .map(Application::parsePosition)
            .filter(pos -> pos != null)
            .toList();

        parsedPositions.forEach(System.out::println);
    }

    /**
     * Wrapper method that handles the checked exception and returns null on failure
     */
    private static AircraftPosition parsePosition(String line) {
        try {
            return PositionParser.parse(line);
        } catch (ParseException e) {
            System.err.println("Skipping invalid position: " + e.getMessage());
            return null;
        }
    }

    private static List<String> loadPositionFeed() {
        List<String> lines = new ArrayList<>();
        try (InputStream inputStream = Application.class
                .getClassLoader()
                .getResourceAsStream("position-feed.txt");
             Scanner scanner = new Scanner(inputStream)) {

            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }
}
