package org.tiankafei.java.juc.exchanger;

import java.util.concurrent.Exchanger;

/**
 * @Author tiankafei
 * @Date 2019/12/6
 * @Version V1.0
 **/
public class Exchanger1 {

    private Exchanger<String> exchanger = new Exchanger();

    public static void main(String[] args) {
        Exchanger1 exchanger1 = new Exchanger1();
        exchanger1.execute();
    }

    private void execute() {
        new Thread(() -> {
            String s = "T1";
            try {
                s = exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + s);

        }, "t1").start();


        new Thread(() -> {
            String s = "T2";
            try {
                s = exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + s);

        }, "t2").start();
    }

}
