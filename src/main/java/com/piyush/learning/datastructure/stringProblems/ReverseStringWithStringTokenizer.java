package com.piyush.learning.datastructure.stringProblems;

/**
 * Created by piyush on 8/14/14.
 */
import java.util.StringTokenizer;

public class ReverseStringWithStringTokenizer {

    public static void main(String[] args) {

        String s = "Java Code Geeks - Jack in the Box";

        StringTokenizer st = new StringTokenizer(s);
        String sReversed = "";

        while (st.hasMoreTokens()) {
            sReversed = st.nextToken() + " " + sReversed;
        }

        System.out.println("Original string is : " + s);
        System.out.println("Reversed string is : " + sReversed);

    }

}