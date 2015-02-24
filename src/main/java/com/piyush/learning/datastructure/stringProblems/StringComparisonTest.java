package com.piyush.learning.datastructure.stringProblems;

/**
 * Created by piyush_g on 2/18/2015.
 */
public class StringComparisonTest {

    public static void main(String[] args) {

        String str1 = "piyush";
        String str2 = new String("piyush");
        String str3 = str2;
        String str4 = "piyush";

        if(str1==str2){
            System.out.println("True : 1");
        }

        if(str1.equals(str2)){
            System.out.println("True : 2 ");
        }

        if (str1==str3){
            System.out.println("True : 3");
        }

        if (str1.equals(str3)){
            System.out.println("True : 4");
        }

        if (str1==str4){
            System.out.println("True : 5");
        }

        if (str1.equals(str4)){
            System.out.println("True : 6");
        }



    }
}
