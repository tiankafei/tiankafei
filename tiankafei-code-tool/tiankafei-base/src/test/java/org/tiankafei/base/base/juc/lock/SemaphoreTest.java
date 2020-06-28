package org.tiankafei.base.base.juc.lock;

import java.util.concurrent.Semaphore;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class SemaphoreTest {

    public static void main(String[] args) {
        // 允许permits个线程同时执行
        Semaphore semaphore = new Semaphore(1, true);

        new Thread(() -> {
            try {
                semaphore.acquire();

                System.out.println("T1 running...");
                Thread.sleep(200);
                System.out.println("T1 running...");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }).start();

        new Thread(() -> {
            try {
                semaphore.acquire();

                System.out.println("T2 running...");
                Thread.sleep(200);
                System.out.println("T2 running...");

                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
