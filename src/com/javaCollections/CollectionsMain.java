package com.javaCollections;

import java.util.*;

public class CollectionsMain {

    public static void main(String[] args) {

//        Theatre theatre =  new Theatre("ShowTime", 8, 12);
//        // theatre.getSeats();
//
//        if(theatre.reserveSeat("H11")) {
//            System.out.println("Please pay for seat reservation");
//        } else {
//            System.out.println("Sorry the seat is already reserved");
//        }
//
//        // to print the list of created seats
//        List<Theatre.Seat> seats = new ArrayList<>(theatre.getSeats());
//        printSeatList(seats);
//        // copy of list above but going to organize on seat price
//        List<Theatre.Seat> priceSeats = new ArrayList<>(theatre.getSeats());
//        // Seat is an inner class hence the syntax
//        // NOTE with the sorted list on price, B00 was added before A00 and will show first
//        // elements in the list are NOT swapped if they don't need to be. $13 == $13 returns 0 for compare()
//        priceSeats.add(theatre.new Seat("B00", 13.00));
//        priceSeats.add(theatre.new Seat("A00", 13.00));
//
//        Collections.sort(priceSeats, Theatre.PRICE_ORDER);
//        printSeatList(priceSeats);

        Map<String, String> languages = new HashMap<>();
        languages.put("Java", " a compiled high level, object-oriented, platform independent language");
        languages.put("Python", " an interpreted, object-oriented high level programming language with dynamic semantics");
        languages.put("Algol", " algorithmic language");
        languages.put("BASIC", "Beginners All-purpose Symbolic Instruction Code");
        languages.put("Lisp", " down this path lies madness");

        System.out.println(languages.get("Java"));

        // contains can be used to check if a value already existxs for a key
        if(languages.containsKey("Java")) {
            System.out.println("The Java key-value already exists");
        } else {
            languages.put("Java", " same message as above");
        }

        // remove function to remove a key from the Map
        // languages.remove("Lisp");
        // another way is to check the key/value pairing
        if(languages.remove("Algol", "a family of algorithmic languages")) {
            System.out.println("Lisp removed successfully");
        } else {
            // should not execute the remove because the pairing is not found
            System.out.println("Lisp key/value pairing not found");
        }

        // replace function
        System.out.println(languages.replace("Lisp", " a functional programming language with imperative features"));
        System.out.println(languages.replace("Scala", " this will not happen because there is no key Scala"));
        // can also check a value before replacing in the Map
        if(languages.replace("Lisp", " this will not work", " will not replace because the old value is not accurate")) {
            System.out.println("Lisp not replaced");
        } else {
            System.out.println("Somehow you got this to work");
        }


        // demonstrate how to loop through the values of a HashMap
        System.out.println("=================================================");
        for(String key: languages.keySet()) {
            System.out.println(key + " : " + languages.get(key));
        }
    }

    public static void printSeatList(List<Theatre.Seat> seats) {
        for(Theatre.Seat seat: seats) {
            System.out.println(seat.getSeatNumber() + " " + "$" + seat.getPrice());
        }
        System.out.println("====================================================");
    }
}
