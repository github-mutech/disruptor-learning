package com.mutech.disruptor.learning.disruptor.sample;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.WaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.ThreadFactory;

public class ApplicationMain {
    public static void main(String[] args) {
        // 事件工厂,用于创建event
        LogEventFactory logEventFactory = new LogEventFactory();
        // 指定ringBufferSize
        int ringBufferSize = 2;
        // 线程工厂
        ThreadFactory threadFactory = new LogEventThreadFactory();
        // 生产者类型
        ProducerType producerType = ProducerType.MULTI;
        // 等待策略
        WaitStrategy waitStrategy = new BlockingWaitStrategy();
        // 创建disruptor
        Disruptor<LogEvent> disruptor = new Disruptor<>(logEventFactory, ringBufferSize, threadFactory, producerType, waitStrategy);
        // 创建 事件处理器
        EventHandler<LogEvent> eventHandler = new LogEventHandler();
        // 将handler添加至disruptor
        disruptor.handleEventsWith(eventHandler);
        // 启动
        disruptor.start();

        //-----------万事俱备,只欠消息(消息的生产者投递消息)
        // 获取 ringBuffer
        RingBuffer<LogEvent> ringBuffer = disruptor.getRingBuffer();
        // 创建ringBuffer的生产者
        LogEventProducer producer = new LogEventProducer(ringBuffer);
        // 然后生产者开始生产
        for (int i = 0; i < 1000; i++) {
            producer.publishData("" + i);
        }
    }
}
