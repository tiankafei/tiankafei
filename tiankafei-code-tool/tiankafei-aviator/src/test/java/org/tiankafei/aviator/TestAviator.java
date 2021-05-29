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

    @Test
    public void testIsch() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "is_ch(a)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "你好");
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, true);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testIsen() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "is_en(a)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "abcdefasdf");
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, true);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testIslower() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "is_lower(a)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "abcdefasdf");
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, true);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testIsupper() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "is_upper(a)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "ABCDEFASDF");
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, true);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testIsnull() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "is_null(a)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, true);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testNotnull() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "not_null(a)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, false);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testIsNum() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "is_num(a)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "-123456.123");
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, true);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testIsNumber() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "is_number(a)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "-123456.123");
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, true);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testLen() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "len(a)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "-123456.123");
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, 11);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testLength() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "length(a)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "-123456.123");
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, 11);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testLower() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "lower(a)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "ABCDEFASDF");
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, "abcdefasdf");
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testUpper() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "upper(a)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "abcdefasdf");
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, "ABCDEFASDF");
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testNot() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "not(a)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", true);
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, false);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testNotOp() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "!a";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", true);
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, false);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testTrim() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "trim(a)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "           123          ");
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, "123");
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testMaxIndex() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "max_index(a, b, c, d, e, f, g)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", 1);
        dataMap.put("b", 3);
        dataMap.put("c", 5);
        dataMap.put("d", 7);
        dataMap.put("e", 9);
        dataMap.put("f", 0);
        dataMap.put("g", -10);
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, 4);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testMaxValue() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "max_value(a, b, c, d, e, f, g)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", 1);
        dataMap.put("b", 3);
        dataMap.put("c", 5);
        dataMap.put("d", 7);
        dataMap.put("e", 9);
        dataMap.put("f", 0);
        dataMap.put("g", -10);
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, 9);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testMinIndex() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "min_index(a, b, c, d, e, f, g)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", 1);
        dataMap.put("b", 3);
        dataMap.put("c", 5);
        dataMap.put("d", 7);
        dataMap.put("e", 9);
        dataMap.put("f", 0);
        dataMap.put("g", -10);
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, 6);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testMinValue() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "min_value(a, b, c, d, e, f, g)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", 1);
        dataMap.put("b", 3);
        dataMap.put("c", 5);
        dataMap.put("d", 7);
        dataMap.put("e", 9);
        dataMap.put("f", 0);
        dataMap.put("g", -10);
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, -10);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testMin() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "min(a, b, c, d, e, f, g)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", 1);
        dataMap.put("b", 3);
        dataMap.put("c", 5);
        dataMap.put("d", 7);
        dataMap.put("e", 9);
        dataMap.put("f", 0);
        dataMap.put("g", -10);
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, -10);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testMax() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "max(a, b, c, d, e, f, g)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", 1);
        dataMap.put("b", 3);
        dataMap.put("c", 5);
        dataMap.put("d", 7);
        dataMap.put("e", 9);
        dataMap.put("f", 0);
        dataMap.put("g", -10);
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, 9);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testIf() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "IF(a > b, c, d > 5)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", 1);
        dataMap.put("b", 3);
        dataMap.put("c", 5);
        dataMap.put("d", 7);
        Object value = expression.execute(dataMap);
        Assert.assertEquals(value, true);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testInRange() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "in_range(a, b, c)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", 4);
        dataMap.put("b", "3");
        dataMap.put("c", "5");
        Object value = expression.execute(dataMap);
        System.out.println(value);
        Assert.assertEquals(value, true);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testReplaceall() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "replace_all(a, b, c)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "1234567891");
        dataMap.put("b", "1");
        dataMap.put("c", "0");
        Object value = expression.execute(dataMap);
        System.out.println(value);
        Assert.assertEquals(value, "0234567890");
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testMid() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "mid(a, b, c)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", "1234567891");
        dataMap.put("b", 2);
        dataMap.put("c", 10);
        Object value = expression.execute(dataMap);
        System.out.println(value);
        Assert.assertEquals(value, "234567891");
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testAge() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "age(a, b)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", 1989);
        dataMap.put("b", 9);
        Object value = expression.execute(dataMap);
        System.out.println(value);
        Assert.assertEquals(value, 31);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

    @Test
    public void testAge1() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        String exp = "age(a, b, c, d)";
        Expression expression = AviatorEvaluator.compile(exp);

        Map<String, Object> dataMap = Maps.newHashMap();
        dataMap.put("a", 1989);
        dataMap.put("b", 9);
        dataMap.put("c", 2000);
        dataMap.put("d", 9);
        Object value = expression.execute(dataMap);
        System.out.println(value);
        Assert.assertEquals(value, 11);
        System.out.println("执行需要时间：" + stopwatch.elapsed(TimeUnit.MILLISECONDS) + "ms");
    }

}