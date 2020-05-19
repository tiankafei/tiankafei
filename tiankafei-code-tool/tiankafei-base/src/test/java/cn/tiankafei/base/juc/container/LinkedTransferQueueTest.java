package cn.tiankafei.base.juc.container;

import java.util.concurrent.LinkedTransferQueue;

/**
 * @Author 魏双双
 * @Date 2020/5/6
 * @Version V1.0
 **/
public class LinkedTransferQueueTest {

    public static void main(String[] args) {
        LinkedTransferQueue linkedTransferQueue = new LinkedTransferQueue();

        new Thread(()->{
            for (int i = 0; i < 2; i++) {
                new Thread(()->{
                    try {
                        String name = Thread.currentThread().getName();
                        System.out.println(name + "线程开始执行！");
                        linkedTransferQueue.transfer(name + "abcd");
//                        linkedTransferQueue.put(name + "abcd");
                        System.out.println(name + "线程执行完成！");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }, i+"").start();
            }
        }).start();

        new Thread(()->{
            while(true){
                try {
                    Thread.sleep(1000);
                    System.out.println("从队列中取出的值：" + linkedTransferQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

}
