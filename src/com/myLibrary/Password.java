package com.myLibrary;

public class Password {

    private static final int key = 1234567;
    private final int encryptedPassword;

    public Password(int password) {
        this.encryptedPassword = encryptPassword(password);
    }


    private int encryptPassword(int password) {
        return password ^ key;
    }

    // added final so that in a subclass this method could not be overridden
    public final void storePassword() {
        System.out.println("Password successfully stored");
    }

    public boolean letMeIn(int password) {
        if(encryptPassword(password) == encryptedPassword) {
            System.out.println("Welcome");
            return true;
        } else {
            System.out.println("Get the Eff out");
            return false;
        }
    }
}
