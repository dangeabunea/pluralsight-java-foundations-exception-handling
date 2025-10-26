package com.pluralsight.atc;

/**
 * Represents an ATC transponder squawk code.
 *
 * Squawk codes are 4-digit octal codes (0000-7777) used for aircraft
 * identification in air traffic control. Each digit must be 0-7.
 */
public class SquawkCode {
    private final String code;
    private final int decimalValue;

    public SquawkCode(String code) {
        this.code = code;
        this.decimalValue = Integer.parseInt(code, 8);
    }

    public String getCode() {
        return code;
    }

    public int getDecimalValue() {
        return decimalValue;
    }

    @Override
    public String toString() {
        return String.format("Squawk %s (decimal: %d)", code, decimalValue);
    }
}
