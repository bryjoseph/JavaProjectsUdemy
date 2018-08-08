package com.myLibrary;

public class SIBTest {

    public static final String owner;

    static {
        owner = "Tim";
        System.out.println("SIB -static initialization block called");
    }

    public SIBTest() {
        System.out.println("SIB constructor called");
    }

    static {
        System.out.println("Second SIB called");
    }

    public void someMethod() {
        System.out.println("Some method being called here");
    }
}
