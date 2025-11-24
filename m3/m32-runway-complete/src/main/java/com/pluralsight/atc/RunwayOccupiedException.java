package com.pluralsight.atc;

public class RunwayOccupiedException extends RuntimeException {
    private final String runwayId;
    private final String aircraftCallSign;

    public RunwayOccupiedException(String runwayId, String aircraftCallSign) {
        super("Runway " + runwayId + " is occupied. " +
                aircraftCallSign + " can not take off now. Wait.");
        this.runwayId = runwayId;
        this.aircraftCallSign = aircraftCallSign;
    }

    public String getAircraftCallSign() {
        return aircraftCallSign;
    }

    public String getRunwayId() {
        return runwayId;
    }
}
