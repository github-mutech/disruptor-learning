package com.mutech.disruptor.learning.blockingqueue.sample;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private int id;

    private BlockingQueue<Message> queue;

    public Consumer(BlockingQueue<Message> queue, int id) {
        this.queue = queue;
        this.id = id;
    }

    public void consume() throws InterruptedException {
        while (!queue.isEmpty()) {
            System.out.println("consumer " + id + "：" + queue.take());
        }
    }

    @Override
    public void run() {
        try {
            consume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
