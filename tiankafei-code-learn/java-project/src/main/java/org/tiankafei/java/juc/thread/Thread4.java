package org.tiankafei.java.juc.thread;

import org.tiankafei.base.base.util.ThreadSleepUtil;

/**
 * 线程的:sleep\yield\join
 * sleep 暂停执行，暂定时间需要指定，不释放CPU资源
 * yield 暂停执行释放CPU，进入就绪状态
 * join 暂停本线程执行，等其他线程执行完成之后，再执行
 *
 * @Author 魏双双
 * @Date 2019/12/3
 * @Version V1.0
 **/
public class Thread4 {

    public static void main(String[] args) {
        Thread4 thread = new Thread4();
        thread.execute();
    }

    private void execute() {
        testState();
    }

    private void testState() {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("A" + i);
            }
        });
        System.out.println(t1.getState());
        t1.start();
        System.out.println(t1.getState());
        ThreadSleepUtil.sleepMilliSeconds(2);
        System.out.println(t1.getState());
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t1.getState());
    }

}