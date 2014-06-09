package com.piyush.learning.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by piyush on 5/21/14.
 */
// Properly synchronized cooperative thread termination
public class StopThreadRight {
    private static boolean stopRequested;

    private static synchronized void requestStop() {
        stopRequested = true;
    }

    private static synchronized boolean stopRequested() {
        return stopRequested;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while (!stopRequested())
                    i++;
            }
        });

        backgroundThread.start();
        System.out.println(backgroundThread.getName());
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Stop Requested");
        requestStop();
    }
}