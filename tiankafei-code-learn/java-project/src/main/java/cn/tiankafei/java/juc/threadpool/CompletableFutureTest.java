package cn.tiankafei.java.juc.threadpool;

import com.google.common.base.Stopwatch;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Author 魏双双
 * @Date 2020/5/13
 * @Version V1.0
 **/
public class CompletableFutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Stopwatch started = Stopwatch.createStarted();
        CompletableFuture c1 = CompletableFuture.supplyAsync(CompletableFutureTest::get1);
        CompletableFuture c2 = CompletableFuture.supplyAsync(CompletableFutureTest::get2);
        CompletableFuture c3 = CompletableFuture.supplyAsync(CompletableFutureTest::get3);

        CompletableFuture.allOf(c1, c2, c3).join();
        System.out.println(c1.get());
        System.out.println(c2.get());
        System.out.println(c3.get());
        System.out.println(started.elapsed(TimeUnit.MILLISECONDS));

        c1 = CompletableFuture.supplyAsync(CompletableFutureTest::get1);
        c2 = CompletableFuture.supplyAsync(CompletableFutureTest::get2);
        c3 = CompletableFuture.supplyAsync(CompletableFutureTest::get3);
        started.reset().start();

        Object join = CompletableFuture.anyOf(c1, c2, c3).join();
        System.out.println(join);
        System.out.println(started.elapsed(TimeUnit.MILLISECONDS));

        CompletableFuture.supplyAsync(CompletableFutureTest::get1)
                .thenApply(String::valueOf)
                .thenApply(str -> "price: " + str)
                .thenAccept(System.out::println)
                .join();
    }

    private static String get3() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "3";
    }

    private static String get2() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "2";
    }

    private static String get1() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "1";
    }

}
