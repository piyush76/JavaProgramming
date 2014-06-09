package com.piyush.learning.puzzles;

/**
 * Created with IntelliJ IDEA.
 * User: piyush
 * Date: 10/11/13
 * Time: 6:21 PM
 * <p/>
 * Validate Sudoku
 * To change this template use File | Settings | File Templates.
 * <p/>
 * http://sudokublog.typepad.com/photos/uncategorized/sudoku508b4a6b7f4c1d65a5a9a3a78e7e48a2a1_1.png
 */
public class TestSudokuValidity {

    public static void main(String args[]) {

        /**
         *   00 01 02
         *   10 11 12
         *   20 21 22
         *
         *
         *
         */

        int soduku[][] = {{8, 3, 5, 4, 1, 6, 9, 2, 7},
                {2, 9, 6, 8, 5, 7, 4, 3, 1},
                {4, 1, 7, 2, 9, 3, 6, 5, 8},
                {5, 6, 9, 1, 3, 4, 7, 8, 2},
                {1, 2, 3, 6, 7, 8, 5, 4, 9},
                {7, 4, 8, 5, 2, 9, 1, 6, 3},
                {6, 5, 2, 7, 8, 1, 3, 9, 4},
                {9, 8, 1, 3, 4, 5, 2, 7, 6},
                {3, 7, 4, 9, 6, 2, 8, 1, 5}
        };

        // System.out.println(soduku[0][1]);
        //System.out.println(soduku[2][3]);

        if (testValidity(soduku)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }

    public static boolean testValidity(int arr[][]) {
        int i, j;
        int row[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int column[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        boolean b = true;

        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                //System.out.println("row " + arr[j][i] +"---" +  row[arr[j][i]]);

                if (row[arr[j][i]] > i) {

                    b = false;
                    return b;
                }
                //System.out.println("col " +arr[i][j]+"---" +  column[arr[i][j]]);
                if (column[arr[i][j]] > i) {
                    b = false;
                    return b;
                }
                column[arr[i][j]]++;
                row[arr[j][i]]++;
            }

        }

        return b;
    }

}