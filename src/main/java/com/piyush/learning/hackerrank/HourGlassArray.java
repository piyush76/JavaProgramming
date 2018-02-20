package com.piyush.learning.hackerrank;

/**
 * Created by Piyush_G on 7/17/2017.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

    public class HourGlassArray {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int arr[][] = new int[6][6];
            for(int i=0; i < 6; i++){
                for(int j=0; j < 6; j++){
                    arr[i][j] = in.nextInt();
                }
            }

            int maxSum = Integer.MIN_VALUE;
            for(int i=0;i<4;i++){
                for (int j=0;j<4;j++){
                    int sum = arr[i][j] + arr[i][j+1] + arr [i][j+2]
                                        + arr[i+1][j+1] +
                              arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                    if(sum > maxSum ){
                        maxSum = sum;
                    }
                }
            }

            System.out.println("Max hour glass Sum " + maxSum);

        }
    }


