package org.example.producerconsumer;

import java.util.concurrent.*;

public class ProcuderConsumerMain {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(10);

        // Create an executor for staring the producer and consumer
        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.execute(new Producer(queue, "Producer"));
        executor.submit(new Consumer(queue, "Consumer"));
        Future<Boolean> completed = executor.submit(new Consumer(queue, "Consumer2"));

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
