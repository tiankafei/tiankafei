package org.tiankafei.java.juc.vola;

import org.tiankafei.base.base.util.ThreadSleepUtil;

/**
 * volatile可以技术数据类型在线程之间可见，
 * 如果是引用类型(包括数组)的话，引用的地址发生变化时，可以在线程之间可见
 * 如果是引用对象的值发生了变化，不能保证内部属性的可见性
 *
 * @Author 魏双双
 * @Date 2019/12/4
 * @Version V1.0
 **/
public class Volatile2 {

    private boolean flag = true;

    private volatile static Volatile2 volatile2 = new Volatile2();

    public static void main(String[] args) {
        new Volatile2().execute();
    }

    private void change() {
        System.out.println("m start");
        while (flag) {
//			ThreadSleepUtil.sleepMilliSeconds(10);
        }
        System.out.println("m end!");
    }

    public void execute() {
        new Thread(volatile2::change, "t1").start();

        //lambda表达式 new Thread(new Runnable( run() {m()}
        ThreadSleepUtil.sleepSeconds(1);

        volatile2.flag = false;
    }

}
