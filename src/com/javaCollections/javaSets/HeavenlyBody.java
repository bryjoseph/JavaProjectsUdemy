package com.javaCollections.javaSets;

import java.util.HashSet;
import java.util.Set;

// making a class final prevents subclassing
// removing final for Sets Code Challenge
// making HeavenlyBody abstract because only Planets, Dwarf Planets and Moon can be instantiated
public /*final*/ abstract class HeavenlyBody {

    // making all of the member variables final is following the immutable approach
    private final SolarSystemKey solarSystemKey;
    // private final String name; <--included in new inner class
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    // private final BodyTypes bodyType; <--included in new inner class

    // one benefit of using an enum is limiting the values to the options listed below
    public enum BodyTypes {
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTEROID
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        // this.name = name;
        // new inner class PRIVATE constructor called here
        this.solarSystemKey = new SolarSystemKey(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        // this.bodyType = bodyType;
        // again the immutable approach makes a copy of the private variable satellites
        this.satellites = new HashSet<>();
    }

    // getters NOT setters for immutability
    // public String getName() { return name; }
    public double getOrbitalPeriod() { return orbitalPeriod; }
    public SolarSystemKey getSolarSystemKey() { return solarSystemKey; }
    // public BodyTypes getBodyType() { return bodyType; }

    // returning a copy of satellites to block access to the original member variable satellites
    public Set<HeavenlyBody> getSatellites() { return new HashSet<>(this.satellites); }

    // the constructor is only needing the name and the orbitalPeriod
    public boolean addSatellite(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    @Override
    // marked equals as final to avoid problems with the method not being symmetric
    public final boolean equals(Object obj) {
        // if we pass in the same object as the one to compare, return true immediately
        if(this == obj) {
            return true;
        }
        // test code to show how many times equals is called
        // System.out.println("obj.getClass() is " + obj.getClass());
        // System.out.println("this.getClass() is " + this.getClass());

        // most likely the object to compare will not be null BUT
        // if the obj passed in != to this, return false
        // also line 50 is a cast to HeavenlyBody. If that class was null, this first check catches the null class
//        if((obj == null) || (obj.getClass() != this.getClass())) {
//            return false;
//        }
        // new comparison method because HeavenlyBody can now be extended
        // first check for subclass with instanceof
        if(obj instanceof HeavenlyBody) {
            HeavenlyBody theObject = (HeavenlyBody) obj;
            // if the subclass object happens to have the same name (which by code challenge could happen)
            // updated further
            // if(this.name.equals(theObject.getName())) {
                // the bodyType of the HeavenlyBody should NOT be the same
                // return this.bodyType == theObject.getBodyType();
                /**Last version of code update -- to reduce duplicate code -- have HeavenlyBody use the code from inner class SolarSystemKey **/
                return this.solarSystemKey.equals(theObject.getSolarSystemKey());
            //}
        }
        return false;
        // this includes the name comparison AND the bodyType comparison ^^^^^

        // First cast the obj to HeavenlyBody and compare the name values
//        String objName = ((HeavenlyBody) obj).getName();
//        return this.name.equals(objName);
    }

    // in this example only the String name is being compared. String methods already have a hashCode method call that will return an int
    // often the suggestion is to add 0 to the int that comes back from .hashCode() but it hampers the performance of Collections Set
    // adding 57 is small enough not to overload Integer but makes every instance of the HeavenlyBody class have a HashCode + 57;
    @Override
    // mark as final to avoid problems with hashCode not being symmetric
    public final int hashCode() {
        // test print code
        // System.out.println("HashCode() called");
        // enum use a hashCode as well so include to make the value unique
        /** Latest update to code -- reduce duplicate code -- use the hashCode() method from the inner class **/
        // return this.name.hashCode() + 57 + this.bodyType.hashCode();
        return this.solarSystemKey.hashCode();
    }

    @Override
    // toString is really meant for log files and debugging, but overriding this method gives a custom display of the HeavenlyBody object
    public String toString() {
        // return this.name + ": " + this.bodyType + ", " + this.orbitalPeriod;
        return this.solarSystemKey.name + ": " + this.solarSystemKey.bodyType + ", " + this.orbitalPeriod;
    }

    // method is static so you don't need a new instance of the Heavenly Body class to call this
    public static SolarSystemKey makeSolarSystemKey(String name, BodyTypes bodyType) {
        return new SolarSystemKey(name, bodyType);
    }

    // create a static final inner class of Key
    // this class is going to be the Key in a Java Map, so the class must be static final so it can't change
    public static final class SolarSystemKey {

        private String name;
        private BodyTypes bodyType;

        public SolarSystemKey(String name, BodyTypes bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        // getters
        public String getName() { return name; }
        public BodyTypes getBodyType() { return bodyType; }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + this.bodyType.hashCode();
        }

        @Override
        // check not needed here because it happens in the HeavenlyBody equals() override
        public boolean equals(Object obj) {
            SolarSystemKey solarSystemKey = (SolarSystemKey) obj;
            if(this.name.equals(solarSystemKey.getName())) {
                return (this.bodyType == solarSystemKey.getBodyType());
            } else {
                return false;
            }
        }

        @Override
        public String toString() {
            return this.name + ": " + this.bodyType;
        }
    }
}
