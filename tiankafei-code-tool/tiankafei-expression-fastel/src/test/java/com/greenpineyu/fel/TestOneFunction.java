package com.greenpineyu.fel;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.TestUtil;
import org.junit.Test;

public class TestOneFunction {

    FelEngine engine = Fel.newEngine();

    @Test
    public void testAbs() throws Exception {
        String expression = "ABS(-1.1)";
        TestUtil.execute(expression, engine);
        expression = "ABS(a)";
        FelContext context = engine.getContext();
        context.set("a", "-1.1");
        Expression expression1 = engine.compile(expression, context);
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testNotNull() throws Exception {
        String expression = "NOTNULL(1)";
        TestUtil.execute(expression, engine);
        expression = "NOTNULL(null)";
        TestUtil.execute(expression, engine);
        expression = "NOTNULL(a)";
        FelContext context = engine.getContext();
        Expression expression1 = engine.compile(expression, context);
        TestUtil.execute(expression1, context);
        context.set("a", 1);
        expression1 = engine.compile(expression, context);
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testIsNull() throws Exception {
        String expression = "ISNULL(1)";
        TestUtil.execute(expression, engine);
        expression = "ISNULL(null)";
        TestUtil.execute(expression, engine);
        expression = "ISNULL(a)";
        FelContext context = engine.getContext();
        Expression expression1 = engine.compile(expression, context);
        TestUtil.execute(expression1, context);
        context.set("a", 1);
        expression1 = engine.compile(expression, context);
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testIsNumber() throws Exception {
        String expression = "ISNUMBER(1)";
        TestUtil.execute(expression, engine);
        expression = "ISNUMBER(1.0)";
        TestUtil.execute(expression, engine);
        expression = "ISNUMBER(-1.0)";
        TestUtil.execute(expression, engine);
        expression = "ISNUMBER('a')";
        TestUtil.execute(expression, engine);
        expression = "ISNUMBER(a)";
        FelContext context = engine.getContext();
        context.set("a", "a");
        Expression expression1 = engine.compile(expression, context);
        TestUtil.execute(expression1, context);
        context.set("a", 1);
        expression1 = engine.compile(expression, context);
        TestUtil.execute(expression1, context);
        context.set("a", 1.0);
        expression1 = engine.compile(expression, context);
        TestUtil.execute(expression1, context);
        context.set("a", "-1.0");
        expression1 = engine.compile(expression, context);
        TestUtil.execute(expression1, context);
        context.set("a", "-1.0a");
        expression1 = engine.compile(expression, context);
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testIsNum() throws Exception {
        String expression = "ISNUM(1)";
        TestUtil.execute(expression, engine);
        expression = "ISNUM(1.0)";
        TestUtil.execute(expression, engine);
        expression = "ISNUM(-1.0)";
        TestUtil.execute(expression, engine);
        expression = "ISNUM('a')";
        TestUtil.execute(expression, engine);
        expression = "ISNUM(a)";
        FelContext context = engine.getContext();
        context.set("a", "a");
        Expression expression1 = engine.compile(expression, context);
        TestUtil.execute(expression1, context);
        context.set("a", 1);
        expression1 = engine.compile(expression, context);
        TestUtil.execute(expression1, context);
        context.set("a", 1.0);
        expression1 = engine.compile(expression, context);
        TestUtil.execute(expression1, context);
        context.set("a", "-1.0");
        expression1 = engine.compile(expression, context);
        TestUtil.execute(expression1, context);
        context.set("a", "-1.0a");
        expression1 = engine.compile(expression, context);
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testCeil() throws Exception {
        String expression = "ceil(1.1)";
        TestUtil.execute(expression, engine);
        expression = "ceil(-1.1)";
        TestUtil.execute(expression, engine);
        expression = "ceil(a)";
        FelContext context = engine.getContext();
        context.set("a", 1.1);
        Expression expression1 = engine.compile(expression, context);
        TestUtil.execute(expression1, context);
        context.set("a", -1.1);
        expression1 = engine.compile(expression, context);
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testCurrentTime() throws Exception {
        String expression = "currenttime(\"yyyy-MM-dd HH:mm:ss\")";
        TestUtil.execute(expression, engine);
        expression = "currenttime(\"yyyy-MM-dd HH:mm\")";
        TestUtil.execute(expression, engine);
        expression = "currenttime(\"yyyy-MM-dd HH\")";
        TestUtil.execute(expression, engine);
        expression = "currenttime(\"yyyy-MM-dd\")";
        TestUtil.execute(expression, engine);
        expression = "currenttime(\"yyyy-MM\")";
        TestUtil.execute(expression, engine);
        expression = "currenttime(\"yyyy\")";
        TestUtil.execute(expression, engine);
        expression = "currenttime(a)";
        FelContext context = engine.getContext();
        context.set("a", "yyyy-MM-dd HH:mm:ss");
        Expression expression1 = engine.compile(expression, context);
        TestUtil.execute(expression1, context);
        context.set("a", "yyyy-MM-dd HH:mm");
        TestUtil.execute(expression1, context);
        context.set("a", "yyyy-MM-dd HH");
        TestUtil.execute(expression1, context);
        context.set("a", "yyyy-MM-dd");
        TestUtil.execute(expression1, context);
        context.set("a", "yyyy-MM");
        TestUtil.execute(expression1, context);
        context.set("a", "yyyy");
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testNot() throws Exception {
        String expression = "not(1.1==1.2)";
        TestUtil.execute(expression, engine);
        expression = "not(1.1==1.1)";
        TestUtil.execute(expression, engine);
        expression = "not(a==b)";
        FelContext context = engine.getContext();
        context.set("a", 1.1);
        context.set("b", 1.2);
        Expression expression1 = engine.compile(expression, context);
        TestUtil.execute(expression1, context);
        context.set("a", 1.1);
        context.set("b", 1.1);
        expression1 = engine.compile(expression, context);
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testNotOper() throws Exception {
        String expression = "!(1.1==1.2)";
        TestUtil.execute(expression, engine);
        expression = "!(1.1==1.1)";
        TestUtil.execute(expression, engine);
        expression = "!(a==b)";
        FelContext context = engine.getContext();
        context.set("a", 1.1);
        context.set("b", 1.2);
        Expression expression1 = engine.compile(expression, context);
        TestUtil.execute(expression1, context);
        context.set("a", 1.1);
        context.set("b", 1.1);
        expression1 = engine.compile(expression, context);
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testIsch() throws Exception {
        String expression = "isch('sdfasfd')";
        TestUtil.execute(expression, engine);
        expression = "isch('晚上')";
        TestUtil.execute(expression, engine);
        expression = "isch('晚上sfdas')";
        TestUtil.execute(expression, engine);
        FelContext context = engine.getContext();
        expression = "isch(a)";
        Expression expression1 = engine.compile(expression, context);
        context.set("a", "sfdasfd");
        TestUtil.execute(expression1, context);
        context.set("a", "收费单身");
        TestUtil.execute(expression1, context);
        context.set("a", "暗示法地方撒sfdasf");
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testIsen() throws Exception {
        String expression = "isen('sdfasfd')";
        TestUtil.execute(expression, engine);
        expression = "isen('晚上')";
        TestUtil.execute(expression, engine);
        expression = "isen('晚上sfdas')";
        TestUtil.execute(expression, engine);
        FelContext context = engine.getContext();
        expression = "isen(a)";
        Expression expression1 = engine.compile(expression, context);
        context.set("a", "sfdasfd");
        TestUtil.execute(expression1, context);
        context.set("a", "收费单身");
        TestUtil.execute(expression1, context);
        context.set("a", "暗示法地方撒sfdasf");
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testIslower() throws Exception {
        String expression = "islower('sdfasfd')";
        TestUtil.execute(expression, engine);
        expression = "islower('晚上')";
        TestUtil.execute(expression, engine);
        expression = "islower('晚上sfdas')";
        TestUtil.execute(expression, engine);
        FelContext context = engine.getContext();
        expression = "islower(a)";
        Expression expression1 = engine.compile(expression, context);
        context.set("a", "sfdasfd");
        TestUtil.execute(expression1, context);
        context.set("a", "收费单身");
        TestUtil.execute(expression1, context);
        context.set("a", "暗示法地方撒sfdasf");
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testIsupper() throws Exception {
        String expression = "isupper('SDFASFD')";
        TestUtil.execute(expression, engine);
        expression = "isupper('晚上')";
        TestUtil.execute(expression, engine);
        expression = "isupper('晚上SFDAS')";
        TestUtil.execute(expression, engine);
        FelContext context = engine.getContext();
        expression = "isupper(a)";
        Expression expression1 = engine.compile(expression, context);
        context.set("a", "SFDASFD");
        TestUtil.execute(expression1, context);
        context.set("a", "收费单身");
        TestUtil.execute(expression1, context);
        context.set("a", "暗示法地方撒SFDASF");
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testLen() throws Exception {
        String expression = "len('SDFASFD')";
        TestUtil.execute(expression, engine);
        expression = "len('晚上')";
        TestUtil.execute(expression, engine);
        expression = "len('晚上SFDAS')";
        TestUtil.execute(expression, engine);
        FelContext context = engine.getContext();
        expression = "len(a)";
        Expression expression1 = engine.compile(expression, context);
        context.set("a", "SFDASFD");
        TestUtil.execute(expression1, context);
        context.set("a", "收费单身");
        TestUtil.execute(expression1, context);
        context.set("a", "暗示法地方撒SFDASF");
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testLength() throws Exception {
        String expression = "length('SDFASFD')";
        TestUtil.execute(expression, engine);
        expression = "length('晚上')";
        TestUtil.execute(expression, engine);
        expression = "length('晚上SFDAS')";
        TestUtil.execute(expression, engine);
        FelContext context = engine.getContext();
        expression = "length(a)";
        Expression expression1 = engine.compile(expression, context);
        context.set("a", "SFDASFD");
        TestUtil.execute(expression1, context);
        context.set("a", "收费单身");
        TestUtil.execute(expression1, context);
        context.set("a", "暗示法地方撒SFDASF");
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testRound() throws Exception {
        String expression = "round('1.5')";
        TestUtil.execute(expression, engine);
        expression = "round('-1.5')";
        TestUtil.execute(expression, engine);
        expression = "round('asd')";
        TestUtil.execute(expression, engine);
        FelContext context = engine.getContext();
        expression = "round(a)";
        Expression expression1 = engine.compile(expression, context);
        context.set("a", "1.5");
        TestUtil.execute(expression1, context);
        context.set("a", "-1.5");
        TestUtil.execute(expression1, context);
        context.set("a", "a");
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testTrim() throws Exception {
        String expression = "trim('   SAFD   ')";
        TestUtil.execute(expression, engine);
        expression = "trim('   -1.1   ')";
        TestUtil.execute(expression, engine);
        expression = "trim('  ASD')";
        TestUtil.execute(expression, engine);
        FelContext context = engine.getContext();
        expression = "trim(a)";
        Expression expression1 = engine.compile(expression, context);
        context.set("a", "   1.1");
        TestUtil.execute(expression1, context);
        context.set("a", "-1.1   ");
        TestUtil.execute(expression1, context);
        context.set("a", "     A      ");
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testLower() throws Exception {
        String expression = "lower('   SAFD   ')";
        TestUtil.execute(expression, engine);
        expression = "lower('   -1.1   ')";
        TestUtil.execute(expression, engine);
        expression = "lower('  ASD')";
        TestUtil.execute(expression, engine);
        FelContext context = engine.getContext();
        expression = "lower(a)";
        Expression expression1 = engine.compile(expression, context);
        context.set("a", "   1.1");
        TestUtil.execute(expression1, context);
        context.set("a", "-1.1   ");
        TestUtil.execute(expression1, context);
        context.set("a", "     A      ");
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testUpper() throws Exception {
        String expression = "upper('   safd   ')";
        TestUtil.execute(expression, engine);
        expression = "upper('   -1.1   ')";
        TestUtil.execute(expression, engine);
        expression = "upper('  asd')";
        TestUtil.execute(expression, engine);
        FelContext context = engine.getContext();
        expression = "upper(a)";
        Expression expression1 = engine.compile(expression, context);
        context.set("a", "   1.1");
        TestUtil.execute(expression1, context);
        context.set("a", "-1.1   ");
        TestUtil.execute(expression1, context);
        context.set("a", "     a      ");
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testTrunc() throws Exception {
        String expression = "trunc('1.5')";
        TestUtil.execute(expression, engine);
        expression = "trunc('-1.5')";
        TestUtil.execute(expression, engine);
        expression = "trunc('asd')";
        TestUtil.execute(expression, engine);
        FelContext context = engine.getContext();
        expression = "trunc(a)";
        Expression expression1 = engine.compile(expression, context);
        context.set("a", "1.5");
        TestUtil.execute(expression1, context);
        context.set("a", "-1.5");
        TestUtil.execute(expression1, context);
        context.set("a", "a");
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testVerifycode() throws Exception {
        String expression = "verifycode('134766570')";
        TestUtil.execute(expression, engine);
        expression = "verifycode('-1.5')";
        TestUtil.execute(expression, engine);
        expression = "verifycode('asd')";
        TestUtil.execute(expression, engine);
        FelContext context = engine.getContext();
        expression = "verifycode(a)";
        Expression expression1 = engine.compile(expression, context);
        context.set("a", "134766570");
        TestUtil.execute(expression1, context);
        context.set("a", "-1.5");
        TestUtil.execute(expression1, context);
        context.set("a", "a");
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testVerifyIdCard() throws Exception {
        String expression = "verifyidcard('134766570')";
        TestUtil.execute(expression, engine);
        expression = "verifyidcard('-1.5')";
        TestUtil.execute(expression, engine);
        expression = "verifyidcard('asd')";
        TestUtil.execute(expression, engine);
        FelContext context = engine.getContext();
        expression = "verifyidcard(a)";
        Expression expression1 = engine.compile(expression, context);
        context.set("a", "134766570");
        TestUtil.execute(expression1, context);
        context.set("a", "-1.5");
        TestUtil.execute(expression1, context);
        context.set("a", "a");
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testVerifyCreditCode() throws Exception {
        String expression = "verifycreditcode('91110000100026793Y')";
        TestUtil.execute(expression, engine);
        expression = "verifycreditcode('-1.5')";
        TestUtil.execute(expression, engine);
        expression = "verifycreditcode('asd')";
        TestUtil.execute(expression, engine);
        FelContext context = engine.getContext();
        expression = "verifycreditcode(a)";
        Expression expression1 = engine.compile(expression, context);
        context.set("a", "91110000100026793Y");
        TestUtil.execute(expression1, context);
        context.set("a", "-1.5");
        TestUtil.execute(expression1, context);
        context.set("a", "a");
        TestUtil.execute(expression1, context);
    }

}
