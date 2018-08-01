package com.interfacesAndAbstractClasses.astractClassChallenge;

// abstract classes can extend other abstract classes
public abstract class Bird extends Animal implements CanFly {

    public Bird(String name) {
        super(name);
    }
    // this is the abstract method from the abstract class Animal
    @Override
    public void eat() {
        System.out.println(getName() + " is pecking");
    }
    // this is the abstract method from the abstract class Animal
    @Override
    public void breathe() {
        System.out.println("Still breathe in, still breathe out...Still repeat");
    }
    // the only method for this new abstract class called Bird
    // the problem here is not all birds can fly...the Abstract Class Bird requires a new class extending this to implement fly()
    // public abstract void fly();

    // implementing the interface now allows us to pick which Bird flies
    @Override
    public void fly() {
        System.out.println(getName() + " is flying");
    }
}
