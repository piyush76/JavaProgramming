/*
 * TestThread
 * Copyright (c) 2001-2006 MessageOne Inc.
 */
package com.piyush.learning.thread;

/**
 * @author piyush
 */
public class TestThread {

    public static void main(String[] args) {
        new MyTestThread();
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(200);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Main thread exiting.");
    }

}

