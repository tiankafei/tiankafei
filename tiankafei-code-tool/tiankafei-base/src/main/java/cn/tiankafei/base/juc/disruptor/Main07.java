package cn.tiankafei.base.juc.disruptor;

import com.lmax.disruptor.ExceptionHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SleepingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main07 {
    public static void main(String[] args) throws InterruptedException {
        LongEventFactory factory = new LongEventFactory();

        //must be power of 2
        int ringBufferSize = 1024;

        Disruptor<LongEvent> disruptor = new Disruptor<>(factory, ringBufferSize, Executors.defaultThreadFactory(), ProducerType.MULTI, new SleepingWaitStrategy());

        LongEventExceptionHandler h1 = new LongEventExceptionHandler();
        LongEventExceptionHandler h2 = new LongEventExceptionHandler();
        disruptor.handleEventsWith(h1, h2);
        disruptor.handleExceptionsFor(h1).with(new ExceptionHandler<LongEvent>() {
            @Override
            public void handleEventException(Throwable ex, long sequence, LongEvent event) {
                ex.printStackTrace();
            }

            @Override
            public void handleOnStartException(Throwable ex) {
                System.out.println("Exception Start to Handle" + ex.getMessage());
            }

            @Override
            public void handleOnShutdownException(Throwable ex) {
                System.out.println("Exception Shutdown to Handle" + ex.getMessage());
            }
        });
        disruptor.start();

        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        //
        final int threadCount = 4;
        CyclicBarrier barrier = new CyclicBarrier(threadCount);
        ExecutorService service = Executors.newCachedThreadPool();
        for (long i = 0; i < threadCount; i++) {
            final long threadNum = i;
            service.submit(() -> {
                System.out.printf("Thread %s ready to start!\n", threadNum);
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

                for (int j = 0; j < 1; j++) {
                    ringBuffer.publishEvent((event, sequence) -> {
                        event.setValue(threadNum);
                        System.out.println("生产了 " + threadNum);
                    });
                }
            });
        }
        //
        service.shutdown();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(LongEventHandler.count);
    }
}
