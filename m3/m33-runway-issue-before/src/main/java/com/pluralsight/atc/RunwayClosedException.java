package com.pluralsight.atc;

public class RunwayClosedException extends RuntimeException {
    public RunwayClosedException(String runwayId) {
        super("Runway " + runwayId + " is closed.");
    }
}

