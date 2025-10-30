package com.pluralsight.atc;

import java.util.List;

public class Application {
    public static void main(String[] args)
    {
        // Fetch callsigns
        List<String> callsignsFromExternalSystem = List.of(
                "AF123",
                "BA:7896",
                "X12",
                "RO6789",
                "TA-876"
        );

        FlightTracker flightTracker = new FlightTracker();
        flightTracker.trackFlights(callsignsFromExternalSystem);
    }
}
