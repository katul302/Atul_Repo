package org.atulsharmaqaacademy.AbstractComponents;

import java.util.HashMap;

public interface SearchFlightAvail {

    void checkAvail(HashMap<String,String> reservationsdetails) throws InterruptedException;
}
