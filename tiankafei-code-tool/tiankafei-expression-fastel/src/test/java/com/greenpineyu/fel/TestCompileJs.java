package com.greenpineyu.fel;

import com.google.common.base.Stopwatch;
import com.greenpineyu.fel.context.FelContext;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

public class TestCompileJs {

    @Test
    public void test1() throws Exception {
        Stopwatch stopwatch = Stopwatch.createStarted();
        FelEngine engine = Fel.newEngine();
        FelContext felContext = engine.getContext();
        felContext.set("a", 1);
        felContext.set("b", 1);
        felContext.set("c", 1);
        felContext.set("d", 1);
        String expression = "'1'+'1'=='11'";
//        String expression = "a+b";
//        engine.compile(expression, felContext);
        engine.compileJs(expression, felContext);
//        System.out.println("执行结果：" + object);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void test2() throws Exception {
        Stopwatch stopwatch = Stopwatch.createStarted();
        FelEngine engine = Fel.newEngine();
        FelContext felContext = engine.getContext();
        String expression = "1+2";
        Expression compileExpression = engine.compile(expression, felContext);
        Object object = compileExpression.eval(felContext);
        System.out.println("执行结果：" + object);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

}
