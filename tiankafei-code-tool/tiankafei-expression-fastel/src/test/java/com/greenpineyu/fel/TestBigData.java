package com.greenpineyu.fel;

import com.google.common.base.Stopwatch;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

public class TestBigData {

    private int count = 10000 * 1;

    @Test
    public void test1() throws Exception {
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < count; i++) {
            FelEngine engine = Fel.newEngine();
            String expression = "1+1";
            Object object = engine.eval(expression);
        }
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void test2() throws Exception {
        Stopwatch stopwatch = Stopwatch.createStarted();
        FelEngine engine = Fel.newEngine();
        String expression = "1+1";
        for (int i = 0; i < count; i++) {
            Object object = engine.eval(expression);
        }
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void test3() throws Exception {
        Stopwatch stopwatch = Stopwatch.createStarted();
        FelEngine engine = Fel.newEngine(false);
        for (int i = 0; i < count; i++) {
            String expression = "1+1";
            Object object = engine.eval(expression);
        }
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void test11() throws Exception {
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < count; i++) {
            FelEngine engine = Fel.newEngine();
            String expression = "1+1";
            Expression expression1 = engine.compile(expression, null);
            Object object = expression1.eval(null);
        }
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void test22() throws Exception {
        Stopwatch stopwatch = Stopwatch.createStarted();
        FelEngine engine = Fel.newEngine();
        for (int i = 0; i < count; i++) {
            String expression = "1+1";
            Expression expression1 = engine.compile(expression, null);
            Object object = expression1.eval(null);
        }
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void test33() throws Exception {
        Stopwatch stopwatch = Stopwatch.createStarted();
        FelEngine engine = Fel.newEngine();
        String expression = "1+1";
        Expression expression1 = engine.compile(expression, null);
        for (int i = 0; i < count; i++) {
            Object object = expression1.eval(null);
        }
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

}
