package com.piyush.learning.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by piyush on 5/21/14.
 */


/**
 * This thread will never stops.
 * Broken! - How long would you expect this program to run?
 */


public class StopThread {

    private static boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {

        Thread backgroundThread = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while (!stopRequested) {
                    i++;
                }
            }
        });

        backgroundThread.start();
        System.out.println(backgroundThread.getName());
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Stop Requested");
        stopRequested = true;
        System.out.println("Stop Requested Flag " + stopRequested);

    }

}