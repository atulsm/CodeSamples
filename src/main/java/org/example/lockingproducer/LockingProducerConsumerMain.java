package org.example.lockingproducer;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockingProducerConsumerMain {
    public static void main(String[] args) {

        BlockingQueue<Integer> queue = new SynchronousQueue<>();
        AtomicInteger data = new AtomicInteger(0);
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        // Create an executor for staring the producer and consumer
        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.execute(new LockingProducer(queue, data, lock, "Producer1"));
        executor.execute(new LockingProducer(queue, data, lock, "Producer2"));
        executor.execute(new LockingProducer(queue, data, lock, "Producer3"));


        executor.submit(new LockingConsumer(queue, data, lock, "Consumer1"));
        executor.submit(new LockingConsumer(queue, data, lock, "Consumer2"));

        Future<Boolean> completed = executor.submit(new LockingConsumer(queue, data, lock, "Consumer3"));

        try {
            if(completed.get()) {
                System.out.println("Consumer2 is done");
                executor.shutdown();
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
