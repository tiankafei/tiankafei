package org.tiankafei.java.juc.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * synchronized (lock) {
 * count++;
 * }
 * AtomicLong:count2.incrementAndGet()（就一段锁）
 * LongAdder:count3.increment()（分段锁）
 * 当线程特别多的时候，LongAdder性能最快
 *
 * @Author 魏双双
 * @Date 2019/12/4
 * @Version V1.0
 **/
public class AtomicLongAdder1 {

    long count1 = 0L;
    AtomicLong count2 = new AtomicLong(0L);
    LongAdder count3 = new LongAdder();

    public static void main(String[] args) {
        AtomicLongAdder1 atomicLongAdder1 = new AtomicLongAdder1();
        atomicLongAdder1.execute();
    }

    private void execute() {
        testLong();
        testAtomicLong();
        testLongAdder();
    }

    private void testLong() {
        long currentTime = System.currentTimeMillis();
        Object lock = new Object();
        List<Thread> threadList = new ArrayList<>();
        for (int index = 0; index < 1000; index++) {
            Thread thread = new Thread(() -> {
                for (int i = 0; i < 100000; i++) {
                    synchronized (lock) {
                        count1++;
                    }
                }
            });
            threadList.add(thread);
        }
        for (int index = 0, length = threadList.size(); index < length; index++) {
            threadList.get(index).start();
        }
        for (int index = 0, length = threadList.size(); index < length; index++) {
            try {
                threadList.get(index).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("testLong执行完成：" + count1 + "   用时：" + (System.currentTimeMillis() - currentTime) + "ms");
    }

    private void testAtomicLong() {
        long currentTime = System.currentTimeMillis();
        List<Thread> threadList = new ArrayList<>();
        for (int index = 0; index < 1000; index++) {
            Thread thread = new Thread(() -> {
                for (int i = 0; i < 100000; i++) {
                    count2.incrementAndGet();
                }
            });
            threadList.add(thread);
        }
        for (int index = 0, length = threadList.size(); index < length; index++) {
            threadList.get(index).start();
        }
        for (int index = 0, length = threadList.size(); index < length; index++) {
            try {
                threadList.get(index).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("testAtomicLong执行完成：" + count1 + "   用时：" + (System.currentTimeMillis() - currentTime) + "ms");
    }

    private void testLongAdder() {
        long currentTime = System.currentTimeMillis();
        List<Thread> threadList = new ArrayList<>();
        for (int index = 0; index < 1000; index++) {
            Thread thread = new Thread(() -> {
                for (int i = 0; i < 100000; i++) {
                    count3.increment();
                }
            });
            threadList.add(thread);
        }
        for (int index = 0, length = threadList.size(); index < length; index++) {
            threadList.get(index).start();
        }
        for (int index = 0, length = threadList.size(); index < length; index++) {
            try {
                threadList.get(index).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("testLongAdder执行完成：" + count1 + "   用时：" + (System.currentTimeMillis() - currentTime) + "ms");
    }


}
