package com.interfacesAndAbstractClasses.astractClassChallenge;

public class Robin extends Bird {

    public Robin(String name) {
        super(name);
    }

    // if the Robin class needed to implement a specific behavior, the override works nicely
    // if fly doesn't do anything different than the Bird.fly() this is not necessary
    @Override
    public void fly() {
        System.out.println(getName() + " is flying at 10mph");
    }
}
