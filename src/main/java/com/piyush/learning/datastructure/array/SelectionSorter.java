package com.piyush.learning.datastructure.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by piyush on 8/19/14.
 *
 * Sort the Array by Selection Sort Method.
 * ----------------------
 * |57|48|79|65|15|33|52|
 * -----------------------
 *  0   1  2  3  4  5  6
 *
 * 1st pass - Find the smallest number in the entire list, from positions 0 to 6;
 * the smallest is 15,found in position 4. Interchange the numbers in positions 0 and 4.
 * ----------------------
 * |15|48|79|65|57|33|52|
 * -----------------------
 *  0   1  2  3  4  5  6
 *
 * 2nd pass Find the smallest number in positions 1 to 6; the smallest is 33, found in position 5.
 • Interchange the numbers in positions 1 and 5. This gives us the following:
 *
 * ----------------------
 * |15|33|79|65|57|48|52|
 * -----------------------
 *  0  1  2  3  4  5  6
 *
 * and so on till the 6th pass.
 *
 * 6th pass Find the smallest number in positions 5 to 6; the smallest is 65, found in position 6.
 * Interchange the numbers in positions 5 and 6. This gives us the following:
 * ----------------------
 * |15|33|48|52|57|65|79|
 * -----------------------
 *  0  1  2  3  4  5  6
 *
 * On each pass, we find the smallest number from positions h to 6. If the smallest number is in position s, we interchange the
 * numbers in positions h and s.In general, for an array of size n, we make n-1 passes. In our example, we sorted 7 numbers in 6 passes
 * Sudo Code.
 *
 * for h = 0 to n - 2
 *      s = position of smallest number from num[h] to num[n-1]
        swap num[h] and num[s]
    endfor
 */
public class SelectionSorter {

    final static int MaxNumbers = 10;


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr [] = new int [MaxNumbers];

        System.out.printf("Type up to %d numbers followed by 0\n", MaxNumbers);

        int n = 0;
        int v = in.nextInt();

        while(v!=0 && n<MaxNumbers){
            arr[n++] = v;
            v=in.nextInt();
        }

        if (v != 0) {
            System.out.printf("\nMore than %d numbers entered\n", MaxNumbers);
            System.out.printf("First %d used\n", MaxNumbers);
        }

        if (v == 0) {
            System.out.printf("\nNo numbers supplied\n");
            System.exit(1);
        }

        selectionSort(arr,0,n-1);

        System.out.printf("\nThe sorted numbers are\n");
        for (v = 0; v < n; v++) System.out.printf("%d ", arr[v]);
        System.out.printf("\n");


    }

    public static void selectionSort(int[] list, int lo, int hi) {
        //sort list[lo] to list[hi] in ascending order
        for (int h = lo; h < hi; h++) {
            int s = getSmallest(list, h, hi);
            swap(list, h, s);
        }
    }

    public static int getSmallest(int list[], int lo, int hi) {
       //return location of smallest from list[lo..hi]
        int small = lo;
        for (int h = lo + 1; h <= hi; h++)
            if (list[h] < list[small]) small = h;
        return small;
    }

    public static void swap(int list[], int i, int j) {
    //swap elements list[i] and list[j]
        int hold = list[i];
        list[i] = list[j];
        list[j] = hold;
    }

}
