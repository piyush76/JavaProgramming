package com.piyush.learning.datastructure.stringProblems;

/**
 * Created with IntelliJ IDEA.
 * User: poonamgupta78
 * Date: 11/13/13
 * Time: 10:58 PM
 * To change this template use File | Settings | File Templates.
 * <p/>
 * Java Class to reverse the String
 */
public class TestReverseString {

    public static void main(String[] args) {

        String someString = "jack in the box";
        System.out.println("reverseString1 -- " + reverseString1(someString));
        System.out.println("reverseString2 --  " + reverseString2(someString));

    }

    public static String reverseString1(String str) {

        int len = str.length();
        StringBuffer dest = new StringBuffer(len);
        for (int i = (len - 1); i >= 0; i--) {
            dest.append(str.charAt(i));

        }
        return dest.toString();
    }

    public static String reverseString2(String str) {

        char[] chars = str.toCharArray();

        StringBuffer buff = new StringBuffer();

        for (int i = chars.length - 1; i >= 0; i--) {
            buff.append(chars[i]);

        }

        return buff.toString();
    }

}
