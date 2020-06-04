package com.mutech.disruptor.learning.blockingqueue.sample;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockingQueueSample {


    public static void main(String[] args) {
        BlockingQueue<Message> queue = new LinkedBlockingDeque<>();
        new Thread(new Producer(queue, 10000)).start();
        for (int i = 0; i < 1000; i++) {
            new Thread(new Consumer(queue, i)).start();
        }
    }

}
