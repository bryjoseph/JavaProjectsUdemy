package com.javaCollections;

import java.util.*;

public class Theatre {

    // this is an anonymous inner class implementing Comparator with the implementation of the compare method
    static final Comparator<Seat> PRICE_ORDER = new Comparator<Seat>() {
        @Override
        public int compare(Seat seat1, Seat seat2) {
            if(seat1.getPrice() < seat2.getPrice()) {
                return -1;
            } else if (seat1.getPrice() > seat2.getPrice()) {
                return 1;
            } else {
                return 0;
            }
        }
    };


    private final String theatreName;
     private List<Seat> seats = new ArrayList<>();
    // ArrayList can also be changed to LinkedList

    // private List<Seat> seats = new LinkedList<>();
    // can also be made more generic with a collection
    // using a Collection on the left allows for all types of data structure variations
    // private Collection<Seat> seats = new ArrayList<>();
    // HashSet
    // private Collection<Seat> seats = new HashSet<>();
    // LinkedHashSet
    // private Collection<Seat> seats = new LinkedHashSet<>();



    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows - 1);
        // instantiating a variable row with a char
        for(char row = 'A'; row <= lastRow; row++) {
            // instantiating a seatNum variable with the number 1
            for(int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                // instantiating a price for the seat
                double price = 12.00;
                // testing where the seat is in the theatre
                if((row < 'D') && (seatNum >= 4 && seatNum <= 9)) {
                    price = 14.00;
                } else if ((row > 'F') || (seatNum < 4 || seatNum > 9)) {
                    price = 7.00;
                }
                // this is the constructor for the Inner Class Seat going into a new Theatre
                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = new Seat(seatNumber, 0);
        // demonstrating a BinarySearch approach using java's Collections
        // going to return an int
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);

        if(foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is no matching seat with number: " + seatNumber);
            return false;
        }
        // demonstrating a brute force search approach
//        Seat requestedSeat = null;
//        for(Seat seat: seats) {
//            System.out.print(".");
//            if(seat.getSeatNumber().equals(seatNumber)) {
//                requestedSeat = seat;
//                break;
//            }
//        }
//        if(requestedSeat == null) {
//            System.out.println("There is no matching seat with number: " + seatNumber);
//            return false;
//        }
//        return requestedSeat.reserve();
    }

    // for testing purposes
    public Collection<Seat> getSeats() {
        return seats;
    }
//    public void getSeats() {
//        for(Seat seat: seats) {
//            System.out.println("Seat: " + seat.getSeatNumber());
//        }
//    }

    public class Seat implements Comparable<Seat> {

        private final String seatNumber;
        private double price;
        private boolean reserved = false;

        public Seat(String seatNumber, double price) {
            this.price = price;
            this.seatNumber = seatNumber;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public double getPrice() { return price; }

        public boolean reserve() {
            if(!this.reserved) {
                System.out.println("Seat " + seatNumber + " reserved");
                return this.reserved = true;
            } else {
                return false;
            }
        }

        public boolean cancel() {
            if(this.reserved) {
                System.out.println("The reservation of seat " + seatNumber + " is now cancelled");
                return this.reserved = false;
            } else {
                return false;
            }
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }
    }
}
