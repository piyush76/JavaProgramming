package com.piyush.learning.datastructure.stringProblems;

/**
 * Created with IntelliJ IDEA.
 * User: poonamgupta78
 * Date: 11/12/13
 * Time: 11:20 PM
 * To change this template use File | Settings | File Templates.
 */

/**
 * Implement an algorithm to determine if a
 * string has all unique characters.
 * What if you can not use additional data structures?
 */
public class TestUniqueCharInString {

    public static void main(String[] args) {

        String someString = "jackintheboxx";
        System.out.println("Is Unique1 String " + testUnique1(someString));
        System.out.println("Is Unique2 String " + testUnique2(someString));

    }

    /**
     * O(n^2) complexity
     */

    public static boolean testUnique1(String someString) {

        char[] chars = someString.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            //System.out.println("I--- "+ chars[i]);
            for (int j = i + 1; j < chars.length; j++) {
                //System.out.println("J---- "+ chars[j]);
                if (chars[i] == chars[j]) {
                    System.out.println(chars[i] + " equals  " + chars[j]);
                    return false;
                }
            }

        }
        return true;
    }

    /**
     * Another way of doing it
     *
     * @param someString
     * @return
     */
    public static boolean testUnique2(String someString) {

        boolean[] char_set = new boolean[256];

        for (int i = 0; i < someString.length(); i++) {
            int val = someString.charAt(i);

            //System.out.println("Val---" + val);
            if (char_set[val]) return false;
            char_set[val] = true;
        }
        return true;
    }

}
