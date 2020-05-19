package cn.tiankafei.base.juc.demo;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class Demo9<T> {

    final private LinkedList<T> lists = new LinkedList<>();
    /**
     * 最多10个元素
     */
    final private int MAX = 10;
    private int count = 0;


    public synchronized void put(T t) {
        //想想为什么用while而不是用if？
        while (lists.size() == MAX) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        lists.add(t);
        ++count;
        //通知消费者线程进行消费
        this.notifyAll();
    }

    public synchronized T get() {
        T t = null;
        while (lists.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t = lists.removeFirst();
        count--;
        //通知生产者进行生产
        this.notifyAll();
        return t;
    }

    public static void main(String[] args) {
        Demo9<String> c = new Demo9<>();
        //启动消费者线程
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    System.out.println("消费者消费完成后剩余:" + c.get());
                }
            }, "c" + i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //启动生产者线程
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 25; j++) {
                    c.put(Thread.currentThread().getName() + " " + j);
                }
            }, "p" + i).start();
        }
    }

}
