package com.piyush.learning.thread.deadlock;

/**
 * Created by piyush on 6/11/14.
 *
 * This is a deadlock example
 */
public class ThreadDeadLockExample6 {

    public static void main(final String[] args) throws Exception {
        final PersonEx6 personX = new PersonEx6("John", "Smith");
        final PersonEx6 personY = new PersonEx6("peter", "drucker");

        final Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                personX.copyFrom(personY);
            }
        }, "Thread-A");
        threadA.start();

        final Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                personY.copyFrom(personX);

            }
        }, "Thread-B");
        threadB.start();

    /* Wait for the threads to stop */
        threadA.join();
        threadB.join();
    }
}
