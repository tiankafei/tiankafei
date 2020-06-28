package org.tiankafei.base.base.juc.demo;

import org.tiankafei.base.base.util.ThreadSleepUtil;

import java.util.concurrent.LinkedTransferQueue;

/**
 * @Author tiankafei
 * @Date 2019/12/3
 * @Version V1.0
 **/
public class Demo6 {

    private LinkedTransferQueue linkedTransferQueue1 = new LinkedTransferQueue();
//    private LinkedTransferQueue linkedTransferQueue2 = new LinkedTransferQueue();

    public static void main(String[] args) {
        Demo6 demo = new Demo6();
        demo.execute();
    }

    private void execute() {
        new Thread(() -> {
            String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            for (int i = 0; i < str.length(); i++) {
                try {
                    char c = str.charAt(i);
                    linkedTransferQueue1.transfer(c);
                    System.out.println(linkedTransferQueue1.take());
                    ThreadSleepUtil.sleepMilliSeconds(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(() -> {
            for (int i = 1; i < 27; i++) {
                try {
                    System.out.println(linkedTransferQueue1.take());
                    linkedTransferQueue1.transfer(i);
                    ThreadSleepUtil.sleepMilliSeconds(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

}
