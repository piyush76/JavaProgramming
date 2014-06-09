package com.piyush.learning.basicjava;

/**
 * Created by piyush on 1/27/14.
 */
class Triangle {

    public int base;

    public int height;

    private static double ANGLE;

    //public static double getAngle(); //Compilation Error  as method does not have any body

    public static double getAngle() {

        return 1.0;


    }


    public static void Main(String[] args) {
        System.out.println(getAngle());
    }
}