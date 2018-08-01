package com.interfacesAndAbstractClasses.astractClassChallenge;

public class MyLinkedList implements NodeList  {

    private ListItem root = null;
    private ListItem end;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    // this method is absolute trash. Never, EVER write a function like this unless you want a dev to stab you in the eye
    @Override
    public boolean addItem(ListItem item) {
        // if the root is null, this is an empty MyLinkedList. First step is setting a root
        if(this.root == null) {
            this.root = item;
            return true;
        }

        // if it was not null, the compiler jumps to this code because the list was not empty and the new item needs to be sorted
        ListItem baseItem = this.root;

        while(baseItem != null) {
            // get the compareTo int value to use to navigate the various options
            int comparison = baseItem.compareTo(item);
            // < 0 means the current item is alphabetically after this item
            // Example: Tuscon (item) --comes after-- Seattle (baseItem);
            if(comparison < 0) {
                if(baseItem.next != null) {
                    // all this is doing (crapily) is setting the baseItem to the next value (IF) there is one
                    baseItem = baseItem.next;
                } else {
                    // if you reach here, this is the end of the LinkedList and the newItem needs to go here
                    baseItem.setNext(item);
                    // because EVERY item has a next && a previous
                    item.setPrevious(baseItem);
                    return true;
                }
            // > 0 means the current item is alphabetically before this item
            // Example: Denver (item) --comes before-- Seattle (baseItem);
            } else if (comparison > 0) {
                // checking if we are at the front of the LinkedList or not
                if(baseItem.previous != null) {
                    baseItem.previous.setNext(item).setPrevious(baseItem.previous);
                    item.setNext(baseItem).setPrevious(item);
                } else {
                    // the node withOUT (video had typo) a previous is the root (no fucking clue what that means, this is a terrible example)
                    item.setNext(this.root).setPrevious(item);
                    this.root = item;
                }
                return true;
            } else {
                // all the way down here in this shit show, the values are equal and do NOT get added to the LinkedList
                System.out.println("Value " + item.getValue() + " not added to the list");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if(item != null) {
            System.out.println("Deleting current item: " + item.getValue());
        }

        // The reason to do this is to start at the beginning of the linkedList
        // Making currentItem the root is the way to begin traversing the list
        ListItem currentItem = this.root;
        while(currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if(comparison == 0) {
                // this is a match in the list HOWEVER must check if this is also the root item in the list
                // if it is we need to remove the root item references to other items in the list
                if(currentItem == this.root) {
                    this.root = currentItem.next;
                } else {
                    currentItem.previous.setNext(currentItem.next);
                    // but WAIT there's more! Now we need to check the other reference for the item being removed
                    if(currentItem.next != null) {
                        currentItem.next.setPrevious(currentItem.previous);
                    }
                }
                return true;
            } else if (comparison < 0) {
                // means we have not found the item yet AND there other items to search...move to the next item in list
                currentItem = currentItem.next;
            } else {
                // comparison > 0 and this means in the sort we are past the point where a deletion could have happened
                // effectively the item we are looking to delete is not here
                return false;
            }
        }
        // to satisfy the method requirement the function did NOT find anything
        return false;
    }

    @Override
    public void traverse(ListItem root) {

        if(root == null) {
            System.out.println("The Linked List is empty");
        } else {
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next;
            }
        }

        // a way to recursively traverse the LinkedList
//        if(root != null) {
//            System.out.println(root.getValue());
//            traverse(root.next);
//        }


    }
}
