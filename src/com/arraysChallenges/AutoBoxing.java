package com.arraysChallenges;

import java.util.ArrayList;

public class AutoBoxing {

    private ArrayList<Integer> myIntArrayList = new ArrayList<>();
    // cant write it this way. Small i int is the primitive type. Large I Integer is the class.
    // private ArrayList<int> myBarArrayList = new ArrayList<int>();

    public AutoBoxing(ArrayList<Integer> myIntArrayList) {
        this.myIntArrayList = myIntArrayList;
    }

    // this is an example of autoboxing -- using the Integer.valueOf(i); returns an int to be added to the Integer ArrayList
//    for(int i = 0; i < 10; i++) {
//        myIntArrayList.add(Integer.valueOf(i));
//    }

    // this is an example of unboxing. From the created IntArrayList, get the value of the int with .intValue.
//    for(int i = 0; i < 10; i++) {
//        System.out.println("Value " + i + " --> " + myIntArrayList.get(i).intValue());
//    }

    Integer myIntValue = 56; // (is same as) Integer myIntValue = Integer.valueOf(56);
    int myInt = myIntValue.intValue();


}
