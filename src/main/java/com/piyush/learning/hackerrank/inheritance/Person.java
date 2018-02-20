package com.piyush.learning.hackerrank.inheritance;

/**
 *https://www.hackerrank.com/challenges/30-inheritance/problem
 */


public class Person {

    protected  String firstName;
    protected  String lastName;
    protected int idnum;

    public Person(String firstName, String lastName, int id){
        this.firstName = firstName;
        this.lastName = lastName;
        this.idnum = id;

    }

    // Print person data
    public void printPerson(){
        System.out.println(
                "Name: " + lastName + ", " + firstName
                        + 	"\nID: " + idnum);
    }

}
