package org.tiankafei.base.base.juc.lock;

import java.util.concurrent.Exchanger;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class ExchangerTest {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        new Thread(() -> {
            String s = "T1";
            try {
                // 阻塞，直到另外一个线程执行了 exchange 进行交换后，会继续执行
                s = exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + s);

        }, "t1").start();

        new Thread(() -> {
            String s = "T2";
            try {
                // 阻塞，直到另外一个线程执行了 exchange 进行交换后，会继续执行
                s = exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + s);

        }, "t2").start();
    }

}
