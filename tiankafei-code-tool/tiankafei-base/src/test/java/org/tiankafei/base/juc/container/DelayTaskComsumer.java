package org.tiankafei.base.juc.container;

import java.util.concurrent.BlockingQueue;

/**
 * @Author 魏双双
 * @Date 2020/5/7
 * @Version V1.0
 **/
public class DelayTaskComsumer extends Thread {
    private final BlockingQueue<DelayTask> queue;

    public DelayTaskComsumer(BlockingQueue<DelayTask> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        DelayTask task = null;
        try {
            while (true) {
                task = queue.take();
                task.execTask();
                DelayTask.taskCount.decrementAndGet();
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + " finished");
        }
    }
}
