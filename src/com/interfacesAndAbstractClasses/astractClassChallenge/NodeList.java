package com.interfacesAndAbstractClasses.astractClassChallenge;

public interface NodeList {

    // the interface my own MyLinkedList class will implement

    ListItem getRoot();
    boolean addItem(ListItem item);
    boolean removeItem(ListItem item);
    void traverse(ListItem root);

}
