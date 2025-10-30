package com.pluralsight.atc;

public class RunwayClosedException extends Exception {
    public RunwayClosedException(String runwayId) {
        super("Runway " + runwayId + " is closed.");
    }
}

