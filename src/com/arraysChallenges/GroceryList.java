package com.arraysChallenges;

import java.util.ArrayList;

public class GroceryList {
    // old way of instantiating an array
    // still a basic array (type string) with a FIXED 10 index spots
    private String[] myOldList = new String[10];

    // instantiate the class ArrayList
    // () at the end is part of a constructor so at the moment nothing is inside the data structure
    // also, no need to define the size because ArrayList can change dynamically
    private ArrayList<String> groceryList = new ArrayList<>();


    // Demonstrating the methods already created for ArrayList

    // Add to ArrayList
    public void addGroceryItem(String item) {
        groceryList.add(item);
    }

    // Getting from ArrayList
    public void printGroceryList() {
        System.out.println("You have " + groceryList.size() + " item(s) in your current grocery list");
        for(int i = 0; i < groceryList.size(); i++) {
            System.out.println((i +1) + " : " + groceryList.get(i));
        }
    }

    // it is a better practice to allow the program to locate the index instead of the user
    public void updateGroceryList(String oldName, String newName) {
        // separate the findGroceryItemIndex out into it's own function --call here
        int positionIndex = findGroceryItemIndex(oldName);
        if(positionIndex >= 0) {
            updateGroceryList(positionIndex, newName);
        }
    }

    // Updating an ArrayList
    private void updateGroceryList(int position, String newItem) {
        groceryList.set(position, newItem);
        System.out.println("Grocery item at position " + (position + 1) + " has been modified.");
    }

    // again better practice to let the program find the index position not the user
    public void removeGroceryItem(String itemName) {
        // separate the findGroceryItemIndex out into it's own function --call here
        int positionIndex = findGroceryItemIndex(itemName);
        if(positionIndex >= 0) {
            removeGroceryItem(positionIndex);
        }
    }

    // Removing from an ArrayList
    private void removeGroceryItem(int position) {
        groceryList.remove(position);
    }

    // Searching an ArrayList
    public String findGroceryItem(String searchItem) {
        // a quick option to see if an item exists inside the groceryList
        // boolean exists = groceryList.contains(searchItem);

        // or find the index of the item passed in
        int position = groceryList.indexOf(searchItem);
        // one line return
        if(position >= 0) return groceryList.get(position);
        // else
        return null;
    }

    // a modified version of the find item returning an int of the item index
    private int findGroceryItemIndex(String item) {
        return groceryList.indexOf(item);
    }
}
