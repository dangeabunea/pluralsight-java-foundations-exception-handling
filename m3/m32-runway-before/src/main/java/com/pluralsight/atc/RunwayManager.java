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

    public void requestTakeoff(String aircraftCallSign) {

        if (closed) {
            throw new UnsupportedOperationException("Runway closed. Use another runway.");
        }

        if (occupied) {
            throw new UnsupportedOperationException("Runway occupied. Wait until clear.");
        }

        // Occupy runway with this aircraft
        occupied = true;
        System.out.println("Takeoff clearance granted to " + aircraftCallSign);
    }

    public synchronized void releaseRunway() {
        System.out.println("Runway is now free");
        occupied = false;
    }
}
