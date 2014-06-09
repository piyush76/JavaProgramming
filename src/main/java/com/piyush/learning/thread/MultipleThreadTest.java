/*
 * MultipleThreadTest
 * Copyright (c) 2001-2006 MessageOne Inc.
 */
package com.piyush.learning.thread;

/**
 * @author piyush
 */
public class MultipleThreadTest {

    public static void main(String[] args) {
        MultipleThread t = new MultipleThread();
        Thread t1 = new Thread(t);
        t1.start();

        Thread t2 = new Thread(t);
        t2.start();

        try {
            t2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        System.out.println("Exiting...." + Thread.currentThread().getState());
    }
}
