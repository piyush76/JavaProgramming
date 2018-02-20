package com.piyush.learning.hackerrank;

import java.util.*;

/**
 * Created by Piyush_G on 7/7/2017.
 * This will provide us the consecutive  count of '1' in binary but not the Maximum count of consecutive 1 and will fail for decimal value 439.
 *
 *
 */
public class ConsecutiveBinaryCount {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Stack lifo = new Stack();

        while(n>0){
            int remainder = n%2;
            n = n/2;
            lifo.push(remainder);
        }

        int count =0 ;
        while(!lifo.isEmpty()) {
            int i = (int) lifo.pop();
            System.out.println("elements in stack .. " + i);
            if (i == 1) {
                count++;
            } else {
                break;
            }
        }
       System.out.println(count);
    }

}
