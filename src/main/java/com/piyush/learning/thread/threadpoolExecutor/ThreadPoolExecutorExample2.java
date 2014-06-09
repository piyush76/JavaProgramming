package com.piyush.learning.thread.threadpoolExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


public class ThreadPoolExecutorExample2 implements Callable<String> {

    private static final int NO_OF_THREADS = 3;

    int maxNumber;

    public ThreadPoolExecutorExample2(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    /**
     * method where the thread execution will start
     * this can return a value
     */
    public String call() {
        int sum = 0;
        for (int i = 0; i <= maxNumber; i++) {
            sum += maxNumber;
        }

        return Thread.currentThread().getName() + " count is " + sum;
    }


    /**
     * main thread. Alwyas there by default. *
     */
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(NO_OF_THREADS); // create a pool of 3 threads

        List<Future<String>> list = new ArrayList<Future<String>>(10); // provides facility to return results asynchronously

        for (int i = 10000; i < 10100; i++) {
            Callable<String> worker = new ThreadPoolExecutorExample2(i); // create worker threads
            Future<String> submit = executor.submit(worker); // add callables to the work queue
            list.add(submit); // provides facility to return results asynchronously
        }

//process the results asynchronously when each thread completes its task
        for (Future<String> future : list) {
            try {
                System.out.println("Thread " + future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }


        executor.shutdown();

        System.out.println("Finished all threads");
    }

}