package cn.tiankafei.base.juc.sync;

import cn.tiankafei.base.util.ThreadSleepUtil;

/**
 * synchronized异常会释放锁的测试（两个线程共同调用一个同步的方法）
 *
 * @Author 魏双双
 * @Date 2019/12/3
 * @Version V1.0
 **/
public class Synchronized3 {

    private static int count = 0;

    public static void main(String[] args) {
        Synchronized3 synchronized1 = new Synchronized3();
        new Thread(() -> {
            synchronized1.testThisSync();
        }, "t1").start();
        new Thread(() -> {
            synchronized1.testThisSync();
        }, "t2").start();
    }

    public void testThisSync() {
        //任何线程要执行下面的代码，必须先拿到当前对象的锁
        synchronized (this) {
            while (true) {
                count++;
                System.out.println(Thread.currentThread().getName() + " testThisSync count = " + count);
                ThreadSleepUtil.sleepSeconds(1);
                if (count == 5) {
                    int a = 1 / 0;
                    System.out.println(a);
                }
            }
        }
    }

}
