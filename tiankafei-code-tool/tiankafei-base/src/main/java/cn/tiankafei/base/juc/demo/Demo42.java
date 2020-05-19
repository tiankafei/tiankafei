package cn.tiankafei.base.juc.demo;

import java.util.concurrent.LinkedTransferQueue;

/**
 * @Author tiankafei
 * @Date 2019/12/3
 * @Version V1.0
 **/
public class Demo42 {

    public static void main(String[] args) {
        LinkedTransferQueue linkedTransferQueue = new LinkedTransferQueue();

        new Thread(() -> {
            for (int index = 1; index < 27; index++) {
                try {
                    System.out.println(linkedTransferQueue.take());
                    linkedTransferQueue.transfer(index + "");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            String str1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            for (int index = 0; index < str1.length(); index++) {
                try {
                    linkedTransferQueue.transfer(str1.substring(index, index + 1));
                    System.out.println(linkedTransferQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
