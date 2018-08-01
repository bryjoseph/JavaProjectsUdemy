package com.interfacesAndAbstractClasses.astractClassChallenge;

public class Main {

    public static void main(String[] args) {
//        Dog dog = new Dog("Yorkie");
//
//        dog.eat();
//        dog.breathe();
//
//        // cannot instantiate an abstract class
//        //Bird bird = new Bird("Robin");
//        Robin robin = new Robin("Fred");
//        robin.eat();
//        robin.breathe();
//        robin.fly();

        MyLinkedList list = new MyLinkedList(null);
        MyLinkedList list2 = new MyLinkedList(null);
        SearchTree tree = new SearchTree(null);
        // blank list first
        list.traverse(list.getRoot());
        list2.traverse(list2.getRoot());
        tree.traverse(tree.getRoot());

        // to fill the list
        String stringData = "Seattle Portland SanFransisco Sacramento Denver Austin Dallas SanAntonio Houston";
        // to check removal
        String stringData2 = "5 8 7 3 1 9 0 4 6";
        // tree String
        String stringData3 = "5 8 7 3 1 9 0 4 6";

        String[] data = stringData.split(" ");

        for(String s : data) {
            list.addItem(new Node(s));
        }

        // testing removal
        String[] data2 = stringData2.split(" ");

        for(String s : data2) {
            list2.addItem(new Node(s));
        }

        // testing tree
        String[] data3 = stringData3.split(" ");

        for(String s : data3) {
            tree.addItem(new Node(s));
        }

        list.traverse(list.getRoot());
        list2.traverse(list2.getRoot());

        list2.removeItem(new Node("3"));
        list2.traverse(list2.getRoot());

        list2.removeItem(new Node("0"));
        list2.traverse(list2.getRoot());

        tree.traverse(tree.getRoot());
        tree.removeItem(new Node("3"));
        tree.removeItem(new Node("0"));
        tree.traverse(tree.getRoot());
    }
}
