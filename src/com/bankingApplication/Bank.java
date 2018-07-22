package com.bankingApplication;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> bankBranches;

    public Bank(String name) {
        this.name = name;
        this.bankBranches = new ArrayList<>();
    }

    public ArrayList<Branch> getBankBranches() { return bankBranches; }

    // Adding to the ArrayList
    public boolean addNewBranch(String cityLocation) {

        if(queryBranchList(cityLocation) != null ) {
            System.out.println("Branch already exists for this bank at this location: " + cityLocation);
            return false;
        }
        System.out.println("Branch in the city " + cityLocation + " successfully added to bank");
        this.bankBranches.add(Branch.createBranch(cityLocation));
        return true;
    }

    // Searching the ArrayList to return customerName
    // return the Customer instance the user might search for
    private Branch queryBranchList(String cityLocation) {

        // could forEach here and save a little bit of time processing the command
        for(int i = 0; i < this.bankBranches.size(); i++) {
            Branch foundBranch = this.bankBranches.get(i);
            if(foundBranch.getCityLocation().equals(cityLocation)) {
                return foundBranch;
            }
        }
        return null;
    }

    public boolean addNewCustomerToBranch(String cityLocation, String customerName, double initialTransaction) {
        // find an existing branch based on cityLocation
        Branch foundBranch = queryBranchList(cityLocation);

        if(foundBranch != null) {
            return foundBranch.addNewBranchCustomer(customerName, initialTransaction);
        } else {
            System.out.println("Branch at location: " + cityLocation + " was not found");
            return false;
        }

// My first attempt at adding a new customer, to a branch, with an initial transaction amount. I violated several validation rules of OOD
//        if(foundBranch == null ) {
//            System.out.println("The branch location: " + cityLocation + " does exists for this bank");
//            return false;
//        } else {
//            // get the customer list of the matching, existing branch
//            ArrayList<Customer> branchCustomers = foundBranch.getBranchCustomers();
//            for (int i = 0; i < branchCustomers.size(); i++) {
//                // if there is a match of customer the customer already exists and cannot be added as a new customer
//                Customer searchedCustomer = branchCustomers.get(i);
//                if (searchedCustomer.getName().equals(customerName)) {
//                    System.out.println("The customer: " + customerName + " at: " + cityLocation + " already exists for this branch");
//                    return false;
//                } else {
//                    // else create the new customer, and add them to the branchCustomer arrayList
//                    System.out.println("The customer: " + customerName + " at: " + cityLocation + " successfully added to branch");
//                    branchCustomers.add(Customer.createCustomer(customerName, initialTransaction));
//                }
//            }
//            return true;
//        }
    }

    public boolean addCustomerTransation(String cityLocation, String customerName, double transactionAmount) {
        // find an existing branch based on cityLocation
        Branch foundBranch = queryBranchList(cityLocation);

        if(foundBranch != null) {
            return foundBranch.addCustomerTransaction(customerName, transactionAmount);
        } else {
            System.out.println("Branch at location: " + cityLocation + " was not found");
            return false;
        }
    }

    public boolean printBranchCustomerList(String cityLocation, boolean showTransactions) {
        Branch foundBranch = queryBranchList(cityLocation);

        if(foundBranch != null) {
            System.out.println("Customer details for branch " + foundBranch.getCityLocation());
            ArrayList<Customer> branchCustomers = foundBranch.getBranchCustomers();
            for (int i = 0; i < branchCustomers.size(); i++) {
                Customer branchCustomer = branchCustomers.get(i);
                if (showTransactions) {
                    System.out.println("Transactions" + " : " + branchCustomer.getName());
                    ArrayList<Double> customerTransactions = branchCustomer.getTransactions();
                    for(int j = 0; j < customerTransactions.size(); j++) {
                        System.out.println("Record [" + (j + 1) + "] : Amount " + customerTransactions.get(j));
                    }
                } else {
                    System.out.println("Customer #" + (i + 1) + " : " + branchCustomer.getName());
                }
            }
            return true;
        } else {
            System.out.println("Branch at location " + cityLocation + " not found");
            return false;
        }
    }

    public static Bank createBank(String name) { return new Bank(name); }
}
