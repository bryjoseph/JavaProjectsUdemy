package com.javaCollections.adventureGame;

import java.util.HashMap;
import java.util.Map;

public class Location {

    // the fields are final because they should not change once the constructor is finished
    private final int locationId;
    private final String locationDescription;
    private final Map<String, Integer> exits;

    // constructor
    public Location(int locationId, String locationDescription, Map<String, Integer> exits) {
        this.locationId = locationId;
        this.locationDescription = locationDescription;
        // new exits HashMap is instantiated on the next line to protect the field from getting changed elsewhere in code
        // there is also a bug in this constructor
        // at runtime if "null" is passed to the constructor for the exits map, the program will crash
        // add a check to look for a null value
        if(exits != null) {
            // create a new HashMap and pass in the exits
            this.exits = new HashMap<>(exits);
        } else {
            // create a new HaspMap here but without exits
            this.exits =  new HashMap<>();
        }
        // able to add the Q option to the existing HashMap
        this.exits.put("Q", 0);
    }

    public int getLocationId() { return locationId; }

    public String getLocationDescription() { return locationDescription; }

    // this getter is returning a copy of the exits because the original member variable is marked final
    // this approach protects the internal workings of the Location class from a 3rd party
    public Map<String, Integer> getExits() {
        return new HashMap<>(exits);
    }

    // add a key and value to the exits Map
    // NOTE because the exits Map has been added to the constructor, this method is no longer needed
//    public void addExits(String direction, int location) {
//        exits.put(direction, location);
//    }
}
