package org.tiankafei.java.threads;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.SuspendExecution;
import co.paralleluniverse.strands.SuspendableRunnable;
import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class Fiber01 {

    public static void main(String[] args) throws Exception {
        Stopwatch stopwatch = Stopwatch.createStarted();

        SuspendableRunnable runnable = new SuspendableRunnable() {
            @Override
            public void run() throws SuspendExecution, InterruptedException {
                Thread01.calc();
            }
        };

        int size = 100_000;

        Fiber<Void>[] fibers = new Fiber[size];

        for (int i = 0; i < fibers.length; i++) {
            fibers[i] = new Fiber<Void>(runnable);
        }

        for (int i = 0; i < fibers.length; i++) {
            fibers[i].start();
        }

        for (int i = 0; i < fibers.length; i++) {
            fibers[i].join();
        }

        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

}
