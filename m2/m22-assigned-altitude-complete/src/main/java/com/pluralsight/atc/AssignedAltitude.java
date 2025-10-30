package com.pluralsight.atc;

public class AssignedAltitude {
    private int valueFt;

    /**
     * Correct values
     * - 100
     * - 100ft
     *
     * @param value
     */
    public AssignedAltitude(String value) {
        if (value == null || value.isEmpty()) {
            throw new NullPointerException("Altitude cannot be null");
        }

        int valueInFeet = 0;
        try {
            valueInFeet = Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            if (value.endsWith("ft")) {
                value = value.substring(0, value.length() - 2);
                valueInFeet = Integer.parseInt(value);
            }
            else throw new NumberFormatException("Altitude must be a number");
        }
        if (valueInFeet < 0 || valueInFeet > 43000) {
            throw new IllegalArgumentException("Altitude must be between 0 and 43000 feet");
        }

        this.valueFt = valueInFeet;
    }

    public int getValue() {
        return this.valueFt;
    }
}
