package com.javaCollections.javaSets;

import java.util.*;

public class SetsMain {

    public static void main(String[] args) {

        // set operations examples
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for (int i = 1; i <= 100; i++) {
            // squared value
            squares.add(i * i);
            // cubed value
            cubes.add(i * i * i);
        }

        System.out.println("There are: " + squares.size() + " values in the set");
        System.out.println("There are: " + cubes.size() + " values in the set");

        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);

        // notice the total is not 200 values
        System.out.println("There are: " + union.size() + " values in the set");

        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);

        System.out.println("Intersection contains: " + intersection.size() + " values");

        // looping through the values of intersection
        for (int i : intersection) {
            System.out.println(i + " is the square of " + Math.sqrt(i) + " and the cube of " + Math.cbrt(i));
        }

        // examining retain and remove closer
        Set<String> words = new HashSet<>();
        String sentence = "A day in the life of the fox";
        String[] arrayWords = sentence.split(" ");
        words.addAll(Arrays.asList(arrayWords));

        for (String w : words) {
            System.out.println(w);
        }

        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();
        String[] natureWords = {"all", "nature", "is", "but", "art", "unknown", "to", "thee"};
        // have to have the Arrays.asList() because Java does not have a Set literal such as line #165
        nature.addAll(Arrays.asList(natureWords));

        String[] divineWords = {"to", "err", "is", "human", "but", "to", "forgive", "divine"};
        // have to have the Arrays.asList() because Java does not have a Set literal such as line #168
        divine.addAll(Arrays.asList(divineWords));

        System.out.println("Nature - Divine" + " (Asymmetric Difference)");
        // have to make a copy because it alters existing  copy
        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        printSet(diff1);

        System.out.println("Divine - Nature" + " (Asymmetric Difference)");
        Set<String> diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);
        printSet(diff2);

        Set<String> unionTest = new HashSet<>(nature);
        unionTest.addAll(divine);
        Set<String> intersectionTest = new HashSet<>(nature);
        intersectionTest.retainAll(divine);

        // subtracting the overlapping pieces of the two circles in the middle
        // returns everything on the outside of the overlap
        System.out.println("Nature + Divine - overlap" + " (Symmetric Difference)");
        unionTest.removeAll(intersectionTest);
        printSet(unionTest);

        System.out.println("************************************");
        // non-destructive containsAll() is one Set a super/sub set of anther
        // returns false and is NON-destructive
        if (nature.containsAll(divine)) {
            System.out.println("Divine is a subset of Nature");
        }
        // returns true
        if (nature.containsAll(intersectionTest)) {
            System.out.println("IntersectionTest is a subset of Nature");
        }
        // returns true
        if (divine.containsAll(intersectionTest)) {
            System.out.println("IntersectionTest is a subset of Divine");
        }
    }

    private static void printSet(Set<String> testSet) {
        System.out.print("\t");
        for (String s : testSet) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
