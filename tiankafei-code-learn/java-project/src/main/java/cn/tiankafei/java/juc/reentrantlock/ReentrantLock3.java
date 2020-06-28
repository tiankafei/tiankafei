package cn.tiankafei.java.juc.reentrantlock;

import cn.tiankafei.base.util.ThreadSleepUtil;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author tiankafei
 * @Date 2019/12/6
 * @Version V1.0
 **/
public class ReentrantLock3 {

    private ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        ReentrantLock3 reentrantLock1 = new ReentrantLock3();
        Thread t1 = new Thread(() -> {
            reentrantLock1.execute1();
        });
        t1.start();

        ThreadSleepUtil.sleepSeconds(2);
        t1.interrupt();
    }

    private void execute1() {
        try {
            reentrantLock.lockInterruptibly();
            System.out.println("执行execute1 start");
            ThreadSleepUtil.sleepSeconds(Integer.MAX_VALUE);
            System.out.println("执行execute1 end");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

}
