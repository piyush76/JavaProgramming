package com.piyush.learning.hackerrank;

import java.util.Scanner;

/**
 * Created by Piyush_G on 7/7/2017.
 */
public class Factorial {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int result = factorial(n);
        System.out.println(result);
    }

    /**
     * factorial 3 = 3 x 2 x 1
     */
    private static int factorial(int n) {
        if(n>1){
            return n*factorial(n-1);
        }else {
            return n;
        }
    }

}
