package cn.tiankafei.base.juc.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author 魏双双
 * @Date 2020/5/13
 * @Version V1.0
 **/
public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(2000);
                return "hello world";
            }
        };

        ExecutorService executorService = Executors.newCachedThreadPool();
//        Future<String> submit = executorService.submit(callable);
        Future<String> submit = executorService.submit(() -> {
            Thread.sleep(2000);
            return "hello world";
        });

        // 直接输出
        System.out.println("继续执行其他方法");
        // get方法会进行阻塞等待两秒后输出
        System.out.println(submit.get());

        executorService.shutdown();
    }

}
