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

    /**
     * Request take off from the runway manager
     *
     * @param aircraftCallSign
     * @throws RunwayClosedException   When the runway is closed
     * @throws RunwayOccupiedException When another aircraft is occupying the runway. In this
     *                                 case, wait and try to request the take off later
     */
    public void requestTakeoff(String aircraftCallSign) {
        if (closed) {
            throw new RunwayClosedException(this.runwayId);
        }

        if (occupied) {
            throw new RunwayOccupiedException(this.runwayId, aircraftCallSign);
        }

        // Occupy runway with this aircraft
        occupied = true;
        System.out.println("Takeoff clearance granted to " + aircraftCallSign);
    }

    public void releaseRunway() {
        System.out.println("Runway is now free.");
        occupied = false;
    }
}
