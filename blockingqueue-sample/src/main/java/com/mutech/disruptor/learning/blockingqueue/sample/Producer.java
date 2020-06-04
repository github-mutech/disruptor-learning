package com.mutech.disruptor.learning.blockingqueue.sample;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private BlockingQueue<Message> queue;

    private int total;

    public Producer(BlockingQueue<Message> queue, int total) {
        this.queue = queue;
        this.total = total;
    }

    public void publish(int total) {
        for (int i = 0; i < total; i++) {
            Message message = new Message(i);
            queue.add(message);
        }
    }

    @Override
    public void run() {
        publish(total);
    }
}
