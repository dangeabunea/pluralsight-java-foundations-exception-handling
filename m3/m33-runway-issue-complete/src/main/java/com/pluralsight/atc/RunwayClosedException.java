package com.pluralsight.atc;

public class RunwayClosedException extends RuntimeException {
    public RunwayClosedException(String runwayId) {
        super("Runway " + runwayId + " is closed.");
    }
    public RunwayClosedException(String runwayId, Throwable cause) {
        super("Runway " + runwayId + " is closed.", cause);
    }
}

