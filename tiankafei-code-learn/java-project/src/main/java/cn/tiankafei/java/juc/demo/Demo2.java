package cn.tiankafei.java.juc.demo;

import cn.tiankafei.base.util.ThreadSleepUtil;

import java.util.concurrent.CountDownLatch;

/**
 * @Author tiankafei
 * @Date 2019/12/3
 * @Version V1.0
 **/
public class Demo2 {

    private Thread t1 = null;
    private Thread t2 = null;

    private CountDownLatch countDownLatch1 = new CountDownLatch(1);
    private CountDownLatch countDownLatch2 = new CountDownLatch(1);

    public static void main(String[] args) {
        Demo2 demo = new Demo2();
        demo.execute();
    }

    private void execute() {
        t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                ThreadSleepUtil.sleepSeconds(1);
                if (i == 5) {
                    countDownLatch1.countDown();
                    try {
                        countDownLatch2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t2 = new Thread(() -> {
            try {
                countDownLatch1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("............");
            countDownLatch2.countDown();
        });

        t1.start();
        t2.start();


    }

}
