package com.houseComposition;

public class Dresser {

    private String material;
    private int numberOfDrawers;
    private int height;
    private int width;

    public Dresser(String material, int numberOfDrawers, int height, int width) {
        this.material = material;
        this.numberOfDrawers = numberOfDrawers;
        this.height = height;
        this.width = width;
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

    public int getWidth() {
        return width;
    }

    public void closeDrawer() {
        System.out.println("The drawer is closed.");
    }
}
