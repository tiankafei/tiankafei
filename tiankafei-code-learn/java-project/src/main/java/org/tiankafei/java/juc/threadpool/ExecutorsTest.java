package org.tiankafei.java.juc.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author 魏双双
 * @Date 2020/5/13
 * @Version V1.0
 **/
public class ExecutorsTest {

    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        ExecutorService executorService1 = Executors.newCachedThreadPool();

        ExecutorService executorService2 = Executors.newFixedThreadPool(1);

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        ScheduledExecutorService scheduledExecutorService1 = Executors.newSingleThreadScheduledExecutor();

        ExecutorService executorService3 = Executors.newWorkStealingPool();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());

        threadPoolExecutor.allowCoreThreadTimeOut(true);


    }

}
