package com.mutech.disruptor.learning.disruptor.sample2;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class LogEventThreadFactory implements ThreadFactory {

    private final AtomicInteger index = new AtomicInteger(1);

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, "LogEventThreadFactory：" + index.incrementAndGet());
    }
}
