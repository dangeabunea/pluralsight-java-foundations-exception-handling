package com.pluralsight.atc;

public class Application {
    public static void main(String[] args) {
        RunwayManager runwayManager = new RunwayManager("LF1");

        // Unsupported operation -> closed
        //runwayManager.setClosed(true);
        //runwayManager.requestTakeoff("AF123");

        // Unsupported operation -> occupied
        //runwayManager.requestTakeoff("AF123");
        //runwayManager.requestTakeoff("AF124");

//        try {
//            runwayManager.requestTakeoff("AF123");
//            runwayManager.requestTakeoff("AF124");
//        } catch (UnsupportedOperationException e){
//
//        }
    }
}
