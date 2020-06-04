package com.mutech.disruptor.learning.disruptor.sample;

import com.lmax.disruptor.EventTranslatorOneArg;

public class LogEventTranslator implements EventTranslatorOneArg<LogEvent, String> {

    @Override
    public void translateTo(LogEvent event, long sequence, String message) {
        event.setMessage(message);
    }
}
