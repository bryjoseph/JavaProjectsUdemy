package com.interfacesAndAbstractClasses.astractClassChallenge;

public class Node extends ListItem {

    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem moveToNext() {
        return this.next;
    }

    @Override
    ListItem moveToPrevious() {
        return this.previous;
    }

    @Override
    ListItem setNext(ListItem item) {
        this.next = item;
        return this.next;
    }

    @Override
    ListItem setPrevious(ListItem item) {
        this.previous = item;
        return this.previous;
    }

    @Override
    int compareTo(ListItem itemToCompare) {
        // first pass at the sorting
//        int comparison = this.next.compareTo(itemToCompare);
//        if(comparison == 0) {
//            // 0 means the values are the same and return 0
//            return 0;
//        } else if (comparison > 0 ) {
//            // means the current value is alphabetically before the current itemToCompare
//            // Denver --> Atlanta (Atlanta compareTo(Denver) is greater than 0
//            return 1;
//        } else {
//            // means the current value is alphabetically after the current itemToCompare
//            return -1;
//        }
        if(itemToCompare.getValue() != null) {
            return ((String) super.getValue()).compareTo((String) itemToCompare.getValue());
        } else {
            return -1;
        }
    }
}
