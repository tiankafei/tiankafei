package org.tiankafei.java.juc.thread;

import cn.tiankafei.base.util.ThreadSleepUtil;

/**
 * 多线程的执行情况
 *
 * @Author 魏双双
 * @Date 2019/12/3
 * @Version V1.0
 **/
public class Thread1 {

    public static void main(String[] args) {
        Thread1 thread = new Thread1();
        thread.execute();
    }

    private void execute() {
        new T1().start();
        for (int i = 0; i < 10; i++) {
            ThreadSleepUtil.sleepMilliSeconds(10);
            System.out.println("main");
        }
    }

    class T1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                ThreadSleepUtil.sleepMilliSeconds(10);
                System.out.println("T1");
            }
        }
    }

}