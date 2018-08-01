package com.interfacesAndAbstractClasses.astractClassChallenge;

public abstract class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }
    // because these methods have been declared public abstract the class extending Animal MUST implement them as well
    public abstract void eat();

    public abstract void breathe();

    public String getName() { return name; }
}
