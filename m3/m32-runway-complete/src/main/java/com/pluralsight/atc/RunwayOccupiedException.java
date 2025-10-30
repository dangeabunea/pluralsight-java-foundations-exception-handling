package com.pluralsight.atc;

public class RunwayOccupiedException extends Exception {
    public RunwayOccupiedException(String runwayId) {
        super("Runway " + runwayId + " is occupied.");
    }
}
