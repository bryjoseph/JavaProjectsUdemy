package com.arraysChallenges;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayMain {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // array challenge 1
//      int[] myIntArray = getIntegers(6);
//      int[] mySortedIntArray = sortIntegers(myIntArray);
//      printArray(mySortedIntArray);

        // array challenge 2
        int[] newIntArray = readIntegers(5);
        int returnedValue = findMin(newIntArray);
        printMin(returnedValue);
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

    public static int[] readIntegers(int count) {
        int[] array = new int[count];

        System.out.println("Enter " + count + " numbers to create an array of that length: \r");

        for(int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

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

    public static void printMin(int min) {
        System.out.println("The value at index 0 is " + min);
    }
}
