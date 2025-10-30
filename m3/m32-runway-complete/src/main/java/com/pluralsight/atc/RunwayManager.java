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

    public synchronized void requestTakeoff(String aircraftCallSign)
            throws RunwayClosedException, RunwayOccupiedException {

        if (closed) {
            throw new RunwayClosedException(this.runwayId);
        }

        if (occupied) {
            throw new RunwayOccupiedException(this.runwayId);
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
