package org.tiankafei.base.base.juc.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class LockSupportTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i == 1) {
                    LockSupport.park();
                }
                if (i == 2) {
                    LockSupport.park();
                }
            }
        });
        t.start();

        Thread.sleep(1000);
        LockSupport.unpark(t);
        Thread.sleep(1000);
        LockSupport.unpark(t);
    }

}
