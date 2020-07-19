package org.tiankafei.base.juc.thread;

import java.util.concurrent.Executors;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class TestJuc01 {

    public static void main(String[] args) {
        TestJuc01 testJuc01 = new TestJuc01();
        testJuc01.test();
    }

    private void test() {
        new TestThread().start();
        new Thread(new TestRunnable()).start();
        new Thread(() -> {
            System.out.println("使用 lambda 方式的线程开始执行......");
        }).start();

        Executors.newCachedThreadPool().submit(() -> {
            System.out.println("使用 线程池 方式的线程开始执行......");
        });
    }

    class TestRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("实现 Runnable 接口的线程开始执行......");
        }
    }

    class TestThread extends Thread {
        @Override
        public void run() {
            System.out.println("继承 Thread 方式的线程开始执行......");
        }
    }

}
