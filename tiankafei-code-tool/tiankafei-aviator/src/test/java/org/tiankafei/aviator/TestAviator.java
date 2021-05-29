package org.tiankafei.aviator;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Maps;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.tiankafei.aviator.util.AviatorUtil;

public class TestAviator {

    @Before
    public void before() {
        AviatorUtil.initFun();
    }

    @Test
    public void testAdd() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "add(a, b)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "12");
        dataMap.put("b", 12);
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, 24);
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
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, 13);
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
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, 9);
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
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, 10);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testMul() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "mul(a, b)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "-12");
        dataMap.put("b", 2);
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, -24);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testMulOp() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "a * b";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "12");
        dataMap.put("b", -3);
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, -36);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testDiv() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "div(a, b)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "-12");
        dataMap.put("b", 2);
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, -6);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testDivOp() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "a / b";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "12");
        dataMap.put("b", -3);
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, -4);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testMod() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "mod(a, b)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "12");
        dataMap.put("b", -9);
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, 3);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testModOp() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "a % b";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "12");
        dataMap.put("b", -9);
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, 3);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testEquals() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "equals(a, b)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "12");
        dataMap.put("b", 12);
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, true);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testEqualsOp() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "a == b";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "12");
        dataMap.put("b", 12);
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, true);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testNotEquals() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "not_equals(a, b)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "12");
        dataMap.put("b", 12);
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, false);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testNotEqualsOp() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "a != b";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "12");
        dataMap.put("b", 12);
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, false);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testLessThen() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "less_then(a, b)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "12");
        dataMap.put("b", 12);
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, false);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testLessThenOp() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "a < b";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "12");
        dataMap.put("b", 12);
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, false);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testLessThenEquals() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "less_then_equals(a, b)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "12");
        dataMap.put("b", 12);
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, true);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testLessThenEqualsOp() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "a <= b";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "12");
        dataMap.put("b", 12);
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, true);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testGreaterThen() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "greater_then(a, b)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "12");
        dataMap.put("b", 12);
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, false);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testGreaterThenOp() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "a > b";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "12");
        dataMap.put("b", 12);
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, false);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testGreaterThenEquals() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "greater_then_equals(a, b)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "12");
        dataMap.put("b", 12);
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, true);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testGreaterThenEqualsOp() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "a >= b";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "12");
        dataMap.put("b", 12);
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, true);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testAnd() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "and(a > 0, b > 1, b > 5)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "12");
        dataMap.put("b", 12);
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, true);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testAndOp() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "a >= 0 && b > 1 && b > 3";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "12");
        dataMap.put("b", 12);
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, true);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testOr() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "or(a > 0, b > 1, b > 5)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "-12");
        dataMap.put("b", -12);
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, false);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testOrOp() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "a >= 0 || b > 1 || b > 3";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "-12");
        dataMap.put("b", -12);
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, false);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testLeft() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "left(a, 3)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "北京同方软件有限公司");
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, "同方软件有限公司");
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testRight() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "right(a, 4)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "北京同方软件有限公司");
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, "有限公司");
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testLookat() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "lookat('北京', a)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "北京同方软件有限公司");
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, true);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testMatch() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "match('北京同方软件有限公司', a)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "北京同方软件有限公司");
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, true);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testAbs() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "abs(a)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "-12");
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, 12);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testCeil() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "ceil(a)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", 1.123);
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, 2);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testTrunc() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "trunc(a)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", 1.923);
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, 1);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testRound() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "round(a)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", 1.423);
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, 1);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testCurrentTime() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "current_time('yyyy年MM月dd日 hh时mm分ss秒')";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
//        dataMap.put("a", "yyyy年MM月dd日 hh时mm分ss秒");
        Object value = expression.execute(dataMap);
        System.out.println(value);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

}