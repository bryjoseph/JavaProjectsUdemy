package com.interfacesAndAbstractClasses;

public interface ITelephone {
    // because the class is going to implement the interface, public or private are redundant
    void powerOn();
    void dial(String phoneNumber);
    void answer();
    boolean callPhone(String phoneNumber);
    boolean isRinging();
}
