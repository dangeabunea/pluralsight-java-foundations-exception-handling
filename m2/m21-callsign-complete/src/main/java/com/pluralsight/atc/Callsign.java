package com.pluralsight.atc;

public class Callsign {
    private String value;

    public Callsign(String value) {
        // Validation Rule: Callsign cannot be null
        if (value == null) {
            throw new NullPointerException("Callsign cannot be null");
        }

        // Validation Rule: Callsign must be between 2 and 10 characters
        if (value.length() < 4 || value.length() > 10) {
            throw new IllegalArgumentException("Callsign must be between 4 and 10 characters");
        }

        // Validation Rule: Callsign must contain only alphanumeric characters and hyphens
        if (!value.matches("^[a-zA-Z0-9-]+$")) {
            throw new IllegalArgumentException("Callsign must contain only alphanumeric characters and hyphens");
        }

        this.value = value.trim();
    }

    public String getValue() {
        return value;
    }
}
