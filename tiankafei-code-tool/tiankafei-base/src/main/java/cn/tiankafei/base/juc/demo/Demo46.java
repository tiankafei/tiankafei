package cn.tiankafei.base.juc.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author tiankafei
 * @Date 2019/12/3
 * @Version V1.0
 **/
public class Demo46 {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        new Thread(() -> {
            try {
                lock.lock();
                for (int index = 1; index < 27; index++) {
                    try {
                        condition1.await();
                        System.out.println(index);
                        condition2.signalAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                lock.lock();
                String str1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                for (int index = 0; index < str1.length(); index++) {
                    try {
                        System.out.println(str1.substring(index, index + 1));
                        condition1.signalAll();
                        condition2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
            }
        }).start();
    }

}
