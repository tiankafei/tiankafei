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

    @Test
    public void testMul() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "mul(a, b)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "-12");
        dataMap.put("b", 2);
        System.out.println(expression.execute(dataMap));
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
        System.out.println(expression.execute(dataMap));
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
        System.out.println(expression.execute(dataMap));
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
        System.out.println(expression.execute(dataMap));
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
        System.out.println(expression.execute(dataMap));
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
        System.out.println(expression.execute(dataMap));
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testEquals() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "equals(a, b)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
//        dataMap.put("a", "12");
        dataMap.put("b", 12);
        System.out.println(expression.execute(dataMap));
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
        System.out.println(expression.execute(dataMap));
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
        System.out.println(expression.execute(dataMap));
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
        System.out.println(expression.execute(dataMap));
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
        System.out.println(expression.execute(dataMap));
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
        System.out.println(expression.execute(dataMap));
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
        System.out.println(expression.execute(dataMap));
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
        System.out.println(expression.execute(dataMap));
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
        System.out.println(expression.execute(dataMap));
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
        System.out.println(expression.execute(dataMap));
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
        System.out.println(expression.execute(dataMap));
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
        System.out.println(expression.execute(dataMap));
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
        System.out.println(expression.execute(dataMap));
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
        System.out.println(expression.execute(dataMap));
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
        System.out.println(expression.execute(dataMap));
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
        System.out.println(expression.execute(dataMap));
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

}