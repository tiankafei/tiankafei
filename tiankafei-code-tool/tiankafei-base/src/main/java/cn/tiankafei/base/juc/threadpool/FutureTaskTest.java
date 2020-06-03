package cn.tiankafei.base.juc.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author 魏双双
 * @Date 2020/5/13
 * @Version V1.0
 **/
public class FutureTaskTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(() -> {
            Thread.sleep(2000);
            return "hello world";
        });

        new Thread(futureTask).start();
        // 阻塞拿值
        System.out.println(futureTask.get());
    }

}
