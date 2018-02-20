package com.piyush.learning.hackerrank;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Piyush_G on 7/7/2017.
 * This will provide us the Maximum consecutive count of '1' in binary will pass for decimal value 439.
 *
 *
 */
public class ConsecutiveBinaryMaximumCount {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int rem=0,count=0,t=0;

        while(n>0) {
            rem=n%2;
            n=n/2;
            if(rem==1){
                count++;
                if(count>=t)
                    t=count;
            }
            else{

                count=0;
            }
        }
        System.out.println(t);
    }
}
