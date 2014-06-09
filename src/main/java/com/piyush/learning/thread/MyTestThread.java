/*
 * MyTestThread
 * Copyright (c) 2001-2006 MessageOne Inc.
 */
package com.piyush.learning.thread;

/**
 * @author piyush
 */
public class MyTestThread implements Runnable {
    Thread t;

    MyTestThread() {
        t = new Thread(this, "Demo Thread");
        System.out.println("Child thread: " + t);
        t.start();
    }

    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child Thread: " + i);
                System.out.println("Sleeping " + Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Child interrupted.");
        }
        System.out.println("Exiting child thread.");
    }
}

