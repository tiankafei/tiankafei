package cn.tiankafei.base.juc.vola;

import java.util.ArrayList;
import java.util.List;

/**
 * volatile不能保证原子性，不能代替synchronized
 *
 * @Author 魏双双
 * @Date 2019/12/4
 * @Version V1.0
 **/
public class Volatile3 {

    private volatile int value = 0;

    public static void main(String[] args) {
        Volatile3 vola = new Volatile3();
        vola.execute();
    }

    public /*synchronized*/ void change() {
        for (int i = 0; i < 10000; i++) {
            value++;
        }
    }

    public void execute() {
        List<Thread> threadList = new ArrayList<>();
        for (int index = 0; index < 10; index++) {
            Thread thread = new Thread(() -> {
                change();
            });
            threadList.add(thread);
        }
        for (int index = 0, length = threadList.size(); index < length; index++) {
            threadList.get(index).start();
        }
        for (int index = 0, length = threadList.size(); index < length; index++) {
            try {
                threadList.get(index).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(value);
    }

}
