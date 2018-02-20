package com.piyush.learning.hackerrank.inheritance;

/**
 * https://www.hackerrank.com/challenges/30-inheritance/problem
 */

public class Student extends Person {

    private int [] testScores ;



    public Student(String firstName, String lastName, int id, int [] scores ){
        super(firstName,lastName,id);
        this.testScores = scores;
    }

    public char calculate() {
        int average = 0;
        int total = 0;
        char grade = 0;

        System.out.println("Scores...." + testScores.length);

        for(int i=0;i<testScores.length;i++){
            total=total+testScores[i];
        }

        System.out.println("Total " + total);
        average = total / testScores.length;
        System.out.println("Average " + average);

        if (average < 40)
            grade = 'T';
        if (average >= 40 && average < 55)
            grade='D';
        if (average >= 55 && average < 70)
            grade = 'P';
        if (average >= 70 && average < 80)
            grade ='A';
        if (average >= 80 && average < 90)
            grade = 'E';
        if (average >= 90 && average <= 100)
            grade ='O';

        return grade ;
    }


}
