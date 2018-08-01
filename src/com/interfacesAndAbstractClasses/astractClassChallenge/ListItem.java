package com.interfacesAndAbstractClasses.astractClassChallenge;

public abstract class ListItem {

    protected ListItem previous = null;
    protected ListItem next = null;
    protected Object value;

    public ListItem(Object value) {
        this.value = value;
    }

    // Getter + Setter for value
    public Object getValue() { return value; }
    public void setValue(Object value) { this.value = value; }

    // abstract methods to be implemented by subclasses
    abstract ListItem moveToNext();
    abstract ListItem moveToPrevious();

    // setting the next + previous listItems implemented by subclasses
    abstract ListItem setNext(ListItem item);
    abstract ListItem setPrevious(ListItem item);

    // abstract returning the int value to be implemented in subclasses
    abstract int compareTo(ListItem itemToCompare);
}
