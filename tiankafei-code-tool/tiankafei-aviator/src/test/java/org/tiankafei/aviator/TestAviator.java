package org.tiankafei.aviator;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Maps;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.tiankafei.aviator.util.AviatorUtil;

public class TestAviator {

    @Before
    public void before(){
        AviatorUtil.initFun();
    }

    @Test
    public void testAbs() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "abs(a)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "-12");
        System.out.println(expression.execute(dataMap));
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testAdd() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "add(a, b)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "12");
        dataMap.put("b", 12);
        System.out.println(expression.execute(dataMap));
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testAddOp() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "a + b";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "12");
        dataMap.put("b", 1);
        System.out.println(expression.execute(dataMap));
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testSub() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "sub(a, b)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "12");
        dataMap.put("b", 3);
        System.out.println(expression.execute(dataMap));
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testSubOp() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "a - b";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "12");
        dataMap.put("b", 2);
        System.out.println(expression.execute(dataMap));
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

}