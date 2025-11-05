package com.pluralsight.atc;

public class RunwayOccupiedException extends RuntimeException {
    public RunwayOccupiedException(String runwayId, String aircraftCallSign) {
        super("Runway " + runwayId + " is occupied. " +
                aircraftCallSign + " can not take off now. Wait.");
    }
}
