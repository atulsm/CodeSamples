package org.example.lockingproducer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockingConsumer implements Callable<Boolean> {
    private final BlockingQueue<Integer> queue;
    private final AtomicInteger data;
    private final ReentrantReadWriteLock lock;
    private final String name;

    public LockingConsumer(BlockingQueue<Integer> queue, AtomicInteger data, ReentrantReadWriteLock lock, String name) {
        this.queue=queue;
        this.data = data;
        this.lock = lock;
        this.name = name;
    }

    @Override
    public Boolean call() {
        // Consume strings and sleep for a random time
        while(true) {
            try {
                Integer ret = queue.poll();
                if(ret==null){
                    Thread.sleep((long) (Math.random() * 1000));
                    continue;
                }

                System.out.println(name + " consumed " + ret);

                if(ret > 10){
                    System.out.println("Consumer " + name + " is done");
                    return true;
                }
                Thread.sleep((long) (Math.random() * 1000));

            } catch (InterruptedException e) {
                System.out.println("Consumer " + name + " is exiting");
                return false;
            }
        }

    }
}
