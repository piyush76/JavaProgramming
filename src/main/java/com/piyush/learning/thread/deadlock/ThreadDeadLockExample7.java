package com.piyush.learning.thread.deadlock;

/**
 * Created by piyush on 6/12/14.
 *
 * This is an example how to code so that to avoid deadlock example.
 */
public class ThreadDeadLockExample7 {

    public static void main(final String[] args) throws Exception {
        final PersonEx6 personX = new PersonEx6("John", "Smith");
        final PersonEx6 personY = new PersonEx6("peter", "drucker");

        System.out.println("Person X now "+ personX.getFirstName() +" " +  personX.getLastName());
        System.out.println("Person Y now "+ personY.getFirstName() + " "+ personY.getLastName());

        final Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                personX.betterVersionOfCopyFrom(personY);

            }
        }, "Thread-A");
        threadA.start();


        final Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                personY.betterVersionOfCopyFrom(personX);


            }
        }, "Thread-B");
        threadB.start();

    /* Wait for the threads to stop */
        threadA.join();
        threadB.join();

        System.out.println("Person X after "+ personX.getFirstName() +" " +  personX.getLastName());
        System.out.println("Person Y after "+ personY.getFirstName() + " "+ personY.getLastName());




    }
}
