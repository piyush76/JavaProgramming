/*
 * ArraySorter
 * Copyright (c) 2001-2006 MessageOne Inc.
 */
package com.piyush.learning.datastructure.array;

/**
 * @author piyush
 */
public class ArraySorter {

    public static void main(String[] args) {

        int arr[] = new int[]{5, 3, 2, 6, 9, 10, 1, 4, 44, 7, 8, 12, 21};
        for (int i : arr) {
            System.out.print(i + " ");
        }

        //int[] arri = bubbleSortArray(arr);

        int[] arri = selectionSortArray(arr);

        System.out.println("\n" + "after Sorting ");

        for (int i : arri) {
            System.out.print(i + " ");

        }

    }

    /**
     * Bubble Sort Comparison O(N2) notation.
     * For every outer loop the inner loop runs through N times.
     */

    public static int[] bubbleSortArray(int[] arr) {

        for (int out = arr.length - 1; out > 0; out--) { //outer loop backwards
            for (int in = 0; in < arr.length - 1; in++) {
                if (arr[in] > arr[in + 1]) {
                    int tmp = arr[in];
                    arr[in] = arr[in + 1];  //Swap
                    arr[in + 1] = tmp;
                }
            }
        }
        return arr;
    }

    /**
     * Selection Sort method of Array
     *
     * @param arr
     * @return 5, 3, 2, 6, 9, 10, 1,4,44,7,8,12,21
     * <p/>
     * The selection sort performs the same number of comparisons as the bubble sort:
     * N*(N-1)/2. For 10 data items, this is 45 comparisons. However, 10 items require fewer
     * than 10 swaps. With 100 items, 4,950 comparisons are required, but fewer than 100
     * swaps. For large values of N, the comparison times will dominate, so we would have
     * to say that the selection sort runs in O(N2) time, just as the bubble sort did. However,
     * it is unquestionably faster because there are so few swaps. For smaller values of N,
     * the selection sort may in fact be considerably faster, especially if the swap times are
     * much larger than the comparison times.
     */

    public static int[] selectionSortArray(int[] arr) {

        int i, j, min;

        for (j = 0; j < arr.length - 1; j++) {
            min = j;
            for (i = j + 1; i < arr.length; i++) {
                if (arr[i] < arr[min]) min = i;
            }
            int temp = arr[j];
            arr[j] = arr[min];
            arr[min] = temp;

        }
        return arr;
    }

    /**
     * Array Sort using the insertion Sort.
     *
     *
     */

}
