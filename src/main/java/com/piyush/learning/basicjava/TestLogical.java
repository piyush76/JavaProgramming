package com.piyush.learning.basicjava;

/**
 * Created by Piyush_G on 5/30/2017.
 */
public class TestLogical {


    public static void main(String[] args) {

        int a = 10 ;
        int b = 11;
        int c = a+b;

        if ( a < 10 && b==11 ){
            System.out.println("Logical && not print first cond false " );
        }
        if ( a == 10 && b==11 ){
            System.out.println("Logical && print both cond true " );
        }

        if ( a < 10 || b==11 ){
            System.out.println("Logical || print second condition true " );
        }

        if ( (a == 10 && b==11) || c == 20){
            System.out.println("Logical || print  " );
        }

        if  (a == 11 & b==11) {
            System.out.println("Logical & print  " );
        }











    }


}
