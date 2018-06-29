package com.billsBurgers;

public class HealthyBurger extends Hamburger {

    private String topping1;
    private double topping1Price;

    private String topping2;
    private double topping2Price;

    public HealthyBurger(String meat, double price) {
        super("Healthy", "Brown Rye", meat, price);
    }

    public void addHamburgerTopping1(String name, double price) {
        this.topping1 = name;
        this.topping1Price = price;
    }

    public void addHamburgerTopping2(String name, double price) {
        this.topping2 = name;
        this.topping2Price = price;
    }

    @Override
    public double itemizeHamburger() {
        double hamburgerPrice =  super.itemizeHamburger();

        if(this.topping1 != null) {
            hamburgerPrice += this.topping1Price;
            System.out.println("Added " + this.topping1 + " to burger for $" + this.topping1Price);
        }

        if(this.topping2 != null) {
            hamburgerPrice += this.topping2Price;
            System.out.println("Added " + this.topping2 + " to burger for $" + this.topping2Price);
        }
        return hamburgerPrice;
    }
}
