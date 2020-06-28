package cn.tiankafei.java.juc.reentrantlock;

import cn.tiankafei.base.util.ThreadSleepUtil;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author tiankafei
 * @Date 2019/12/6
 * @Version V1.0
 **/
public class ReentrantLock4 {

    private ReentrantLock reentrantLock = new ReentrantLock(true);

    public static void main(String[] args) {
        ReentrantLock4 reentrantLock1 = new ReentrantLock4();
        reentrantLock1.execute();
    }

    private void execute() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    reentrantLock.lock();
                    System.out.println(Thread.currentThread().getName() + "获得锁");
                    ThreadSleepUtil.sleepSeconds(1);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }, i + "").start();
        }
    }

}
