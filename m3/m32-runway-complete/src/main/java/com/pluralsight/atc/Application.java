package com.pluralsight.atc;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        RunwayManager runwayManager = new RunwayManager("LF1");

        // Simulate runway si closed
        // runwayManager.setClosed(true);

        try {
            runwayManager.requestTakeoff("AF123");
            runwayManager.requestTakeoff("AF124");
        } catch (RunwayOccupiedException e) {
            System.out.println(e.getMessage());
            Thread.sleep(3000);

            // Simulate runway becomes free
            runwayManager.releaseRunway();

            runwayManager.requestTakeoff("AF124");
        }
        catch (UnsupportedOperationException e){
            System.out.println(e.getMessage());
        }
    }
}
