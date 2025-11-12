package com.pluralsight.atc;

public class Application {
    public static void main(String[] args) {
        RunwayManager runwayManager = new RunwayManager("LF1");
        runwayManager.setClosed(true);

        runwayManager.requestTakeoff("AF123");
    }
}
