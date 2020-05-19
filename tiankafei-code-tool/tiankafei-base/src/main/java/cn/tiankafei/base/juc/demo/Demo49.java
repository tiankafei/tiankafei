package cn.tiankafei.base.juc.demo;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author tiankafei
 * @Date 2019/12/3
 * @Version V1.0
 **/
public class Demo49 {

    public static void main(String[] args) {

        ArrayBlockingQueue arrayBlockingQueue1 = new ArrayBlockingQueue(1);
        ArrayBlockingQueue arrayBlockingQueue2 = new ArrayBlockingQueue(1);

        new Thread(() -> {
            for (int index = 1; index < 27; index++) {
                try {
                    System.out.println(arrayBlockingQueue2.take());
                    arrayBlockingQueue1.put(index);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            String str1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            for (int index = 0; index < str1.length(); index++) {
                try {
                    arrayBlockingQueue2.put(str1.substring(index, index + 1));
                    System.out.println(arrayBlockingQueue1.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

}
