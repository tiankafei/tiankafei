package org.tiankafei.java.juc.demo;

import org.tiankafei.base.base.util.ThreadSleepUtil;

import java.util.concurrent.Semaphore;

/**
 * @Author tiankafei
 * @Date 2019/12/3
 * @Version V1.0
 **/
public class Demo4 {

    private Thread t1 = null;
    private Thread t2 = null;

    private Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) {
        Demo4 demo = new Demo4();
        demo.execute();
    }

    private void execute() {
        t1 = new Thread(() -> {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 6; i++) {
                System.out.println(i);
                ThreadSleepUtil.sleepSeconds(1);
            }
            semaphore.release();
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 6; i < 10; i++) {
                System.out.println(i);
                ThreadSleepUtil.sleepSeconds(1);
            }
            semaphore.release();
        });

        t2 = new Thread(() -> {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("............");
            semaphore.release();
        });

        t1.start();
        t2.start();


    }

}
