package com.mutech.disruptor.learning.disruptor.sample;

/**
 * @author mutech
 */
public class LogEvent {
    private String message;

    public LogEvent() {
        System.out.println("LogEvent Constructor \t" + this);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
