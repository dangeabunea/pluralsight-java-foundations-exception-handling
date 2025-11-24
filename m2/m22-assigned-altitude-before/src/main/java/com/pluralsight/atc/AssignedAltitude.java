package com.pluralsight.atc;

public class AssignedAltitude {
    private int valueFt;

    /**
     * Correct values
     * - 0, 100, 200, 43000
     * @param value
     */
    public AssignedAltitude(String value) {
        if (value == null || value.isEmpty()) {
            throw new NullPointerException("Altitude cannot be null");
        }

        int valueInFeet = Integer.parseInt(value);
        if (valueInFeet < 0 || valueInFeet > 43000) {
            throw new IllegalArgumentException("Altitude must be between 0 and 43000 feet");
        }

        this.valueFt = valueInFeet;
    }

    public int getValue() {
        return this.valueFt;
    }
}
