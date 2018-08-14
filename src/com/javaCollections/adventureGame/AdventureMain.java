package com.javaCollections.adventureGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdventureMain {

    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) {

        // to gather user input
        Scanner scanner =  new Scanner(System.in);

        Map<String, Integer> tempExits = new HashMap<>();
        // adding locations to the static locationMap
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", tempExits));

        // temporary placeholder map to pass to the constructor
        tempExits = new HashMap<>();
        // manually adding the exits to the location 1 in the locationsMap + quit
        tempExits.put("W", 2);
        tempExits.put("S", 4);
        tempExits.put("E", 3);
        tempExits.put("N", 5);
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building", tempExits));
        // the Q direction appears in every direction available. Better to move into the constructor
        // tempExits.put("Q", 0);

        // manually adding the exits to location 2 + quit
        // NOTE the new tempExits must be instantiated for each room
        tempExits = new HashMap<>();
        tempExits.put("N", 5);
        locations.put(2, new Location(2, "You are at the top of a hill", tempExits));
        // tempExits.put("Q", 0);

        // manually adding the exists to location 3 + quit
        // NOTE the new tempExits must be instantiated for each room
        tempExits = new HashMap<>();
        tempExits.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExits));
        // tempExits.put("Q", 0);

        // manually adding the exists to location 4 + quit
        // NOTE the new tempExits must be instantiated for each room
        tempExits = new HashMap<>();
        tempExits.put("W", 2);
        tempExits.put("N", 1);
        locations.put(4, new Location(4, "You are in a valley beside a stream", tempExits));
        // tempExits.put("Q", 0);

        // manually adding the exists to location 5 + quit
        // NOTE the new tempExits must be instantiated for each room
        tempExits = new HashMap<>();
        tempExits.put("W", 2);
        tempExits.put("S", 1);
        locations.put(5, new Location(5, "You are in the forrest", tempExits));
        // tempExits.put("Q", 0);

        // Code challenge to accept multiple commands from the user
        Map<String, String> vocabulary = new HashMap<>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("EAST", "E");
        vocabulary.put("WEST", "W");
        vocabulary.put("SOUTH", "S");

        // placeholder value
        int loc = 1;
        // in a while loop so that the user can keep picking directions
        while(true) {
            System.out.println(locations.get(loc).getLocationDescription());
            if(loc == 0) {
                break;
            }

            // creating a map to hold a COPY of the available exits (getExits makes a copy)
            Map<String, Integer> exits = locations.get(loc).getExits();

            System.out.print("Available exits are: ");
            for(String direction: exits.keySet()) {
                System.out.print(direction + " , ");
            }

            // creating a break in the line so the text isn't stacked on one another
            System.out.println();

            // direction here is the key in the exits Map
            String direction = scanner.nextLine().toUpperCase();

            if(direction.length() > 1) {
                // means the user entered a command longer than 1 letter
                String[] choices = direction.split(" ");
                // cycle through all of the words in the String[]
                for(String choice: choices) {
                    // now test each word against vocabulary
                    if(vocabulary.containsKey(choice)) {
                        // if there is a match on the key, make direction the single letter return value
                        direction = vocabulary.get(choice);
                        break;
                    }
                }
            }

            // my attempt at code challenge
//            String[] userInput = direction.split(" ");
//            for(String choice: userInput) {
//                if(choice.equalsIgnoreCase("East")) {
//
//                } else if (choice.equalsIgnoreCase("West")) {
//
//                } else if (choice.equalsIgnoreCase("North")) {
//
//                } else {
//                    choice = "South";
//                }
//            }

            // code will jump to here because the direction was one letter long ^^^^
            if(exits.containsKey(direction)) {
                // loc here will be an Integer because the value associated with the key N,S,E,W is an integer
                loc = exits.get(direction);
            } else {
                System.out.println("That is not a valid direction!");
            }
        }
    }
}
