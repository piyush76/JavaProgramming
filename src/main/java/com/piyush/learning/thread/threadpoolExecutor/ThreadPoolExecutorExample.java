package com.piyush.learning.thread.threadpoolExecutor;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutorExample implements Runnable {

    private static final int NO_OF_THREADS = 3;
    int maxNumber;

    public ThreadPoolExecutorExample(int maxNumber) {

        this.maxNumber = maxNumber;
    }

    /**
     * method where the thread execution will start *
     */
    public void run() {
        int sum = 0;
        for (int i = 0; i <= maxNumber; i++) {
            sum += maxNumber;
            System.out.println("inside for loop Thread " + Thread.currentThread().getName() + " inside sum  is " + sum);
        }

        System.out.println("Thread " + Thread.currentThread().getName() + " count is " + sum);
    }

    /**
     * main thread. Always there by default. *
     */

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(NO_OF_THREADS); // create a pool of 3 threads

        for (int i = 10000; i < 10100; i++) {
            Runnable worker = new ThreadPoolExecutorExample(i); // create worker threads
            executor.execute(worker); // add runnables to the work queue
        }

        // This will make the executor accept no new threads
        // and finish all existing threads in the queue
        executor.shutdown();

        // Wait until all threads have completed
        while (!executor.isTerminated()) {

        }

        System.out.println("Finished all threads");
    }

}
