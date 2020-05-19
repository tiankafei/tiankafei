package cn.tiankafei.base.juc.demo;

import java.util.concurrent.SynchronousQueue;

/**
 * @Author tiankafei
 * @Date 2019/12/3
 * @Version V1.0
 **/
public class Demo41 {

    public static void main(String[] args) {
        SynchronousQueue synchronousQueue = new SynchronousQueue();

        new Thread(() -> {
            for (int index = 1; index < 27; index++) {
                try {
                    System.out.println(synchronousQueue.take());
                    synchronousQueue.put(index + "");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            String str1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            for (int index = 0; index < str1.length(); index++) {
                try {
                    synchronousQueue.put(str1.substring(index, index + 1));
                    System.out.println(synchronousQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
