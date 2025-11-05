package com.pluralsight.atc;

public class RunwayManager {
    private final String runwayId;
    private boolean closed = false;
    private boolean occupied = false;
    private boolean isLightingSystemOperational = true;

    public RunwayManager(String runwayId) {
        this.runwayId = runwayId;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public void setLightingSystemOperational(boolean lightingSystemOperational) {
        isLightingSystemOperational = lightingSystemOperational;
    }

    public void requestTakeoff(String aircraftCallSign) {
        try {
            checkRunwaySystems();
        } catch (RuntimeException e) {
            this.closed = true;
            throw new RunwayClosedException(this.runwayId, e);
        }

        if (closed) {
            throw new RunwayClosedException(this.runwayId);
        }

        if (occupied) {
            throw new RunwayOccupiedException(this.runwayId,aircraftCallSign);
        }

        // Occupy runway with this aircraft
        occupied = true;
        System.out.println("Takeoff clearance granted to " + aircraftCallSign);
    }

    private void checkRunwaySystems() {
        if(!isLightingSystemOperational){
            throw new RunwayLightingNotOperationalException();
        }
    }

    public void releaseRunway() {
        System.out.println("Runway is now free.");
        occupied = false;
    }
}
