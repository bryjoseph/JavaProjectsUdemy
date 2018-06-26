package com.houseComposition;

public class NightTable {

    private String material;
    private int numberOfDrawers;
    private int height;

    public NightTable(String material, int numberOfDrawers, int height) {
        this.material = material;
        this.numberOfDrawers = numberOfDrawers;
        this.height = height;
    }

    public String getMaterial() {
        return material;
    }

    public int getNumberOfDrawers() {
        return numberOfDrawers;
    }

    public int getHeight() {
        return height;
    }

    public void tipOverNightTable() {
        System.out.println("The table has been tipped!");
    }
}
