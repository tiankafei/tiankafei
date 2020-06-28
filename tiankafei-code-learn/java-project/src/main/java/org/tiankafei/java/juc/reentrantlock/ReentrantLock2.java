package org.tiankafei.java.juc.reentrantlock;

import cn.tiankafei.base.util.ThreadSleepUtil;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author tiankafei
 * @Date 2019/12/6
 * @Version V1.0
 **/
public class ReentrantLock2 {

    private ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        ReentrantLock2 reentrantLock1 = new ReentrantLock2();
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
            for (int i = 0; i < 6; i++) {
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
        boolean flag = false;
        try {
            flag = reentrantLock.tryLock(8, TimeUnit.SECONDS);
            System.out.println(flag);
            if (flag) {
                for (int i = 0; i < 2; i++) {
                    System.out.println(i + "执行2");
                    ThreadSleepUtil.sleepSeconds(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (flag) {
                reentrantLock.unlock();
            }
        }
    }


}
