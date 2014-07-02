package com.piyush.learning.puzzles;

/**
 * Created by piyush on 7/1/14.
 */
/*
    You are given a 2-Dimensional array with M rows and N columns.
    You are initially positioned at (0,0) which is the top-left cell
    in the array. You are allowed to move either right or downwards.
    The array is filled with 1's and 0's. A 1 indicates that you can
    move through that cell, a 0 indicates that you cannot move
    through the cell. Given a function numberOfPaths which takes in
    the above 2-D array, return the number of paths from the top-left
    cell to the bottom-right cell (i.e. (0,0) to (M-1,N-1)).
 */
public class Solution {
    /**
     *
     * @param a     The two dimensional array in which paths
     *              have to be found
     * @param M     horizontal index
     * @param N     vertical index
     * @return number of valid paths found
     */
    private int numberOfPaths(int[][] a, int M, int N) {

        int iMax = a.length - 1;
        int jMax = a[0].length - 1;

        // if starting point OR end point is 0,
        // you can never reach destination
        if (a[0][0] == 0 || a[iMax][jMax] == 0) {
            return 0;
        }

        // if we reached destination increment the
        // path count by one and return
        if (M == iMax && N == jMax) {
            return ++count;
        }

        // try to reach a[iMax][jMax] by moving right
        // from current co-ordinates. If we reach,
        // count will be incremented and bubbled up
        // through the recursive calls.
        if (M + 1 <= iMax && a[M + 1][N] == 1) {
            count = numberOfPaths(a, M + 1, N);
        }

        // try to reach a[iMax][jMax] by moving down
        // from current co-ordinates. If we reach,
        // count will be incremented and bubbled up
        // through the recursive calls.
        if (N + 1 <= jMax && a[M][N + 1] == 1) {
            count = numberOfPaths(a, M, N + 1);
        }

        // return the count.
        return count;
    }

    public static void main(String args[]) {
        Solution solution = new Solution();

        int[][] a = new int[][]{
                {1, 0, 0},
                {1, 1, 1},
                {0, 1, 1}
        };
        System.out.println("Expected = 2, Found = " +   solution.numberOfPaths(a, 0, 0));

        a = new int[][]{
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        };
        System.out.println("Expected = 4, Found = " +      solution.numberOfPaths(a, 0, 0));

        a = new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        System.out.println("Expected = 6, Found = " +   solution.numberOfPaths(a, 0, 0));

        a = new int[][]{
                {0, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        System.out.println("Expected = 0, Found = " +    solution.numberOfPaths(a, 0, 0));

        a = new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 0}
        };
        System.out.println("Expected = 0, Found = " +    solution.numberOfPaths(a, 0, 0));

        a = new int[][]{
                {1, 1},
                {0, 1}

        };
        System.out.println("Expected = 1, Found = " +    solution.numberOfPaths(a, 0, 0));

        a = new int[][]{
                {1,1,1,1},
                {1,1,1,1},
                {1,1,1,1}


        };
        System.out.println("Expected = 10, Found = " +    solution.numberOfPaths(a, 0, 0));

        a = new int[][]{
                {0,1,1,1},
                {1,1,1,1},
                {1,1,1,1}


        };
        System.out.println("Expected = 0, Found = " +    solution.numberOfPaths(a, 0, 0));

        3 4 1 1 1 1
        1 1 1 1
        1 1 1 1

    }
}