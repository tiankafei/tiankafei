package org.tiankafei.java.juc.demo;

import org.tiankafei.base.base.util.ThreadSleepUtil;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author tiankafei
 * @Date 2019/12/3
 * @Version V1.0
 **/
public class Demo7 {

    private Thread t1 = null;
    private Thread t2 = null;

    public static void main(String[] args) {
        Demo7 demo = new Demo7();
        demo.execute();
    }

    private void execute() {
        t1 = new Thread(() -> {
            String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                System.out.println(c);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        });

        t2 = new Thread(() -> {
            for (int i = 1; i < 27; i++) {
                LockSupport.park();
                System.out.println(i);
                ThreadSleepUtil.sleepMilliSeconds(100);
                LockSupport.unpark(t1);
            }
        });

        t1.start();
        t2.start();
    }

}
