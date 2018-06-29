package com.billsBurgers;

public class Main {

    public static void main(String[] args) {
        Hamburger hamburger = new Hamburger("Bill's Basic", "White", "Beef", 4.00);

        hamburger.addHamburgerTopping1("Tomato", .75);
        hamburger.addHamburgerTopping2("Onion", .25);
        hamburger.addHamburgerTopping3("Lettuce", .50);
        System.out.println("Total burger price is : $" + hamburger.itemizeHamburger());

        HealthyBurger healthyBurger = new HealthyBurger("Turkey", 5.00);
        healthyBurger.addHamburgerTopping3("Lettuce", .50);
        healthyBurger.addHamburgerTopping1("Lentils", 1.00);
        healthyBurger.addHamburgerTopping2("Wheat Grass", 1.00);
        System.out.println("Total burger price is : $" + healthyBurger.itemizeHamburger());

        DeluxBurger deluxBurger =  new DeluxBurger();
        deluxBurger.itemizeHamburger();
    }
}
