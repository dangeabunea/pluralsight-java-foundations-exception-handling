package com.pluralsight.atc;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        RunwayManager runwayManager = new RunwayManager("LF1");
        try {
            runwayManager.requestTakeoff("AF123");
            runwayManager.requestTakeoff("AF124");
        } catch (RunwayOccupiedException e) {
            System.out.println(e.getMessage());
            Thread.sleep(3000);
            runwayManager.releaseRunway();
            runwayManager.requestTakeoff("AF124");
        }
    }
}
