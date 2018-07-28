package com.interfacesAndAbstractClasses;


import java.util.ArrayList;

// a base class example
public class GearBox {

    private ArrayList<Gear> gears;
    private int maxGears;
    // changing name to remove "shadowing"
    // private int gearNumber;
    private int currentGear;
    private boolean clutchIsIn;

    public GearBox(int maxGears) {
        this.gears = new ArrayList<Gear>();
        this.maxGears = maxGears;
        this.currentGear = 0;
        // having the new Gear object here in the constructor allows access to the inner class (refactor to private access)
        Gear neutral = new Gear(0, 0.0);
        gears.add(neutral);
    }

    public void operateClutch(boolean in) {
        this.clutchIsIn = in;
    }

    public void addGear(int gearNumber, double ratio) {
        if((gearNumber > 0) && (gearNumber <= this.maxGears)) {
            this.gears.add(new Gear(gearNumber, ratio));
        }
    }

    public void changeGear(int gearNumber) {
        if((gearNumber >= 0) && (gearNumber <= this.maxGears) && (gearNumber != this.currentGear) && (clutchIsIn)) {
            this.currentGear = gearNumber;
            System.out.println("Changed gears to: " + gearNumber);
        } else {
            System.out.println("Gear did not change");
            this.currentGear = 0;
        }
    }

    public double wheelSpeed(int revs) {
        if(clutchIsIn) {
            System.out.println("Clutch is active");
            return 0.0;
        }
        return revs * gears.get(this.currentGear).getRatio();
    }

    // an example of an INNER CLASS
    // using an inner class depends on the context. If a class by itself makes no sense, it often becomes an inner class)
    // NOTE: The inner class Gear has access to all of the base class methods (INCLUDING methods marked as private)
    // changed to private -- method access is now restricted. User has access to GearBox --> GearBox has access to Gear
    private class Gear {
        // the property gearNumber is "shadowing" the property of gearNumber in GearBox
        private int gearNumber;
        private double ratio;

        private Gear(int gearNumber, double ratio) {
            this.gearNumber = gearNumber;
            this.ratio = ratio;
        }

        private double getRatio() { return ratio; }

        // a public method inside an inner class
        public double driveSpeed(int revs) {
            return revs * (this.ratio);
        }
    }
}
