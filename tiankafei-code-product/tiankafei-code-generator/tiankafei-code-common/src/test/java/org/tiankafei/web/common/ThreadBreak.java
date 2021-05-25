package org.tiankafei.web.common;

/**
 * 线程打断测试
 */
public class ThreadBreak implements Runnable {

    @Override
    public void run() {
        try {
            this.work();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("线程被中断了");
        }
    }

    public void work() throws InterruptedException {
        while (true) {
            System.out.println("A isInterrupted()=" + Thread.currentThread().isInterrupted());
            if (Thread.interrupted()) {
                System.out.println("B isInterrupted()=" + Thread.currentThread().isInterrupted());
                throw new InterruptedException();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new ThreadBreak());
        t.start();

        Thread.sleep(10);

        t.interrupt();

        System.out.println("over");


        Thread.sleep(1000000000000L);
    }
}