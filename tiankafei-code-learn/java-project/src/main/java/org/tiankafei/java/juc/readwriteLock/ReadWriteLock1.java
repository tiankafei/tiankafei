package org.tiankafei.java.juc.readwriteLock;

import org.tiankafei.base.base.util.ThreadSleepUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author tiankafei
 * @Date 2019/12/6
 * @Version V1.0
 **/
public class ReadWriteLock1 {

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.writeLock();

    private int value = 0;

    public static void main(String[] args) {
        ReadWriteLock1 readWriteLock1 = new ReadWriteLock1();
        readWriteLock1.execute();
    }

    private void execute() {
        List<Thread> writeThreadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            writeThreadList.add(new Thread(() -> {
                write();
            }));
        }
        List<Thread> readThreadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            readThreadList.add(new Thread(() -> {
                read();
            }));
        }

        for (int i = 0; i < readThreadList.size(); i++) {
            readThreadList.get(i).start();
        }
        for (int i = 0; i < writeThreadList.size(); i++) {
            writeThreadList.get(i).start();
        }
    }

    private void write() {
        ThreadSleepUtil.sleepMilliSeconds(10);
        try {
            writeLock.lock();
            ThreadSleepUtil.sleepMilliSeconds(100);
            value++;
            System.out.println(Thread.currentThread().getName() + "写完后的值->：" + value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    private void read() {
        try {
            ThreadSleepUtil.sleepMilliSeconds(10);
            readLock.lock();
            ThreadSleepUtil.sleepMilliSeconds(100);
            System.out.println(Thread.currentThread().getName() + "读出的值->：" + value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }

}
