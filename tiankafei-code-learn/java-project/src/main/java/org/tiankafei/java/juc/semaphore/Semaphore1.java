package org.tiankafei.java.juc.semaphore;

import cn.tiankafei.base.util.ThreadSleepUtil;

import java.util.concurrent.Semaphore;

/**
 * @Author tiankafei
 * @Date 2019/12/6
 * @Version V1.0
 **/
public class Semaphore1 {

    private Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) {
        Semaphore1 semaphore1 = new Semaphore1();
        semaphore1.execute();
    }

    private void execute() {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                new Thread(() -> {
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + "开始执行了1");
                        ThreadSleepUtil.sleepMilliSeconds(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        semaphore.release();
                    }
                }, "t1---" + i).start();
                ThreadSleepUtil.sleepMilliSeconds(1000);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                new Thread(() -> {
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + "开始执行了2");
                        ThreadSleepUtil.sleepMilliSeconds(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        semaphore.release();
                    }
                }, "t2---" + i).start();
                ThreadSleepUtil.sleepMilliSeconds(1000);
            }
        }).start();

    }

}
