package com.piyush.learning.thread;

/**
 * Created by piyush on 6/10/14.
 *
 * A deadlock is a state where two, or more, threads are blocked waiting for the other blocked waiting thread (or threads)
 * to release a lock thus none of the threads will ever complete. Therefore, each thread needs to obtain more than one lock,
 * and they only manage to obtain some of the locks (but not all of them). For a deadlock to take place we need to have more than one thread
 * and each of these threads needs to obtain more than one lock and the same locks are required by more than one thread.
 *
 */
public class ThreadDeadLockExample4 {

    public static void main(final String[] args) throws Exception {

            final Object lockX = new Object();
            final Object lockY = new Object();

            final Thread threadA = new Thread(new Runnable() {
                @Override
                public void run() {

                    ThreadUtils.log("Acquire lock-X");
                    synchronized (lockX) {
                        ThreadUtils.log("Acquire lock-Y");
                        synchronized (lockY) {
                            ThreadUtils.log("Both locks are acquired");
                        }
                        ThreadUtils.log("Release lock-Y");
                    }
                    ThreadUtils.log("Release lock-X");
                }
            }, "Thread-A");
            threadA.start();

    /* Wait for the thread to stop */
            threadA.join();
        }

}