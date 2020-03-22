package com.greenpineyu.fel;

import cn.tiankafei.base.util.SystemTimeUtil;
import org.junit.Test;

public class TestBigData {

    private int count = 10000 * 1;

    @Test
    public void test1() throws Exception {
        long currentTime = SystemTimeUtil.now();
        for (int i = 0; i < count; i++) {
            FelEngine engine = Fel.newEngine();
            String expression = "1+1";
            Object object = engine.eval(expression);
        }
        System.out.println("执行需要时间：" + (SystemTimeUtil.now() - currentTime) + "ms");
    }

    @Test
    public void test2() throws Exception {
        long currentTime = SystemTimeUtil.now();
        FelEngine engine = Fel.newEngine();
        String expression = "1+1";
        for (int i = 0; i < count; i++) {
            Object object = engine.eval(expression);
        }
        System.out.println("执行需要时间：" + (SystemTimeUtil.now() - currentTime) + "ms");
    }

    @Test
    public void test3() throws Exception {
        long currentTime = SystemTimeUtil.now();
        FelEngine engine = Fel.newEngine(false);
        for (int i = 0; i < count; i++) {
            String expression = "1+1";
            Object object = engine.eval(expression);
        }
        System.out.println("执行需要时间：" + (SystemTimeUtil.now() - currentTime) + "ms");
    }

    @Test
    public void test11() throws Exception {
        long currentTime = SystemTimeUtil.now();
        for (int i = 0; i < count; i++) {
            FelEngine engine = Fel.newEngine();
            String expression = "1+1";
            Expression expression1 = engine.compile(expression, null);
            Object object = expression1.eval(null);
        }
        System.out.println("执行需要时间：" + (SystemTimeUtil.now() - currentTime) + "ms");
    }

    @Test
    public void test22() throws Exception {
        long currentTime = SystemTimeUtil.now();
        FelEngine engine = Fel.newEngine();
        for (int i = 0; i < count; i++) {
            String expression = "1+1";
            Expression expression1 = engine.compile(expression, null);
            Object object = expression1.eval(null);
        }
        System.out.println("执行需要时间：" + (SystemTimeUtil.now() - currentTime) + "ms");
    }

    @Test
    public void test33() throws Exception {
        long currentTime = SystemTimeUtil.now();
        FelEngine engine = Fel.newEngine();
        String expression = "1+1";
        Expression expression1 = engine.compile(expression, null);
        for (int i = 0; i < count; i++) {
            Object object = expression1.eval(null);
        }
        System.out.println("执行需要时间：" + (SystemTimeUtil.now() - currentTime) + "ms");
    }

}
