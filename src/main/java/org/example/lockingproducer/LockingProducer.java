package org.example.lockingproducer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Producers String to insert to queue.
 */
public class LockingProducer implements Runnable{

    private final BlockingQueue<Integer> queue;
    private final AtomicInteger data;
    private final ReentrantReadWriteLock lock;
    private final String name;

    public LockingProducer(BlockingQueue<Integer> queue, AtomicInteger data, ReentrantReadWriteLock lock, String name) {
        this.queue = queue;
        this.data = data;
        this.lock = lock;
        this.name = name;
    }

    @Override
    public void run() {
        int counter = 1;
        // Generate strings and sleep for a random time
        while(true) {
            try {
                //lock.writeLock().lock();
                synchronized (lock) {
                    int ret = data.incrementAndGet();
                    queue.put(ret);
                    System.out.println(name + " produced " + ret);
                    //lock.writeLock().unlock();
                }

                Thread.sleep((long) (Math.random() * 500));
            } catch (InterruptedException e) {
                System.out.println("Produced Interrupted. Exiting now");
                return;
            }
        }
    }
}
