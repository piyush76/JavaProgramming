package com.piyush.learning.datastructure.array;

/**
 * @author piyush
 */

/**
 * Simple Java program to reverse a number in Java using loop and operator
 * This program also shows example of using division operator(/) and Remainder Operator(%)
 */
public class ReverseNumberExample {

    public static void main(String args[]) {
        //input number to reverse
        System.out.println("Please enter number to be reversed using Java program: ");
        //int number = new Scanner(System.in).nextInt();
        int number = 10245;

        int reverse = reverse(number);
        System.out.println("Reverse of number: " + number + " is " + reverse);

    }

    /*
    * reverse a number in Java using iteration
    * @return reverse of number
    */
    public static int reverse(int number) {
        int reverse = 0;
        int remainder = 0;
        int count = 1;
        do {
            System.out.println("loop " + count);
            remainder = number % 10;
            System.out.println("rem " + remainder);
            reverse = reverse * 10 + remainder;
            System.out.println("rev " + reverse);
            System.out.println("num1 " + number);
            number = number / 10;
            System.out.println("num2 " + number);
            count++;

        } while (number > 0);

        return reverse;
    }

}


