package com.houseComposition;

public class Main {

    public static void main(String[] args) {

        Bed bed = new Bed("Queen", 12, "Oak");

        Dresser dresser = new Dresser("Oak", 6, 36, 48);

        NightTable nightTable = new NightTable("Oak", 2, 24);

        Bedroom bedroom =  new Bedroom(bed, dresser, nightTable);

        bedroom.furnishRoom();
    }
}
