/*
 * FindDuplicateElementArray
 * Copyright (c) 2001-2006 MessageOne Inc.
 */
package com.piyush.learning.datastructure.array;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author piyush
 *         <p/>
 *         find if there are any duplicate element in an array
 */

public class FindDuplicateElementArray {

    public static void main(String[] args) {
        int arr[] = new int[]{5, 3, 2, 7, 9, 10, 2, 4, 8, 3, 3, 3, 3, 3, 77, 8, 2, 21};

        checkForDuplicate(arr);
        checkForDuplicateSorted(arr);
        int i = countForMaximumAppeared(arr);
        System.out.println("Appeared " + i + " Times");
        int j = countForMaximumAppearedSorted(arr);
        System.out.println("Appeared sorted " + j + " Times");

        Map<Integer, Integer> map = totalNumberOfDuplicate(arr);
        for (Integer key : map.keySet()) {

            System.out.println("Found " + key + " for " + map.get(key) + " times");

        }

    }

    /**
     * Comparing every array element to all the array elements and check if duplicate exists.
     *
     * @param arr
     */

    public static void checkForDuplicate(int arr[]) {

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println("Duplicate Exist " + arr[i] + " equals " + arr[j]);
                    return;
                }

            }

        }
        System.out.println(" No duplicates ");

    }

    /**
     * Improved version by sorting the Array.
     */

    public static void checkForDuplicateSorted(int arr[]) {
        //sort the array
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                System.out.println("Duplicate Exist " + arr[i] + " equals " + arr[i + 1]);
                return;

            }

        }

        System.out.println(" No duplicates ");

    }

    /**
     * Given an array of  numbers. Give an algorithm for finding the element which
     * appears maximum number of times in the array?
     */

    public static int countForMaximumAppeared(int arr[]) {

        int counter, max = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            counter = 0;
            for (int j = 0; j < arr.length - 1; j++) {

                if (arr[i] == arr[j]) {
                    counter++;
                }
                if (counter > max) {
                    max = counter;
                }

            }

        }

        return max;
    }

    /**
     * improved by sorting the array first
     */

    public static int countForMaximumAppearedSorted(int arr[]) {

        int counter, max = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            counter = 0;
            if (arr[i] == arr[i + 1]) {
                counter++;
            }
            if (counter > max) {
                max = counter;
            }
        }
        return max;
    }


    /**
     * This will give all the duplicates with the count.
     *
     * @param arr
     */

    public static Map totalNumberOfDuplicate(int arr[]) {

        int counter, max = 0;

        Arrays.sort(arr);
        Map<Integer, Integer> hashMap = new TreeMap<Integer, Integer>();


        for (int i = 0; i < arr.length - 1; i++) {
            int num = arr[i];

            if (hashMap.get(num) != null) {
                Integer val = (Integer) hashMap.get(num);
                hashMap.put(num, val + 1);
            } else {
                hashMap.put(num, 1);
            }

        }

        return hashMap;

    }


}
