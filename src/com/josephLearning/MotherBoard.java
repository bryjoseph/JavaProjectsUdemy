package com.josephLearning;

public class MotherBoard {
    private String model;
    private String manufacturer;
    private int ramSlots;
    private int videoCardSlots;
    private String bios;

    public MotherBoard(String model, String manufacturer, int ramSlots, int videoCardSlots, String bios) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.ramSlots = ramSlots;
        this.videoCardSlots = videoCardSlots;
        this.bios = bios;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getRamSlots() {
        return ramSlots;
    }

    public int getVideoCardSlots() {
        return videoCardSlots;
    }

    public String getBios() {
        return bios;
    }

    public void loadProgram(String programName) {
        System.out.println("Load program " + programName + " is now loading...");
    }
}
