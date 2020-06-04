package com.mutech.disruptor.learning.disruptor.sample;

import com.lmax.disruptor.EventHandler;

/**
 * @author mutech
 */
public class LogEventHandler implements EventHandler<LogEvent> {

    @Override
    public void onEvent(LogEvent event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("onEvent\t" + event);
    }
}
