package com.pluralsight.atc;

import java.util.List;

public class FlightTracker {
    public void trackFlights(List<String> callsigns) {
        callsigns.forEach(callsignStr -> {
            try {
                var callsign = new Callsign(callsignStr);
                System.out.println("Tracking flight " + callsign.getValue());
            }
            catch (IllegalArgumentException ex) {
                System.out.println("Error tracking flight "
                        + callsignStr
                        + ":" + ex.getMessage());
            }
        });
    }
}
