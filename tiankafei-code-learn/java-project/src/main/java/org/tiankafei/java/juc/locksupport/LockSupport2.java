package org.tiankafei.java.juc.locksupport;

import org.tiankafei.base.base.util.ThreadSleepUtil;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author tiankafei
 * @Date 2019/12/6
 * @Version V1.0
 **/
public class LockSupport2 {

    public static void main(String[] args) {
        LockSupport2 lockSupport1 = new LockSupport2();
        lockSupport1.execute();
    }

    private void execute() {
        Thread t = new Thread(() -> {
            ThreadSleepUtil.sleepSeconds(5);
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if (i == 5) {
                    LockSupport.park();
                }
                ThreadSleepUtil.sleepSeconds(1);
            }
        });

        t.start();

        LockSupport.unpark(t);
    }

}
