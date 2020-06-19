package cn.tiankafei.base.juc.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.concurrent.Executors;

public class Main01 {
    public static void main(String[] args) {
        LongEventFactory factory = new LongEventFactory();

        //must be power of 2
        int ringBufferSize = 1024;

        Disruptor<LongEvent> disruptor = new Disruptor<>(factory, ringBufferSize, Executors.defaultThreadFactory());

        disruptor.handleEventsWith(new LongEventHandler());

        disruptor.start();

        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        //
        long sequence = ringBuffer.next();
        LongEvent longEvent = ringBuffer.get(sequence);
        longEvent.setValue(888L);
        ringBuffer.publish(sequence);
        //
        disruptor.shutdown();
    }
}
