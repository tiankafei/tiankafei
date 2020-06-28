package org.tiankafei.java.juc.demo;

import org.tiankafei.base.base.util.ThreadSleepUtil;

/**
 * @Author tiankafei
 * @Date 2019/12/3
 * @Version V1.0
 **/
public class Demo3 {

    private Thread t1 = null;
    private Thread t2 = null;

    private Object o1 = new Object();

    public static void main(String[] args) {
        Demo3 demo = new Demo3();
        demo.execute();
    }

    private void execute() {
        t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                ThreadSleepUtil.sleepSeconds(1);
                if (i == 5) {
                    synchronized (o1) {
                        try {
                            o1.notify();
                            o1.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        t2 = new Thread(() -> {
            synchronized (o1) {
                try {
                    o1.wait();
                    System.out.println("............");
                    o1.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();


    }

}
