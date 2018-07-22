package com.bankingApplication;

import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name,double initialTransaction) {
        this.name = name;
        this.transactions = new ArrayList<>();
        addNewTransaction(initialTransaction);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    // behind the scenes this is an example of autoboxing (Double.doubleValue(?))
    public void addNewTransaction(double amount) {
        this.transactions.add(amount);
    }

    public static Customer createCustomer(String name, double initialTransaction) { return new Customer(name, initialTransaction); }
}
