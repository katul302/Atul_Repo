package org.atulsharmaqaacademy.PageComponents;

import org.atulsharmaqaacademy.AbstractComponents.SearchFlightAvail;

public class MultiTrip implements SearchFlightAvail {


    @Override
    public void checkAvail(String origin, String destination) {
        System.out.println("I am inside Multi Trip");
    }
}
