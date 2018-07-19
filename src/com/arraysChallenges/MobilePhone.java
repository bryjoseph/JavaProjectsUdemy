package com.arraysChallenges;

import java.util.ArrayList;

public class MobilePhone {

    private String myNumber;
    private ArrayList<Contact> contacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.contacts = new ArrayList<>();
    }

    // Getting from ArrayList
    public void printContactList() {
        System.out.println("You have " + this.contacts.size() + " contact(s) on your mobile phone");
        for(int i = 0; i < this.contacts.size(); i++) {
            System.out.println((i +1) + " : " + this.contacts.get(i).getName() + " --> " + this.contacts.get(i).getNumber());
        }
    }

    // Add to the ArrayList
    public boolean addMobileContact(Contact contact) {

        if(findContact(contact.getName()) >= 0 ) {
            System.out.println("Contact already exists in contact list.");
            return false;
        }
        System.out.println("Contact " + contact.getName() + " with number " + contact.getNumber() + " added to contact list");
        contacts.add(contact);
        return true;
    }

    // it is a better practice to allow the program to locate the index instead of the user
    public boolean updateContactList(Contact oldName, Contact newName) {
        // separate the finding out into it's own function --call here
        int positionIndex = findContactIndex(oldName);
        if(positionIndex < 0) {
            System.out.println(oldName.getName() + " was not found in contact list");
            return false;
        } else if(findContact(oldName.getName()) != -1) {
            System.out.println("Contact with name " + newName.getName() + " already exits. Update not successful");
            return false;
        } else {
            this.contacts.set(positionIndex, newName);
            System.out.println("Old contact: " + oldName.getName() + " was replaced with: " + newName.getName());
            return true;
        }
    }

    // Updating an ArrayList
//    private void updateContactList(int position, String newContact) {
//        contacts.set(position, newContact);
//        System.out.println("Contact at position " + (position + 1) + " has been modified.");
//    }

    // again better practice to let the program find the index position not the user
    public boolean removeContact(Contact contactName) {
        // separate the finding out into it's own function --call here
        int positionIndex = findContactIndex(contactName);
        if(positionIndex >= 0) {
            removeContact(positionIndex);
            System.out.println("Contact with the name " + contactName.getName() + " was deleted");
            return true;
        } else {
            System.out.println("Did not find contact with the name " + contactName.getName() + " in contact list");
            return false;
        }
    }

    // Removing from an ArrayList
    private void removeContact(int position) {
        this.contacts.remove(position);
    }

    // Searching an ArrayList
    private int findContact(String searchedContact) {

        for(int i = 0; i < this.contacts.size(); i++) {
            Contact contact = this.contacts.get(i);
            if(contact.getName().equals(searchedContact)) {
                return i;
            }
        }
        return -1;
    }

    // a modified version of the find item returning an int of the item index
    private int findContactIndex(Contact contact) {
        return this.contacts.indexOf(contact);
    }

    // instead of returning an int from the find process, this method returns the name a person might search for
    public String queryContactList(Contact contact) {
        if(findContact(contact.getName()) >= 0) {
            return contact.getName();
        }
        return null;
    }

    // instead of returning an int or a boolean, this method returns the Contact instance a person might search for
    public Contact queryContactList(String contactName) {
        int indexPosition = findContact(contactName);
        if(indexPosition < 0) {
            return null;
        } else {
            return this.contacts.get(indexPosition);
        }
    }
}
