package com.pluralsight.atc;

public class RunwayManager {
    private final String runwayId;
    private boolean closed = false;
    private boolean occupied = false;

    public RunwayManager(String runwayId) {
        this.runwayId = runwayId;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public synchronized void requestTakeoff(String aircraftCallSign) {

        if (closed) {
            throw new UnsupportedOperationException("Runway closed. Use another runway.");
        }

        if (occupied) {
            throw new UnsupportedOperationException("Runway occupied. Wait until clear.");
        }

        // Occupy runway with this aircraft
        occupied = true;
        System.out.println("Takeoff clearance granted to " + aircraftCallSign +
                " on " + runwayId + ". Runway now occupied.");
    }

    public synchronized void releaseRunway(String aircraftCallSign) {
        System.out.println("Aircraft " + aircraftCallSign + " has departed. "
                + "Runway " + runwayId + " is now free.");
        occupied = false;
    }
}
