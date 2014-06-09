/*
 * TestCharFromArr
 * Copyright (c) 2001-2006 MessageOne Inc.
 */
package com.piyush.learning.datastructure.array;

/**
 * @author piyush
 *         Write a short Java program that outputs all possible strings formed by
 *         using the characters 'c', 'a', 'r', 'b', 'o' , and 'n' exactly once.
 *         ca,car,carb,cab,carbon,carbo,can,cor,con,cob
 */

public class TestCharFromArr {

    private static char source[] = {'c', 'a', 'r', 'b', 'o', 'n'};
    private static char result[] = new char[6];
    private static boolean picked[] = new boolean[6];

    public static void main(String[] args) {
        java.util.Arrays.fill(picked, false);
        pickCharAt(0);

    }

    private static void pickCharAt(int position) {
        if (position > 5) {
            System.out.println(String.valueOf(result));
        } else {
            for (int i = 0; i < 6; i++) {
                if (!picked[i]) {
                    result[position] = source[i];
                    picked[i] = true;
                    pickCharAt(position + 1);
                    picked[i] = false;

                }

            }
        }
    }

}
