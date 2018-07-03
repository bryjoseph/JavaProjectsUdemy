package com.userInput;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your year of birth:");
        int yearOfBirth = scanner.nextInt();
        scanner.nextLine(); // handle next line character ENTER key


        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        int age = 2018 - yearOfBirth;

        System.out.println("You entered " + name + "." + " Hello " + name + "." + " You are " + age);

        scanner.close();
    }
}
