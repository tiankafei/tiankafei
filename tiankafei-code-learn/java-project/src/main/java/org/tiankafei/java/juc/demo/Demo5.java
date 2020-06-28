package org.tiankafei.java.juc.demo;

import cn.tiankafei.base.util.ThreadSleepUtil;

/**
 * @Author tiankafei
 * @Date 2019/12/3
 * @Version V1.0
 **/
public class Demo5 {

    private Object o = new Object();

    public static void main(String[] args) {
        Demo5 demo = new Demo5();
        demo.execute();
    }

    private void execute() {
        new Thread(() -> {
            String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            for (int i = 0; i < str.length(); i++) {
                synchronized (o) {
                    try {
                        char c = str.charAt(i);
                        System.out.println(c);
                        ThreadSleepUtil.sleepMilliSeconds(100);
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            synchronized (o) {
                o.notify();
            }
        }).start();
        new Thread(() -> {
            for (int i = 1; i < 27; i++) {
                synchronized (o) {
                    try {
                        System.out.println(i);
                        ThreadSleepUtil.sleepMilliSeconds(100);
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            synchronized (o) {
                o.notify();
            }
        }).start();
    }

}
