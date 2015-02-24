/*
 * TestLinkedList
 * Copyright (c) 2001-2006 MessageOne Inc.
 */
package com.piyush.learning.datastructure.linkedList;

//finding middle element of LinkedList in single pass

/**
 * Java program to find middle element of linked list in one pass.
 * In order to find middle element of linked list we need to find length first
 * but since we can only traverse linked list one time, we will use two pointers
 * one which we will increment on each iteration while other which will be
 * incremented every second iteration. so when first pointer will point to the
 * end of linked list, second will be pointing to the middle element of linked list
 * @author
 */

/**
 * @author piyush
 */
public class TestLinkedList {

    public static void main(String args[]) {
        //creating LinkedList with 5 elements including head
        LinkedList linkedList = new LinkedList();
        LinkedList.Node head = linkedList.head();
        linkedList.add(new LinkedList.Node("1"));
        linkedList.add(new LinkedList.Node("2"));
        linkedList.add(new LinkedList.Node("3"));
        linkedList.add(new LinkedList.Node("4"));
        linkedList.add(new LinkedList.Node("5"));
        linkedList.add(new LinkedList.Node("6"));
        linkedList.add(new LinkedList.Node("7"));
        linkedList.add(new LinkedList.Node("8"));


        //finding middle element of LinkedList in single pass
        LinkedList.Node current = head;
        LinkedList.Node middle = head;
        int length = 0;

        while (current.next() != null) {
            length++;
            System.out.println("Current [1] " +  current);
            System.out.println("length... " + length + " --- "+ length % 2 );
            if (length % 2 == 0) {
                System.out.println("if loop 1...");
                middle = middle.next();
                System.out.println("Middle : " +  middle);
            }
            current = current.next();
            System.out.println("Current [2] " +  current);
        }

        if (length % 2 == 1) {
            System.out.println("if loop 2...");
            middle = middle.next();
        }
        System.out.println("length of LinkedList: " + length);
        System.out.println("middle element of LinkedList : " + middle);

    }
}
