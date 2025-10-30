package com.pluralsight.atc;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Enter altitudes in feet (type 'q' to quit):");

        while (true) {
            System.out.print("Altitude: ");
            input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("q")) {
                System.out.println("Exiting altitude input.");
                break;
            }

            try {
                AssignedAltitude assignedAltitude = new AssignedAltitude(input);
                System.out.println("Assigned altitude: " + assignedAltitude.getValue());
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }

        scanner.close();
    }
}
