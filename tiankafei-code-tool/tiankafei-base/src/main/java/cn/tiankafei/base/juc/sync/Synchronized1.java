package cn.tiankafei.base.juc.sync;

/**
 * synchronized的几种形式
 *
 * @Author 魏双双
 * @Date 2019/12/3
 * @Version V1.0
 **/
public class Synchronized1 {

    private static int count = 40;
    private Object object = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            testClassSync();
        }).start();

        Synchronized1 synchronized1 = new Synchronized1();
        new Thread(() -> {
            synchronized1.testObjectSync();
        }).start();
        new Thread(() -> {
            synchronized1.testThisSync();
        }).start();
        new Thread(() -> {
            synchronized1.testSyncMethod();
        }).start();
    }

    public void testThisSync() {
        //任何线程要执行下面的代码，必须先拿到当前对象的锁
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                count--;
                System.out.println(Thread.currentThread().getName() + " testThisSync count = " + count);
            }
        }
    }

    public void testObjectSync() {
        //任何线程要执行下面的代码，必须先拿到object的锁
        synchronized (object) {
            for (int i = 0; i < 10; i++) {
                count--;
                System.out.println(Thread.currentThread().getName() + " testObjectSync count = " + count);
            }
        }
    }

    public synchronized void testSyncMethod() {
        for (int i = 0; i < 10; i++) {
            count--;
            System.out.println(Thread.currentThread().getName() + " testSyncMethod count = " + count);
        }
    }

    public static void testClassSync() {
        //任何线程要执行下面的代码，必须先拿到Synchronized1对象的锁
        synchronized (Synchronized1.class) {
            for (int i = 0; i < 10; i++) {
                count--;
                System.out.println(Thread.currentThread().getName() + " testClassSync count = " + count);
            }
        }
    }

}
