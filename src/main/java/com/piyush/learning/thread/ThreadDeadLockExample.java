package com.piyush.learning.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by piyush on 6/5/14.
 * <p/>
 * http://www.javacreed.com/what-is-deadlock-and-how-to-prevent-it/
 */
public class ThreadDeadLockExample {


    public static double calculateAverage(final List<Integer> list) {
        double total = 0;
        for (int i = 0; i < list.size(); i++) {
            total += list.get(i);
        }

        return total / list.size();
    }


    public static void main(String[] args) {

        final List<Integer> newList = new ArrayList<Integer>();
        newList.add(2);
        newList.add(4);
        newList.add(6);
        newList.add(8);
        newList.add(10);
        newList.add(12);
        newList.add(14);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                final double average = ThreadDeadLockExample.calculateAverage(newList);
                System.out.println("Average: " + average);

            }
        }, "Thread -t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {


            }
        });

    }


}
