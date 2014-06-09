/*
 * MultipleThread
 * Copyright (c) 2001-2006 MessageOne Inc.
 */
package com.piyush.learning.thread;

/**
 * @author piyush
 */
public class MultipleThread implements Runnable {

    MultipleThread() {

    }

    public void run() {

        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            System.out.println(Thread.currentThread().getName());

        }
    }
}

