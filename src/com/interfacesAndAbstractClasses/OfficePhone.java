package com.interfacesAndAbstractClasses;

public class OfficePhone implements ITelephone {

    private String myPhoneNumber;
    private boolean isRinging;

    public OfficePhone(String myPhoneNumber) {
        this.myPhoneNumber = myPhoneNumber;
    }

    // stubbed out placeholders using the generate "implement methods" option
    @Override
    public void powerOn() {
        System.out.println("Phone is always powered, no action taken");
    }

    @Override
    public void dial(String phoneNumber) {
        System.out.println("Now dialing " + phoneNumber + " from office phone");
    }

    @Override
    public void answer() {
        if(isRinging) {
            System.out.println("Answering the office phone");
            isRinging = false;
        }
    }

    @Override
    public boolean callPhone(String phoneNumber) {
        if(!phoneNumber.equalsIgnoreCase(myPhoneNumber)) {
            System.out.println("Making a call to " + phoneNumber);
        } else {
            isRinging = false;
        }
        return false;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }
}
