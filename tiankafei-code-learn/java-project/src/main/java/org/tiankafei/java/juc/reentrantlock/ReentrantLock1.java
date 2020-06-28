package org.tiankafei.java.juc.reentrantlock;

import cn.tiankafei.base.util.ThreadSleepUtil;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author tiankafei
 * @Date 2019/12/6
 * @Version V1.0
 **/
public class ReentrantLock1 {

    private ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        ReentrantLock1 reentrantLock1 = new ReentrantLock1();
        new Thread(() -> {
            reentrantLock1.execute1();
        }).start();
        new Thread(() -> {
            reentrantLock1.execute2();
        }).start();
    }

    private void execute1() {
        try {
            reentrantLock.lock();
            for (int i = 0; i < 10; i++) {
                System.out.println(i + "执行1");
                ThreadSleepUtil.sleepSeconds(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    private void execute2() {
        try {
            reentrantLock.lock();
            for (int i = 0; i < 10; i++) {
                System.out.println(i + "执行2");
                ThreadSleepUtil.sleepSeconds(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }


}
