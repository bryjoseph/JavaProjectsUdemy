package com.interfacesAndAbstractClasses;

public class MobilePhone implements ITelephone {

    private String myPhoneNumber;
    private boolean isRinging;
    private boolean isOn = false;

    public MobilePhone(String myPhoneNumber) {
        this.myPhoneNumber = myPhoneNumber;
    }

    // stubbed out placeholders using the generate "implement methods" option
    @Override
    public void powerOn() {
        isOn = true;
        System.out.println("Moble phone is powered and working properly");
    }

    @Override
    public void dial(String phoneNumber) {
        if(isOn) {
            System.out.println("Now dialing " + phoneNumber + " from office phone");
        } else {
            System.out.println("Phone is currently turned off");
        }
    }

    @Override
    public void answer() {
        if(isRinging) {
            System.out.println("Answering the mobile phone");
            isRinging = false;
        }
    }

    @Override
    public boolean callPhone(String phoneNumber) {
        if(!phoneNumber.equalsIgnoreCase(myPhoneNumber) && isOn) {
            System.out.println("Making a call to " + phoneNumber);
        } else {
            System.out.println("Phone is currently turned off or you are calling yourself");
            isRinging = false;
        }
        return false;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }
}
