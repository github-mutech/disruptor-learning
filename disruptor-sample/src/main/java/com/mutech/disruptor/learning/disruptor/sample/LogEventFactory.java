package com.mutech.disruptor.learning.disruptor.sample;

import com.lmax.disruptor.EventFactory;

/**
 * 事件工厂,用于创建event
 *
 * @author mutech
 */
public class LogEventFactory implements EventFactory<LogEvent> {
    @Override
    public LogEvent newInstance() {
        return new LogEvent();
    }
}
