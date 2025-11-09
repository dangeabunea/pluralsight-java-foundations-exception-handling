package com.pluralsight.atc;

public record AircraftPosition(String callSign, int altitude, double latitude, double longitude) {
    @Override
    public String toString() {
        return String.format("%s at FL%03d (%.4f°, %.4f°)",
                callSign, altitude / 100, latitude, longitude);
    }
}
