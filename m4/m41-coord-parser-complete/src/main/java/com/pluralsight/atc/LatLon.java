package com.pluralsight.atc;

/**
 * The LatLon class represents a geographical location defined by latitude and longitude.
 */
public class LatLon {
    private double latitude;
    private double longitude;

    public LatLon(double latitude, double longitude) {
        setLatitude(latitude);
        setLongitude(longitude);
    }


    /**
     * Constructs a LatLon object using a string representation from radar system
     * Valid: 23.5;33.44
     **/
    public LatLon(String coordinate) {
        var parts = coordinate.split(";");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Coordinate must be in the format lat,lon");
        }
        setLatitude(Double.parseDouble(parts[0]));
        setLongitude(Double.parseDouble(parts[1]));
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        if (latitude < -90 || latitude > 90) {
            throw new IllegalArgumentException("Latitude must be between -90 and 90");
        }
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        if (longitude < -180 || longitude > 180) {
            throw new IllegalArgumentException("Longitude must be between -180 and 180");
        }
        this.longitude = longitude;
    }
}
