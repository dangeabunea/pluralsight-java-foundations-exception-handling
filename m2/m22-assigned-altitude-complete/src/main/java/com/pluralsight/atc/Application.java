package com.pluralsight.atc;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter altitudes in feet (type 'q' to quit):");

        while (true) {
            System.out.print("Altitude: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("q")) {
                break;
            }

            try {
                AssignedAltitude assignedAltitude = new AssignedAltitude(input);
                System.out.println("Assigned altitude: " + assignedAltitude.getValue());
            } catch (NullPointerException | NumberFormatException e) {
                System.out.println("Invalid input");
            } catch (IllegalArgumentException iae) {
                System.out.println("Altitude out of range");
            }
        }

        scanner.close();
    }
}
