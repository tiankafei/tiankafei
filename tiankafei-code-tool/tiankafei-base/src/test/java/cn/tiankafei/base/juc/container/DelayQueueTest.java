package cn.tiankafei.base.juc.container;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

/**
 * @Author 魏双双
 * @Date 2020/5/7
 * @Version V1.0
 **/
public class DelayQueueTest {

    public static void main(String[] args) {

        BlockingQueue<DelayTask> queue = new DelayQueue<DelayTask>();

        for (int i = 0; i < 10; i++) {
            try {
                queue.put(new DelayTask("work " + i, 2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        ThreadGroup g = new ThreadGroup("Consumers");

        for (int i = 0; i < 1; i++) {
            new Thread(g, new DelayTaskComsumer(queue)).start();
        }

        while (DelayTask.taskCount.get() > 0) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        g.interrupt();
        System.out.println("Main thread finished");
    }

}
