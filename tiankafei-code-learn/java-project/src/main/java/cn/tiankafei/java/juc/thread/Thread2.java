package cn.tiankafei.java.juc.thread;

import cn.tiankafei.base.util.ThreadSleepUtil;

/**
 * 多线程的执行方式
 * //请你告诉我启动线程的三种方式 1：Thread 2: Runnable 3:Executors.newCachedThrad
 *
 * @Author 魏双双
 * @Date 2019/12/3
 * @Version V1.0
 **/
public class Thread2 {

    public static void main(String[] args) {
        Thread2 thread = new Thread2();
        thread.execute();
    }

    private void execute() {
        new T1().start();
        new Thread(new T2()).start();
        new Thread(() -> {
            ThreadSleepUtil.sleepMilliSeconds(10);
            System.out.println("Lambda!");
        }).start();
    }

    class T1 extends Thread {
        @Override
        public void run() {
            ThreadSleepUtil.sleepMilliSeconds(10);
            System.out.println("extend Thread!");
        }
    }

    class T2 implements Runnable {
        @Override
        public void run() {
            ThreadSleepUtil.sleepMilliSeconds(10);
            System.out.println("implements Runnable!");
        }
    }
}