package com.piyush.learning.hackerrank;

/**
 * Created by Piyush_G on 7/6/2017.
 */
public class TestRecursion {


    public static void main(String[] args) {
        int result = nTimesK(4, 4);
        System.out.println("Result: " + result);

    }

    private static int nTimesK(int n, int k) {
        System.out.println("n: " + n);
        // Recursive Case
        if(n > 1) {
            System.out.println("return ntimes " +  nTimesK(n - 1, k));
            int j =  k + nTimesK(n - 1, k);
            System.out.println("Addition ... " + j );
            return j ;

        }
        // Base Case n = 1
        else {

            System.out.println("in else block");
            System.out.println("Print K " + k);
            return k;
        }
    }


}
