package com.interfacesAndAbstractClasses.astractClassChallenge;

import java.awt.*;

public class SearchTree implements NodeList {

    private ListItem root = null;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem item) {
        if(this.root == null) {
            this.root = item;
            return true;
        }

        ListItem currentItem = this.root;
        while(currentItem != null) {
            int comparison = currentItem.compareTo(item);

            if(comparison < 0 ) {
                // newItem is greater than currentItem...move to the right
                if(currentItem.next != null) {
                    // must perform check to see if there is a next on currentItem
                    currentItem = currentItem.next;
                } else {
                    // have reached the end (going right)
                    currentItem.setNext(item);
                    return true;
                }
            } else if (comparison > 0) {
                // newItem is less than currentItem and move to the left
                if(currentItem.previous != null) {
                    // must check if there is a previous first
                    currentItem = currentItem.previous;
                } else {
                    // there is nothing else to the left
                    currentItem.setPrevious(item);
                    return true;
                }
            } else {
                // comparison equals 0 and the values are equal (do not add to tree)
                System.out.println("Value " + item.getValue() + " already exists in tree");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {

        if(item != null) {
            System.out.println("Deleting item: " + item.getValue());
        }

        ListItem currentItem = this.root;
        ListItem parentItem = currentItem;

        while(currentItem != null) {
            int comparison = currentItem.compareTo(item);
            // newItem is greater than currentItem...move to the right
            if(comparison < 0) {
                parentItem = currentItem;
                currentItem = currentItem.next;
            } else if (comparison > 0) {
                parentItem = currentItem;
                currentItem = currentItem.previous;
            } else {
                // comparison has found the matching item to remove
                performRemoval(currentItem, parentItem);
                return true;
            }
        }
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        // recursive method
        if(root != null) {
            traverse(root.previous);
            System.out.println(root.getValue());
            traverse(root.next);
        }
    }

    private void performRemoval(ListItem parentItem, ListItem item) {
        // remove item from tree
        if(item.next == null) {
            // no right tree, make parent point to the left tree
            if(parentItem.next == item) {
                // item is right child of its parent
                parentItem.setNext(item.previous);
            } else if(parentItem.previous == item) {
                // item is left child of its parent
                parentItem.setPrevious(item.previous);
            } else {
                // parent must be item and this is the root of the tree
                this.root = item.previous;
            }
        } else if(item.previous == null) {
            // no left tree, make parent point to the right tree
            if(parentItem.next == item) {
                // item is right child of its parent
                parentItem.setNext(item.next);
            } else if (parentItem.previous == item) {
                // item is left child of its parent
                parentItem.setPrevious(item.next);
            } else {
                // parent must be item and this is the root of the tree
                this.root = item.next;
            }
        } else {
            // at this point the left and the right are not null
            // From the right tree find the smallest value
            ListItem currentItem = item.next;
            ListItem leftMostParent = item;
            while(currentItem.previous != null) {
                leftMostParent = currentItem;
                currentItem = currentItem.previous;
            }
            // put the smallest value into the node to be deleted
            item.setValue(currentItem.getValue());
            // and delete the smallest
            if (leftMostParent == item) {
                // there was no leftmost node, so current points to the smallest value to be deleted
                item.setNext(currentItem.next);
            } else {
                // set the smallest node's parent to point to the smallest right child
                leftMostParent.setPrevious(currentItem.next);
            }
        }
    }
}
