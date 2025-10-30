package com.pluralsight.atc;

import java.util.List;

public class FlightTracker {
    public void trackFlights(List<String> callsigns) {
        callsigns.forEach(callsignStr -> {
            var callsign = new Callsign(callsignStr);
            System.out.println("Tracking flight " + callsign.getValue());
        });
    }
}
