package com.houseComposition;

public class Bedroom {

    private Bed bed;
    private Dresser dresser;
    private NightTable nightTable;

    public Bedroom(Bed bed, Dresser dresser, NightTable nightTable) {
        this.bed = bed;
        this.dresser = dresser;
        this.nightTable = nightTable;
    }

    public void furnishRoom() {
        bed.makeBed();
        dresser.closeDrawer();
        nightTable.tipOverNightTable();
    }
}
