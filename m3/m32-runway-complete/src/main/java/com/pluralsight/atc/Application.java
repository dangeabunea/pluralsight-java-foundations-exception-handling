package com.pluralsight.atc;

public class Application {
    public static void main(String[] args) {
        RunwayManager runwayManager = new RunwayManager("LF1");

        runwayManager.requestTakeoff("AF123");

        // Unsupported operation
//        runwayManager.setClosed(true);
//        runwayManager.requestTakeoff("AF123");

        // Unsupported operation
//        runwayManager.requestTakeoff("AF123");
//        runwayManager.requestTakeoff("AF124");
    }
}
