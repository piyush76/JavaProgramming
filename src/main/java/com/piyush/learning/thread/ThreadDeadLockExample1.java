package com.piyush.learning.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by piyush on 6/5/14.
 * <p/>
 * http://www.javacreed.com/what-is-deadlock-and-how-to-prevent-it/
 *
 * Everytime the total would be different cause two threads are working parallaly on calculateAverage method.
 * Thread A is calculating average and ThreadB is modifying the list at the same time.
 */
public class ThreadDeadLockExample1 {


    public static double calculateAverage(final List<Integer> list) {
        double total = 0;
        for (int i = 0; i < list.size(); i++) {
            total += list.get(i);
            // This will cause the bug to manifest
            ThreadUtils.silentSleep(1);
        }

        return total / list.size();
    }

    public static void main(final String[] args) throws Exception {
        final List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 1923; i++) {
            list.add(i);
        }

        final Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                final double average = ThreadDeadLockExample1.calculateAverage(list);
                ThreadUtils.log("Average: %.2f", average);
            }
        }, "Thread-A");
        threadA.start();

        final Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < list.size(); i++) {

                    //ThreadUtils.log("Modifying list with %s" , i );
                    list.set(i, list.get(i) * 2);
                }
            }
        }, "Thread-B");
        threadB.start();

    /* Wait for the threads to stop */
        threadA.join();
        threadB.join();
    }


}
