package com.userInput;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

// first example of using the scanner class to read user input
//        System.out.println("Enter your year of birth:");
//
//        boolean hasNextInt = scanner.hasNextInt();
//
//        if(hasNextInt) {
//            int yearOfBirth = scanner.nextInt();
//            scanner.nextLine(); // handle next line character ENTER key and get to the next question
//
//            System.out.println("Enter your name: ");
//            String name = scanner.nextLine(); // handle the name
//
//            int age = 2018 - yearOfBirth;
//
//            if( age >= 0 && age <= 100) {
//                System.out.println("You entered " + name + "." + " Hello " + name + "." + " You are " + age);
//            } else {
//                System.out.println("Invalid year of birth");
//            }
//        } else {
//            System.out.println("Unable to parse year of birth");
//        }
//        scanner.close();

    // start user input challenge
//        int counter = 1;
////      int sum = 0;
////
////        while (counter < 11) {
////            System.out.println("Enter number for #" + counter + ":" + "\n" + "Current total = " + sum);
////
////            boolean hasNextInt = scanner.hasNextInt();
////
////            if (hasNextInt) {
////                int enteredNumber = scanner.nextInt();
////                sum += enteredNumber;
////                counter++;
////            } else {
////                System.out.println("Invalid number");
////            }
////            scanner.nextLine();
////        }
////        System.out.println("Total is : " + sum);
////        scanner.close();

    // third challenge Min and Max  for user input
    int min = 0;
    int max = 0;
    int counter = 1;
    boolean first = true;

    while(counter < 11) {
        System.out.println("Enter number for #" + counter + ":");

        boolean isInt = scanner.hasNextInt();

        if(isInt) {
            int enteredNumber = scanner.nextInt();

            if(first) {
                min = enteredNumber;
                max = enteredNumber;
                first = false;
            }

            if(enteredNumber > 0 && enteredNumber < max) {
                min = enteredNumber;
            } else if (enteredNumber > max) {
                max = enteredNumber;
            } else {
                scanner.nextLine();
            }
        } else {
            System.out.println("Not a valid number, please try again");
            scanner.nextLine();
        }
        System.out.println("Current min number is : " + min + " \nCurrent max is : " + max);
        counter++;
    }
    scanner.close();
    }
}
