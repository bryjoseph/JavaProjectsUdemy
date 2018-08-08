package com.myLibrary;

// package-private access
interface Accessible {

    // all interface variables are public static final
    int SOME_CONSTANT = 100;
    // methods in an interface are always public (hence the grey)
    public void methodA();
    // in an interface public
    void methodB();
    // public
    boolean methodC();

}
