package cn.tiankafei.java.juc.demo;

import cn.tiankafei.base.util.ThreadSleepUtil;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author tiankafei
 * @Date 2019/12/3
 * @Version V1.0
 **/
public class Demo1 {

    private Thread t1 = null;
    private Thread t2 = null;

    public static void main(String[] args) {
        Demo1 demo = new Demo1();
        demo.execute();
    }

    private void execute() {
        t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                ThreadSleepUtil.sleepSeconds(1);
                if (i == 5) {
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
            }
        });

        t2 = new Thread(() -> {
            LockSupport.park();
            System.out.println("............");
            LockSupport.unpark(t1);
        });

        t1.start();
        t2.start();


    }

}
