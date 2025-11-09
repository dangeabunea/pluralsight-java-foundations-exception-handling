package com.pluralsight.atc;

import java.text.ParseException;

public class PositionParser {

    /**
     * Parses a line of position data into an AircraftPosition object.
     * Expected format: "CALLSIGN ALTITUDE LATITUDE LONGITUDE"
     * Example: "UAL123 35000 40.7128 -74.0060"
     *
     * @param line the raw position data line
     * @return parsed AircraftPosition
     * @throws ParseException if the line format is invalid or data cannot be parsed
     */
    public static AircraftPosition parse(String line) throws ParseException {
        String[] parts = line.split("\\s+");

        if (parts.length != 4) {
            throw new ParseException("Invalid position format. Expected: CALLSIGN ALTITUDE LAT LON", 0);
        }

        String callsign = parts[0];

        try {
            int altitude = Integer.parseInt(parts[1]);
            double latitude = Double.parseDouble(parts[2]);
            double longitude = Double.parseDouble(parts[3]);

            // Validate coordinate ranges
            if (latitude < -90 || latitude > 90) {
                throw new ParseException("Latitude out of range: " + latitude, 0);
            }
            if (longitude < -180 || longitude > 180) {
                throw new ParseException("Longitude out of range: " + longitude, 0);
            }

            return new AircraftPosition(callsign, altitude, latitude, longitude);

        } catch (NumberFormatException e) {
            throw new ParseException("Invalid numeric data in position: " + e.getMessage(), 0);
        }
    }
}
