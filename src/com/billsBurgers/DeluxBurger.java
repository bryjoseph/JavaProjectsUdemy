package com.billsBurgers;

public class DeluxBurger extends Hamburger {

    public DeluxBurger() {
        super("Bill's Delux", "White", "Beef", 8.50);
        super.addHamburgerTopping1("Fries", 3.50);
        super.addHamburgerTopping2("Drink", 1.75);
    }

    @Override
    public void addHamburgerTopping1(String name, double price) {
        System.out.println("Cannot add additional items to a delux burger");
    }

    @Override
    public void addHamburgerTopping2(String name, double price) {
        System.out.println("Cannot add additional items to a delux burger");
    }

    @Override
    public void addHamburgerTopping3(String name, double price) {
        System.out.println("Cannot add additional items to a delux burger");
    }

    @Override
    public void addHamburgerTopping4(String name, double price) {
        System.out.println("Cannot add additional items to a delux burger");
    }
}
