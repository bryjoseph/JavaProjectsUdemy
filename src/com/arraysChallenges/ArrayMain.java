package com.arraysChallenges;

import java.util.Scanner;

public class ArrayMain {

    public static void main(String[] args) {

        int[] myIntArray = getIntegers(6);
        int[] mySortedIntArray = sortIntegers(myIntArray);
        printArray(mySortedIntArray);
    }

    public static int[] getIntegers(int number) {
        int[] array = new int[number];

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter " + number + " numbers to create an array of that length: \r");
        for(int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
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
                if(sortedArray[i] < sortedArray[i]+1) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    flag = true;
                }
            }
        }
        return sortedArray;
    }
}
