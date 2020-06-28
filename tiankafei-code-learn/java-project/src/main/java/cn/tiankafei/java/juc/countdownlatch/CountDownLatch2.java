package cn.tiankafei.java.juc.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @Author tiankafei
 * @Date 2019/12/6
 * @Version V1.0
 **/
public class CountDownLatch2 {

    private CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) {
        CountDownLatch2 countDownLatch1 = new CountDownLatch2();
        countDownLatch1.execute();
    }

    private void execute() {
        countDownLatch.countDown();
        countDownLatch.countDown();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("等待执行完成");
    }

}
