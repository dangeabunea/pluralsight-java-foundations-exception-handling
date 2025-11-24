package com.pluralsight.atc;

public class Application {
    public static void main(String[] args) {
        RunwayManager runwayManager = new RunwayManager("LF1");

        // Simulate runway si closed
        runwayManager.setClosed(true);

        try {
            runwayManager.requestTakeoff("AF123");
            runwayManager.requestTakeoff("AF124");
        } catch (UnsupportedOperationException e){
            System.out.println(e.getMessage());
        }
    }
}
