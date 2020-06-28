package org.tiankafei.java.juc.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger可以保证原子性，以原子的方式+1
 *
 * @Author 魏双双
 * @Date 2019/12/4
 * @Version V1.0
 **/
public class Atomic1 {

    private AtomicInteger value = new AtomicInteger(0);

    public static void main(String[] args) {
        Atomic1 vola = new Atomic1();
        vola.execute();
    }

    public void change() {
        for (int i = 0; i < 10000; i++) {
//            value.getAndIncrement();
            value.incrementAndGet();
        }
    }

    public void execute() {
        List<Thread> threadList = new ArrayList<>();
        for (int index = 0; index < 10; index++) {
            Thread thread = new Thread(() -> {
                change();
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
        System.out.println(value);
    }

}
