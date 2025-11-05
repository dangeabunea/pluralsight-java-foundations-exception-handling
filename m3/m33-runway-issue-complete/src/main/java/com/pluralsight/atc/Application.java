package com.pluralsight.atc;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        RunwayManager runwayManager = new RunwayManager("LF1");

        runwayManager.setLightingSystemOperational(false);

        runwayManager.requestTakeoff("AF123");
    }
}
