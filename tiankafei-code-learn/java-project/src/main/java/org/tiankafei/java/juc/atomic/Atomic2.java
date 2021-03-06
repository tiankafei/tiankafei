package org.tiankafei.java.juc.atomic;

import org.tiankafei.base.base.util.ThreadSleepUtil;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * AtomicInteger可以保证原子性，以原子的方式+1
 *
 * @Author 魏双双
 * @Date 2019/12/4
 * @Version V1.0
 **/
public class Atomic2 {

    private AtomicBoolean atomicBoolean = new AtomicBoolean();

    public static void main(String[] args) {
        Atomic2 vola = new Atomic2();
//        new Thread(vola::changeValue, "t1").start();

        new Thread(() -> {
            vola.changeValue();
        }).start();
        vola.execute();
    }

    public void execute() {
        ThreadSleepUtil.sleepSeconds(1);
        atomicBoolean.getAndSet(false);
    }

    public void changeValue() {
        System.out.println("修改值之前输出..................");
        while (atomicBoolean.get()) {

        }
    }

}
