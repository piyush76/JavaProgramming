/*
 * TestArraySum
 * Copyright (c) 2001-2006 MessageOne Inc.
 */
package com.piyush.learning.datastructure.array;

/**
 * @author piyush
 *         <p/>
 *         Write a short Java function that takes an array of int values and
 *         determines if there is a pair of numbers in the array whose product is odd.
 */
public class TestArraySum {

    public static void main(String[] args) {
        TestArraySum sum = new TestArraySum();
        int intArr[] = {2, 1, 3, 4, 5};
        sum.isSumOdd(intArr);
    }

    public boolean isSumOdd(int[] arr) {
        boolean isOdd = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int k = arr[i] + arr[j];
                System.out.println(k);
                if (k % 2 == 0) {
                    System.out.println("Is Odd");
                    isOdd = true;
                }
            }

        }

        return isOdd;
    }

}
