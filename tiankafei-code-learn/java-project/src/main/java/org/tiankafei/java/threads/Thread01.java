package org.tiankafei.java.threads;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class Thread01 {

    public static void main(String[] args) throws Exception {
        Stopwatch stopwatch = Stopwatch.createStarted();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                calc();
            }
        };

        int size = 100_000;

        Thread[] threads = new Thread[size];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(r);
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

    public static void calc() {
        int result = 0;
        for (int m = 0; m < 10_000; m++) {
            for (int i = 0; i < 200; i++) {
                result += i;
            }
        }
    }

}
