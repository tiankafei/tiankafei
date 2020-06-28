package org.tiankafei.java.juc.locksupport;

import cn.tiankafei.base.util.ThreadSleepUtil;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author tiankafei
 * @Date 2019/12/6
 * @Version V1.0
 **/
public class LockSupport1 {

    public static void main(String[] args) {
        LockSupport1 lockSupport1 = new LockSupport1();
        lockSupport1.execute();
    }

    private void execute() {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if (i == 5) {
                    LockSupport.park();
                }
                ThreadSleepUtil.sleepSeconds(1);
            }
        });

        t.start();

        ThreadSleepUtil.sleepSeconds(8);
        LockSupport.unpark(t);
    }

}
