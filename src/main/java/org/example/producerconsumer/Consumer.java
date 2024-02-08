package org.example.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public class Consumer implements Callable<Boolean> {

    private final BlockingQueue<String> queue;
    private final String name;

    public Consumer(BlockingQueue<String> queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    @Override
    public Boolean call() {
        // Consume strings and sleep for a random time
        while(true) {
            try {
                String message = queue.take();
                System.out.println(name + " consumed " + message);

                if(Integer.parseInt(message.split(" ")[1]) > 10){
                    System.out.println("Consumer " + name + " is done");
                    return true;
                }
                Thread.sleep((long) (Math.random() * 1000));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
