package cn.tiankafei.base.juc.disruptor;

import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.EventTranslatorThreeArg;
import com.lmax.disruptor.EventTranslatorTwoArg;
import com.lmax.disruptor.EventTranslatorVararg;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;

public class Main02 {
    public static void main(String[] args) {
        LongEventFactory factory = new LongEventFactory();

        //must be power of 2
        int ringBufferSize = 1024;

        Disruptor<LongEvent> disruptor = new Disruptor<>(factory, ringBufferSize, DaemonThreadFactory.INSTANCE);

        disruptor.handleEventsWith(new LongEventHandler());

        disruptor.start();

        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        //
        EventTranslator<LongEvent> eventTranslator1 = new EventTranslator<LongEvent>() {
            @Override
            public void translateTo(LongEvent event, long sequence) {
                event.setValue(8888L);
            }
        };
        ringBuffer.publishEvent(eventTranslator1);
        //
        EventTranslatorOneArg<LongEvent, Long> eventTranslator2 = new EventTranslatorOneArg<LongEvent, Long>() {
            @Override
            public void translateTo(LongEvent event, long sequence, Long l) {
                event.setValue(l);
            }
        };
        ringBuffer.publishEvent(eventTranslator2, 10000L);
        //
        EventTranslatorTwoArg<LongEvent, Long, Long> eventTranslator3 = new EventTranslatorTwoArg<LongEvent, Long, Long>() {
            @Override
            public void translateTo(LongEvent event, long sequence, Long l1, Long l2) {
                event.setValue(l1 + l2);
            }
        };
        ringBuffer.publishEvent(eventTranslator3, 10000L, 20000L);
        //
        EventTranslatorThreeArg<LongEvent, Long, Long, Long> eventTranslator4 = new EventTranslatorThreeArg<LongEvent, Long, Long, Long>() {
            @Override
            public void translateTo(LongEvent event, long sequence, Long l1, Long l2, Long l3) {
                event.setValue(l1 + l2 + l3);
            }
        };
        ringBuffer.publishEvent(eventTranslator4, 10000L, 20000L, 30000L);
        //
        EventTranslatorVararg<LongEvent> eventTranslator5 = new EventTranslatorVararg<LongEvent>() {
            @Override
            public void translateTo(LongEvent event, long sequence, Object... args) {
                long sum = 0L;
                for (int index = 0, length = args.length; index < length; index++) {
                    sum += (Long) args[index];
                }
                event.setValue(sum);
            }
        };
        ringBuffer.publishEvent(eventTranslator5, 10000L, 20000L, 30000L, 40000L);
        //

        disruptor.shutdown();
    }
}
