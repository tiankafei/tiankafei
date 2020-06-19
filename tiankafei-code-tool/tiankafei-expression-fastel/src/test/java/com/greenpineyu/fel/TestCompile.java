package com.greenpineyu.fel;

import com.google.common.base.Stopwatch;
import com.greenpineyu.fel.context.ArrayCtxImpl;
import com.greenpineyu.fel.context.FelContext;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class TestCompile {

    @Test
    public void test1() throws Exception {
        Stopwatch stopwatch = Stopwatch.createStarted();
        FelEngine engine = Fel.newEngine();
        FelContext felContext = engine.getContext();
        felContext.set("a", 1);
        felContext.set("b", 1);
        String expression = "a+b";
        Expression compileExpression = engine.compile(expression, felContext);
        Object object = compileExpression.eval(felContext);
        System.out.println("执行结果：" + object);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void test2() throws Exception {
        Stopwatch stopwatch = Stopwatch.createStarted();
        FelEngine engine = Fel.newEngine();
        String expression = "a+b";
        FelContext felContext = new ArrayCtxImpl();
        felContext.set("a", "1");
        felContext.set("b", "1");
        Expression compileExpression = engine.compile(expression, felContext);
        Object object = compileExpression.eval(felContext);
        System.out.println("执行结果：" + object);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void test3() throws Exception {
        Stopwatch stopwatch = Stopwatch.createStarted();
        FelEngine engine = Fel.newEngine();
//        String expression = "IF(a1+a2==1,a4,a5)==\"1\"";
//        String expression = "IF(a1+a2==1,a4==a1,a5==v3)";
        String expression = "ABS(IF(a1+a2==1,a4,a5))";
        FelContext felContext = new ArrayCtxImpl();
        Expression compileExpression = engine.compile(expression, felContext);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

}
