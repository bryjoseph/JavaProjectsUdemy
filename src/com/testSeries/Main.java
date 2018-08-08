package com.testSeries;

import com.myLibrary.Account;
import com.myLibrary.SIBTest;
import com.myLibrary.Series;
import com.myLibrary.X;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        for(int i =0; i <= 10; i++) {
//            System.out.println(Series.nSum(i));
//        }
//
//        System.out.println("*****************************");
//
//        for(int i = 0; i <= 10; i++) {
//            System.out.println(Series.factoral(i));
//        }
//
//        System.out.println("*****************************");
//
//        for(int i = 0; i <= 10; i++) {
//            System.out.println(Series.fibonacci(i));
//        }
//
//        System.out.println("*****************************");
//
//        X x = new X(new Scanner(System.in));
//        x.x();

//        Account bryansAccount = new Account("Bryan");
//        bryansAccount.deposit(100);
//        bryansAccount.calculateBalance();
//        bryansAccount.deposit(100);
//        bryansAccount.calculateBalance();
//        bryansAccount.withdraw(50);
//        bryansAccount.calculateBalance();
//        bryansAccount.withdraw(200);
//        bryansAccount.calculateBalance();

        // because the fields are public I can openly access the property and change the value
        // bryansAccount.balance = 5000;

        System.out.println("main() method from Main Class called");

        SIBTest sibTest = new SIBTest();
        sibTest.someMethod();
        System.out.println("Test owner is " + SIBTest.owner);
    }
}
