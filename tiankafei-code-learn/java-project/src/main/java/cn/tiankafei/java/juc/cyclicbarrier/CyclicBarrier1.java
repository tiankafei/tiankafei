package cn.tiankafei.java.juc.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author tiankafei
 * @Date 2019/12/6
 * @Version V1.0
 **/
public class CyclicBarrier1 {

    private CyclicBarrier cyclicBarrier = new CyclicBarrier(20, () -> {
        System.out.println("开始执行了");
    });

    public static void main(String[] args) {
        CyclicBarrier1 cyclicBarrier1 = new CyclicBarrier1();
        cyclicBarrier1.execute();
    }

    private void execute() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}
