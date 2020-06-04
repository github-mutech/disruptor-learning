package com.mutech.disruptor.learning.disruptor.sample2;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;

public class LogEventProducer {
    private RingBuffer<LogEvent> ringBuffer;

    public LogEventProducer(RingBuffer<LogEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void publishData(String message) {
        EventTranslatorOneArg<LogEvent, String> translator = new LogEventTranslator();
        ringBuffer.publishEvent(translator, message);
    }
}
