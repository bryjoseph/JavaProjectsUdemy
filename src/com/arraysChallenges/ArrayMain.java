package com.arraysChallenges;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayMain {

    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();
    private static MobilePhone contactList = new MobilePhone("521_310_2233");

    public static void main(String[] args) {

        // array challenge 1 (sort the array in descending order)
//        int[] myIntArray = getIntegers(5);
//        int[] mySortedIntArray = sortIntegers(myIntArray);
//        printArray(mySortedIntArray);

        // array challenge 2 (find the minimum value in the array)
//        int[] newIntArray = readIntegers(5);
//        int returnedValue = findMin(newIntArray);
//        int altReturnedValue = findMinValue(newIntArray);
//        printMin(returnedValue);
//        printMin(altReturnedValue);

        // array challenge 3 (reverse an array)
//        int[] reverseChallengeArray = readIntegers(5);
//        printArray(reverseChallengeArray);
//        reverse(reverseChallengeArray);
//        printArray(reverseChallengeArray);

        // alternate array challenge 3 (again reverse an array)
//        int[] testArray = {1,2,3,4,5};
//        System.out.println(Arrays.toString(testArray));
//        arrayReverse(testArray);
//        System.out.println(Arrays.toString(testArray));

        // ArrayList challenges 1 (Grocery List)
//        boolean quit = false;
//        int choice;
//        printInstructions();
//
//        while(!quit) {
//            System.out.println("Enter your choice: ");
//            choice = scanner.nextInt();
//            scanner.nextLine();
//
//            switch(choice) {
//                case 0:
//                    printInstructions();
//                    break;
//                case 1:
//                    groceryList.printGroceryList();
//                    break;
//                case 2:
//                    addGroceryItem();
//                    break;
//                case 3:
//                    updateGroceryList();
//                    break;
//                case 4:
//                    removeGroceryItem();
//                    break;
//                case 5:
//                    findGroceryItem();
//                    break;
//                case 6:
//                    quit = true;
//                    break;
//            }
//        }


      // ArrayList challenge 2 (Contact List)
        boolean quit = false;
        int choice;
        printMobilePhoneInstructions();

        while(!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 0:
                    printMobilePhoneInstructions();
                    break;
                case 1:
                    contactList.printContactList();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }
    }

    public static int[] getIntegers(int count) {
        int[] array = new int[count];

        System.out.println("Enter " + count + " numbers to create an array of that length: \r");

        for(int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void printArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.println("The value at index " + i + " is " + array[i]);
        }
    }

    public static int[] sortIntegers(int[] unsortedArray) {
        int[] sortedArray = new int[unsortedArray.length];

        // manually demonstrating copying an array instead of System.array.copy();
        for(int i = 0; i < unsortedArray.length; i++) {
            sortedArray[i] = unsortedArray[i];
        }

        boolean flag = true;
        int temp;

        while(flag) {
            flag = false;
            for(int i = 0; i < sortedArray.length - 1; i++) {
                // ordering the numbers in descending order (highest to lowest))
                if(sortedArray[i] < sortedArray[i + 1]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    flag = true;
                }
            }
        }
        return sortedArray;
    }

    public static int[] readIntegers(int count) {
        int[] array = new int[count];

        System.out.println("Enter " + count + " numbers to create an array of that length: \r");

        for(int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    // this approach (I wrote) sorts the array in ascending order and takes the first index value
    public static int findMin(int[] exampleArray) {
        // making a copy of the array passed in to sort the array
        int[] unsortedArray = Arrays.copyOf(exampleArray, exampleArray.length);

        boolean flag = true;
        int temp;

        while(flag) {
            flag = false;
            for(int i = 0; i < unsortedArray.length - 1; i++) {
                // ordering the numbers in ascending order (lowest to highest))
                if(unsortedArray[i] > unsortedArray[i + 1]) {
                    temp = unsortedArray[i + 1];
                    unsortedArray[i] = unsortedArray[i + 1];
                    unsortedArray[i] = temp;
                    flag = true;
                }
            }
        }
        return unsortedArray[0];
    }

    // this approach does not sort the array and take the first index, this finds the min value
    private static int findMinValue(int[] unsortedArray) {
        // setting the min value to the largest possible number a user can enter because
        // no matter what is entered the value will be less than the MAX_VALUE property
        int min = Integer.MAX_VALUE;

        for(int i =0; i < unsortedArray.length; i++) {
            // value represents the value in the array we want to compare
            int value = unsortedArray[i];

            // check to see if the current value in the array is LESS THAN the current value of min
            if(value < min) {
                min = value;
            }
        }
        return min;
    }

    public static void printMin(int min) {
        System.out.println("The value at index 0 is " + min);
    }

    // my solution using a copied version of the array and swapping values
    public static int[] reverse(int[] forwardArray) {
        int[] reverseArray = Arrays.copyOf(forwardArray, forwardArray.length);

        for(int i = 0; i < forwardArray.length; i++) {
            // temporarily store the first value of the normal array
            int temp = forwardArray[i];
            // basically the first index value now becomes the last index value of the new array
            forwardArray[i] = reverseArray[reverseArray.length - i - 1];
            // now the end of second array needs to become the first value of original
            reverseArray[reverseArray.length - i - 1] = temp;
        }
        return reverseArray;
    }

    public static void arrayReverse(int[] forwardArray) {
        // no declaration of a copy array
        int maxIndex = forwardArray.length - 1;
        int halfLength = forwardArray.length / 2;

        // essentially using a variable doing the length - 1 instead of typing it
        for(int i = 0; i < halfLength; i++) {
            int temp = forwardArray[i];
            forwardArray[i] = forwardArray[maxIndex - i];
            forwardArray[maxIndex - i] = temp;
        }
    }

    public static void printInstructions() {
        System.out.println("\n Press one option to continue ");
        System.out.println("\t Press 0 - To print the user options");
        System.out.println("\t Press 1 - To print the grocery list");
        System.out.println("\t Press 2 - To add an item to the grocery list");
        System.out.println("\t Press 3 - To modify an item on the grocery list");
        System.out.println("\t Press 4 - To remove an item from the grocery list");
        System.out.println("\t Press 5 - To search for an item on the grocery list");
        System.out.println("\t Press 6 - To quit the application");
    }

    public static void addGroceryItem() {
        System.out.print("Please enter the item to add: ");
        groceryList.addGroceryItem(scanner.nextLine());
    }

    public static void updateGroceryList() {
        System.out.print("Enter the original name of the item to update: ");
        String itemName = scanner.nextLine();
        System.out.print("Next enter the updated information: ");
        String newItemName = scanner.nextLine();
        groceryList.updateGroceryList(itemName, newItemName);
    }

    public static void removeGroceryItem() {
        System.out.print("Please enter the item name to remove: ");
        String itemName = scanner.nextLine();
        groceryList.removeGroceryItem(itemName);
    }

    public static void findGroceryItem() {
        System.out.print("Please enter the name of the grocery item to find: ");
        String findItem = scanner.nextLine();
        if(groceryList.findGroceryItem(findItem) != null) {
            System.out.println("Item " + findItem + " found on grocery list");
        } else {
            System.out.println(findItem + " not found on list");
        }
    }

    public static void printMobilePhoneInstructions() {
        System.out.println("\n Press one option to continue ");
        System.out.println("\t Press 0 - To print the user options");
        System.out.println("\t Press 1 - To print the mobile contact list");
        System.out.println("\t Press 2 - To add a contact to the contact list");
        System.out.println("\t Press 3 - To modify a contact on the contact list");
        System.out.println("\t Press 4 - To remove a person from the contact list");
        System.out.println("\t Press 5 - To search for an person on the contact list");
        System.out.println("\t Press 6 - To quit the application");
    }

    private static void addContact() {
        System.out.print("Please enter the new contact name: ");
        String contactName = scanner.nextLine();
        System.out.println(" and contact number: ");
        String contactNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(contactName, contactNumber);
        if(contactList.addMobileContact(newContact)) {
            System.out.println("Action completed");
        } else {
            System.out.println("Action cancelled");
        }

    }

    public static void updateContact() {
        // first gather the name of the contact the user wants to update
        System.out.print("Enter the original name of the contact to update: ");
        String oldContactName = scanner.nextLine();
        // new private method to return the contact instance for the name passed in
        Contact oldContact = contactList.queryContactList(oldContactName);

        if(oldContactName == null) {
            // if null, a match not found, and the update cannot take place
            System.out.println("No contact was found with that name");
        }
        // if not null there was a match and the update can proceed
        System.out.print("Next enter the updated name: ");
        String newContactName = scanner.nextLine();
        System.out.print("Finally enter the updated number: ");
        String newContactNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newContactName, newContactNumber);
        if(contactList.updateContactList(oldContact, newContact)) {
            System.out.println("Action completed");
        } else {
            System.out.println("Action cancelled");
        }
    }

    public static void removeContact() {
        System.out.print("Please enter the contact to remove: ");
        String contactName = scanner.nextLine();

        Contact contactToRemove = contactList.queryContactList(contactName);
        if(contactName == null) {
            System.out.println("A contact was not found with that name");
        }

        if(contactList.removeContact(contactToRemove)) {
            System.out.println("Action completed");
        } else {
            System.out.println("Action cancelled");
        }
    }

    public static void queryContact() {
        System.out.print("Please enter a contact name to query: ");
        String contactName = scanner.nextLine();

        Contact contactToQuery = contactList.queryContactList(contactName);

        if (contactName == null) {
            System.out.println("A contact was not found with that name");
        }
        System.out.println("Contact information found: " + contactToQuery.getName() + " --> " + contactToQuery.getNumber());
    }
}
