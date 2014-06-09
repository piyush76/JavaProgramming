/*
 * TestDistinctInArray
 * Copyright (c) 2001-2006 MessageOne Inc.
 */
package com.piyush.learning.datastructure.array;

/**
 * @author piyush
 *         Write a Java method that takes an array of int values and determines if all the numbers are different
 *         from each other (that is, they are distinct).
 */
public class TestDistinctInArray {

    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 4, 5, 6, 8, 0, 10, 11};
        int arr2[] = {1, 2, 2, 4, 5};
        System.out.println(testDistinct(arr1));
        System.out.println(testDistinct(arr2));
    }

    public static boolean testDistinct(int[] num) {

        for (int i = 0; i < num.length; i++) {
            //System.out.println("element.." + num[i]);
            for (int j = i + 1; j < num.length; j++) {
                // System.out.println("next element..." + num[j] );
                if (num[i] == num[j]) {
                    return true;
                }
            }
        }

        return false;
    }
}
