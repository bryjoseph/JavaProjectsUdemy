package com.bankingApplication;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank("Broj United");

        bank.addNewBranch("Aurora");

        bank.addNewCustomerToBranch("Aurora", "Bryan", 10.00);
        bank.addNewCustomerToBranch("Aurora", "Lauren", 50.00);
        bank.addNewCustomerToBranch("Aurora", "Cobie", 100.00);

        bank.addNewBranch("Denver");
        bank.addNewCustomerToBranch("Denver", "Jack", 5.00);


        bank.addCustomerTransation("Aurora", "Bryan", 100.00);
        bank.addCustomerTransation("Aurora", "Lauren", 50.00);
        bank.addCustomerTransation("Denver", "Jack", 1.00);


        bank.printBranchCustomerList("Aurora", true);
        bank.printBranchCustomerList("Denver", true);

        //Tests for functions
        bank.addNewCustomerToBranch("Fort Collins", "Bob", 1000.00);
        bank.addCustomerTransation("Denver", "Will", 40.00);
        bank.printBranchCustomerList("Fort Collins", false);
        bank.addNewBranch("Denver");
        bank.addNewCustomerToBranch("Denver", "Jack", 100.00);

    }
}
