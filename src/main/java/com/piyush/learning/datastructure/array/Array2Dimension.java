package com.piyush.learning.datastructure.array;

/**
 * Created by piyush on 7/1/14.
 */
public class Array2Dimension {


    public static void main(String[] args) {

        int [][] twodim = new int [][]{
                                        {1,2,3,4},
                                        {5,6,7,8},
                                        {9,10,11,12}};


        System.out.println("Array Length " +twodim.length);
        System.out.println("iMax --- " + (twodim.length - 1));
        System.out.println("jMax --- " + (twodim[0].length));


    }

}
