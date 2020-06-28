package cn.tiankafei.java.juc.sync;

/**
 * synchronized的可重入测试
 *
 * @Author 魏双双
 * @Date 2019/12/3
 * @Version V1.0
 **/
public class Synchronized2 {

    protected static int count = 10;
    private Object object = new Object();

    public void testThisSync() {
        //任何线程要执行下面的代码，必须先拿到当前对象的锁
        synchronized (this) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

    public void testObjectSync() {
        //任何线程要执行下面的代码，必须先拿到object的锁
        synchronized (object) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

    public synchronized void testSyncMethod() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
        testThisSync();
    }

}

class Synchronized2Impl extends Synchronized2 {

    public static void main(String[] args) {
        Synchronized2Impl sync = new Synchronized2Impl();
        sync.testSyncMethod1();
    }

    public synchronized void testSyncMethod1() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);

        super.testSyncMethod();
        testSyncMethod3();
    }

    public void testSyncMethod2() {
        System.out.println("执行了testSyncMethod2方法");
    }

    public synchronized void testSyncMethod3() {
        System.out.println("执行了testSyncMethod3方法");
        testSyncMethod2();
    }

}
