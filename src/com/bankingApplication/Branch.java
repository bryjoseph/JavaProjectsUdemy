package com.bankingApplication;

import java.util.ArrayList;

public class Branch {

    private String cityLocation;
    private ArrayList<Customer> branchCustomers;

    public Branch(String cityLocation) {
        this.cityLocation = cityLocation;
        this.branchCustomers = new ArrayList<>();
    }

    // Getters
    public ArrayList<Customer> getBranchCustomers() { return branchCustomers; }

    public String getCityLocation() { return cityLocation; }

    // Adding to the ArrayList
    public boolean addNewBranchCustomer(String customerName, double initialTransactionAmount) {

        if(queryCustomerList(customerName) != null ) {
            System.out.println("Customer already exists for this branch");
            return false;
        } else {
            System.out.println("Customer " + customerName + " successfully added to branch");
            this.branchCustomers.add(Customer.createCustomer(customerName, initialTransactionAmount));
            return true;
        }
    }

    // Searching the ArrayList to return customerName
    // return the Customer instance the user might search for
    private Customer queryCustomerList(String customerName) {

        // could forEach here and save a little bit of time processing the command
        for(int i = 0; i < this.branchCustomers.size(); i++) {
            Customer foundCustomer = this.branchCustomers.get(i);
            if(foundCustomer.getName().equals(customerName)) {
                return foundCustomer;
            }
        }
        return null;
    }

    public boolean addCustomerTransaction(String customerName, double transactionAmount) {
        Customer existingCustomer = queryCustomerList(customerName);
        if(existingCustomer != null ) {
            existingCustomer.addNewTransaction(transactionAmount);
            System.out.println("Successfully added transaction amount: " + transactionAmount + " for customer: " + customerName);
            return true;
        } else {
            System.out.println("Customer does not exists at this branch, and transaction failed");
            return false;
        }
    }

    public static Branch createBranch(String cityLocation) { return new Branch(cityLocation); }
}
