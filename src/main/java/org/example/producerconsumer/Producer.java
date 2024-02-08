package org.example.producerconsumer;

import java.util.concurrent.BlockingQueue;

/**
 * Producers String to insert to queue.
 */
public class Producer implements Runnable{

    private final BlockingQueue<String> queue;
    private final String name;

    public Producer(BlockingQueue<String> queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    @Override
    public void run() {
        int counter = 1;
        // Generate strings and sleep for a random time
        while(true) {
            try {
                String message = name + " " + counter++;
                System.out.println("Produced " + message);
                queue.put(message);
                Thread.sleep((long) (Math.random() * 500));
            } catch (InterruptedException e) {
                System.out.println("Produced Interrupted. Exiting now");
                return;
            }
        }
    }
}
