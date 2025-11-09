package com.pluralsight.atc;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        List<String> rawPositions = loadPositionFeed();

        // PROBLEM: Lambda expressions cannot throw checked exceptions!
        // But PositionParser.parse() throws ParseException (checked exception):
        //   public static AircraftPosition parse(String line) throws ParseException
        //
        // This creates a fundamental incompatibility - the lambda body calls a method
        // that throws a checked exception, but the functional interface doesn't allow it.
        //
        // COMPILATION ERROR: Unhandled exception type ParseException

//        List<AircraftPosition> positions = rawPositions.stream()
//            .map(line -> PositionParser.parse(line))  // ERROR HERE!
//            .toList();
//
//        positions.forEach(System.out::println);
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
