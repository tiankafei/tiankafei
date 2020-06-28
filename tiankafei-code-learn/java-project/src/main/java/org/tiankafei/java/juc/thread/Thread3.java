package org.tiankafei.java.juc.thread;

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
public class Thread3 {

    public static void main(String[] args) {
        Thread3 thread = new Thread3();
        thread.execute();
    }

    private void execute() {
        testSleep();
//        testYield();
//        testJoin();
    }

    private void testSleep() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                System.out.println("A" + i);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("B" + i);
            }
        });
        t1.start();
        t2.start();
    }

    private void testYield() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                System.out.println("A" + i);
            }
        });
        Thread t2 = new Thread(() -> {
            //比sleep更高效
            Thread.yield();
            for (int i = 0; i < 10; i++) {
                System.out.println("B" + i);
            }
        });
        t1.start();
        t2.start();
    }

    private void testJoin() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("A" + i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 100; i++) {
                System.out.println("B" + i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }

}