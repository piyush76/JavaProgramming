package com.piyush.learning.thread;

/**
 * Created by piyush on 6/27/14.
 *
 * Example of Lazy initialization
 *
 */
public class Lazy {

    private static boolean initialized = false;

    static {
        Thread t = new Thread(new Runnable() {
            public void run() {
                initialized = true;
            }
        });
        t.start();
        try {
            t.join();
        } catch(InterruptedException e) {
            throw new AssertionError(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(initialized);
    }
}