package com.houseComposition;

public class Bed {

    private String size;
    private int heightOffGround;
    private String material;

    public Bed(String size, int heightOffGround, String material) {
        this.size = size;
        this.heightOffGround = heightOffGround;
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public int getHeightOffGround() {
        return heightOffGround;
    }

    public String getMaterial() {
        return material;
    }

    public void makeBed() {
        System.out.println("The bed is made.");
    }
}
