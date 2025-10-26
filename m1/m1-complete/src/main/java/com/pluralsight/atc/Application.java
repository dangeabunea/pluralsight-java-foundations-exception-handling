package com.pluralsight.atc;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Squawk Code Registration System ===");
        System.out.println("Enter squawk codes. Type 'q' to exit\n");

        while (true) {
            System.out.print("Enter squawk code: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("q")) {
                System.out.println("Exiting squawk code registration system.");
                break;
            }

            var squawkCode = new SquawkCode(input);
            System.out.println("Registered: " + squawkCode + "\n");
        }

        scanner.close();
    }
}