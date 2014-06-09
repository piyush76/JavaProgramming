package com.piyush.learning.thread;

/**
 * Created by piyush on 6/3/14.
 */


public class ThreadMain {

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                try {
                    System.out.print("Going to sleep. \n");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print("Has woken up. \n");
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.print("Completed. \n");
    }

}