package com.billsBurgers;

public class Hamburger {

    private String name;
    private String breadRoll;
    private String meat;
    private double price;

    private String topping1;
    private double topping1Price;

    private String topping2;
    private double topping2Price;

    private String topping3;
    private double topping3Price;

    private String topping4;
    private double topping4Price;

    public Hamburger(String name, String breadRoll, String meat, double price) {
        this.name = name;
        this.breadRoll = breadRoll;
        this.meat = meat;
        this.price = price;
    }

    public void addHamburgerTopping1(String name, double price) {
        this.topping1 = name;
        this.topping1Price = price;
    }

    public void addHamburgerTopping2(String name, double price) {
        this.topping2 = name;
        this.topping2Price = price;
    }

    public void addHamburgerTopping3(String name, double price) {
        this.topping3 = name;
        this.topping3Price = price;
    }

    public void addHamburgerTopping4(String name, double price) {
        this.topping4 = name;
        this.topping4Price = price;
    }

    public double itemizeHamburger() {
        double hamburgerPrice = this.price;
        System.out.println(this.name + " " + this.meat + " hamburger" + " on a " + this.breadRoll + " roll" + " is : $" + this.price);

        if(this.topping1 != null) {
            hamburgerPrice += this.topping1Price;
            System.out.println("Added " + this.topping1 + " to burger for $" + this.topping1Price);
        }

        if(this.topping2 != null) {
            hamburgerPrice += this.topping2Price;
            System.out.println("Added " + this.topping2 + " to burger for $" + this.topping2Price);
        }

        if(this.topping3 != null) {
            hamburgerPrice += this.topping3Price;
            System.out.println("Added " + this.topping3 + " to burger for $" + this.topping3Price);
        }

        if(this.topping4 != null) {
            hamburgerPrice += this.topping4Price;
            System.out.println("Added " + this.topping4 + " to burger for $" + this.topping4Price);
        }
        return hamburgerPrice;
    }

//    public double addLettuce() {
//        this.lettuce = true;
//        return this.price += .25;
//    }
//
//    public double addTomatoe() {
//        this.tomatoe = true;
//        return this.price += .50;
//    }
//
//    public double addOnion() {
//        this.onion = true;
//        return this.price += .50;
//    }
//
//    public double addMustard() {
//        this.mustard = true;
//        return this.price += .25;
//    }
//
//    public double totalPrice(double price) {
//        if(lettuce) {
//            addLettuce();
//        }
//        if(tomatoe) {
//            addTomatoe();
//        }
//        if(onion) {
//            addOnion();
//        }
//        if(mustard) {
//            addMustard();
//        }
//        return price;
//    }
}
