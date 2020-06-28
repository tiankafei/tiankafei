package org.tiankafei.java.juc.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.concurrent.Executors;

public class Main03 {
    public static void main(String[] args) {
        //must be power of 2
        int ringBufferSize = 1024;

        Disruptor<LongEvent> disruptor = new Disruptor<>(LongEvent::new, ringBufferSize, Executors.defaultThreadFactory());

        disruptor.handleEventsWith((longEvent, sequence, endOfBatch) -> System.out.println(longEvent.getValue()));

        disruptor.start();

        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        //
        ringBuffer.publishEvent((event, sequence) -> event.setValue(888L));
        ringBuffer.publishEvent((event, sequence, l) -> event.setValue(l), 10000L);
        ringBuffer.publishEvent((event, sequence, l1, l2) -> event.setValue(l1 + l2), 10000L, 20000L);
        ringBuffer.publishEvent((event, sequence, l1, l2, l3) -> event.setValue(l1 + l2 + l3), 10000L, 20000L, 30000L);
        ringBuffer.publishEvent((event, sequence, array) -> {
            long sum = 0L;
            for (int index = 0, length = array.length; index < length; index++) {
                sum += (Long) array[index];
            }
            event.setValue(sum);
        }, 10000L, 20000L, 30000L, 40000L);
        //
        disruptor.shutdown();
    }
}
