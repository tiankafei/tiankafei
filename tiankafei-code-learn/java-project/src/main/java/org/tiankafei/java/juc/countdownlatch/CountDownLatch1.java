package org.tiankafei.java.juc.countdownlatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Author tiankafei
 * @Date 2019/12/6
 * @Version V1.0
 **/
public class CountDownLatch1 {

    private CountDownLatch countDownLatch = new CountDownLatch(10);

    public static void main(String[] args) {
        CountDownLatch1 countDownLatch1 = new CountDownLatch1();
        countDownLatch1.execute();
    }

    private void execute() {
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread t1 = new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "执行了");
                countDownLatch.countDown();
            }, i + "");
            threadList.add(t1);
        }

        for (int index = 0; index < threadList.size(); index++) {
            threadList.get(index).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("等待执行完成");
    }

}
