package com.myLibrary;

import java.util.ArrayList;

public class Account {

    private String accountName;
    private int balance;
    private ArrayList<Integer> transactions;

    public Account(String accountName) {
        this.accountName = accountName;
        this.transactions = new ArrayList<>();
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if(amount > 0) {
            transactions.add(amount);
            this.balance += amount;
            System.out.println("Amount: $" + amount + " successfully deposited for a new balance of: $" + this.balance);
        } else {
            System.out.println("Cannot deposit negative sums");
        }
    }

    public void withdraw(int amount) {
        int withdrawn = -amount;
        if(withdrawn < 0) {
            this.balance += withdrawn;
            transactions.add(withdrawn);
            System.out.println("Amount: $" + amount + " successfully withdrawn from account. New balance: $" + this.balance);
        } else {
            System.out.println("Not enough funds in account");
        }
    }

    public void calculateBalance() {
        this.balance = 0;
        for(int i : this.transactions) {
            this.balance += i;
        }
        System.out.println("Calculated balance is: " + this.balance);
    }
}
