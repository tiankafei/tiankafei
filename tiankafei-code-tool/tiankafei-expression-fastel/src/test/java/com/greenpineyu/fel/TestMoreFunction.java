package com.greenpineyu.fel;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.TestUtil;
import org.junit.Test;

public class TestMoreFunction {

    FelEngine engine = Fel.newEngine();

    @Test
    public void testAndMore() throws Exception {
        String expression = "AND(1+1==2, 1+1==1)";
        TestUtil.execute(expression, engine);
        expression = "AND(a+b==2, a+b==1)";
        FelContext context = engine.getContext();
        context.set("a", "1");
        context.set("b", "1");
        Expression expression1 = engine.compile(expression, context);
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testOrMore() throws Exception {
        String expression = "OR(1+1==2, 1+1==1)";
        TestUtil.execute(expression, engine);
        expression = "OR(a+b==2, a+b==1)";
        FelContext context = engine.getContext();
        context.set("a", 1);
        context.set("b", 1);
        Expression expression1 = engine.compile(expression, context);
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testLeft() throws Exception {
        String expression = "LEFT('weishuangshuang', 6)";
        TestUtil.execute(expression, engine);
        expression = "LEFT(a, 6)";
        FelContext context = engine.getContext();
        context.set("a", "weishuangshuang");
        Expression expression1 = engine.compile(expression, context);
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testRight() throws Exception {
        String expression = "RIGHT('weishuangshuang', 6)";
        TestUtil.execute(expression, engine);
        expression = "RIGHT(a, 6)";
        FelContext context = engine.getContext();
        context.set("a", "weishuangshuang");
        Expression expression1 = engine.compile(expression, context);
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testMid() throws Exception {
        String expression = "Mid('weishuangshuang', 3, 6)";
        TestUtil.execute(expression, engine);
        expression = "Mid(a, 3, 6)";
        FelContext context = engine.getContext();
        context.set("a", "weishuangshuang");
        Expression expression1 = engine.compile(expression, context);
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testSum() throws Exception {
        String expression = "SUM(1, 1.1, 2.2, -1)";
        TestUtil.execute(expression, engine);
        expression = "SUM(a, b, c, d)";
        FelContext context = engine.getContext();
        context.set("a", 1);
        context.set("b", 1.1);
        context.set("c", 2.2);
        context.set("d", -1);
        Expression expression1 = engine.compile(expression, context);
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testIf() throws Exception {
        String expression = "IF(1==2, 1.1+2.2, 2.2+1)";
        TestUtil.execute(expression, engine);
        expression = "IF(a==b, c+d, e+f)";
        FelContext context = engine.getContext();
        context.set("a", 1);
        context.set("b", 2);
        context.set("c", 2.2);
        context.set("d", -1);
        context.set("e", -1);
        context.set("f", -1);
        Expression expression1 = engine.compile(expression, context);
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testIfAbs() throws Exception {
        String expression = "IF(ABS(-2)==2, 1.1+2.2, 2.2+1)";
        TestUtil.execute(expression, engine);
        expression = "IF(ABS(a)==b, c+d, e+f)";
        FelContext context = engine.getContext();
        context.set("a", -2);
        context.set("b", 2);
        context.set("c", 2.2);
        context.set("d", -1);
        context.set("e", -1);
        context.set("f", -1);
        Expression expression1 = engine.compile(expression, context);
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testInList() throws Exception {
        String expression = "INLIST('2', 1,2,3,4,5,6,7)";
        TestUtil.execute(expression, engine);
        expression = "INLIST(a, 1,2,3,4,5,6,7)";
        FelContext context = engine.getContext();
        context.set("a", '1');
        Expression expression1 = engine.compile(expression, context);
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testAge() throws Exception {
        String expression = "age(1989,09)";
        TestUtil.execute(expression, engine);
        expression = "age(1989,09,1999,09)";
        TestUtil.execute(expression, engine);
        expression = "age(a,b)";
        FelContext context = engine.getContext();
        Expression expression1 = engine.compile(expression, context);
        context.set("a", "1989");
        context.set("b", "09");
        TestUtil.execute(expression1, context);
        expression = "age(a,b,c,d)";
        context = engine.getContext();
        context.set("a", "1989");
        context.set("b", "09");
        context.set("c", "1999");
        context.set("d", "09");
        expression1 = engine.compile(expression, context);
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testFind() throws Exception {
        String expression = "FIND(\"\\\\?\",\"123465\",0)";
        TestUtil.execute(expression, engine);
        expression = "FIND(\"\\\\?\",\"123465\",9)";
        TestUtil.execute(expression, engine);
        expression = "FIND(\"工商\",\"工商工商工商工商\",0)";
        TestUtil.execute(expression, engine);
        expression = "FIND(a,b,c)";
        FelContext context = engine.getContext();
        Expression expression1 = engine.compile(expression, context);
        context.set("a", "\\\\?");
        context.set("b", "1989");
        context.set("c", "0");
        TestUtil.execute(expression1, context);
        context.set("a", "\\\\?");
        context.set("b", "1989");
        context.set("c", "9");
        TestUtil.execute(expression1, context);
        context.set("a", "工商");
        context.set("b", "工商行政管理部门工商");
        context.set("c", "2");
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testLookat() throws Exception {
        String expression = "lookat(\"\\\\?\",\"123465\")";
        TestUtil.execute(expression, engine);
        expression = "lookat(\"\\\\?\",\"123465\")";
        TestUtil.execute(expression, engine);
        expression = "lookat(\"工商\",\"工\")";
        TestUtil.execute(expression, engine);
        expression = "lookat(a,b)";
        FelContext context = engine.getContext();
        Expression expression1 = engine.compile(expression, context);
        context.set("a", "\\\\?");
        context.set("b", "1989");
        TestUtil.execute(expression1, context);
        context.set("a", "\\\\?");
        context.set("b", "1989");
        TestUtil.execute(expression1, context);
        context.set("a", "工商");
        context.set("b", "工");
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testMatch() throws Exception {
        String expression = "match(\"\\\\?\",\"123465\")";
        TestUtil.execute(expression, engine);
        expression = "match(\"\\\\?\",\"123465\")";
        TestUtil.execute(expression, engine);
        expression = "match(\"工商行政管理部门工商\",\"工商行政管理部门工商\")";
        TestUtil.execute(expression, engine);
        expression = "match(a,b)";
        FelContext context = engine.getContext();
        Expression expression1 = engine.compile(expression, context);
        context.set("a", "\\\\?");
        context.set("b", "1989");
        TestUtil.execute(expression1, context);
        context.set("a", "\\\\?");
        context.set("b", "1989");
        TestUtil.execute(expression1, context);
        context.set("a", "工商行政管理部门工商");
        context.set("b", "工商行政管理部门工商");
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testVerifych() throws Exception {
        String expression = "VERIFYCH(\"工商行政管理部门工商公司aaaaa\",\"1\",\"公司\",\"0\")";
        TestUtil.execute(expression, engine);
        expression = "VERIFYCH(\"工商行政管理部门工商公司aaaaa\",\"2\",\"公司\",\"0\")";
        TestUtil.execute(expression, engine);
        expression = "VERIFYCH(\"工商行政管理部门工商公司aaaaa\",\"3\",\"公司\",\"1\")";
        TestUtil.execute(expression, engine);
        expression = "VERIFYCH(a,b,c,d)";
        FelContext context = engine.getContext();
        Expression expression1 = engine.compile(expression, context);
        context.set("a", "工商行政管理部门工商公司aaaaa");
        context.set("b", "1");
        context.set("c", "公司");
        context.set("d", "0");
        TestUtil.execute(expression1, context);
        context.set("a", "工商行政管理部门工商公司aaaaa");
        context.set("b", "2");
        context.set("c", "公司");
        context.set("d", "0");
        TestUtil.execute(expression1, context);
        context.set("a", "工商行政管理部门工商公司aaaaa");
        context.set("b", "3");
        context.set("c", "公司");
        context.set("d", "1");
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testMonth() throws Exception {
        String expression = "month(\"01\",\"201808MM\",0)";
        TestUtil.execute(expression, engine);
        expression = "month(\"02\",\"201808MM\",0)";
        TestUtil.execute(expression, engine);
        expression = "month(\"12\",\"201808MM\",0)";
        TestUtil.execute(expression, engine);
        expression = "month(\"01\",\"201808MM\",1)";
        TestUtil.execute(expression, engine);
        expression = "month(\"02\",\"201808MM\",1)";
        TestUtil.execute(expression, engine);
        expression = "month(\"12\",\"201808MM\",1)";
        TestUtil.execute(expression, engine);
        expression = "month(\"01\",\"201808MM\",2)";
        TestUtil.execute(expression, engine);
        expression = "month(\"02\",\"201808MM\",2)";
        TestUtil.execute(expression, engine);
        expression = "month(\"12\",\"201808MM\",2)";
        TestUtil.execute(expression, engine);
        expression = "month(a,b,c)";
        FelContext context = engine.getContext();
        Expression expression1 = engine.compile(expression, context);
        context.set("a", "01");
        context.set("b", "201808MM");
        context.set("c", "0");
        TestUtil.execute(expression1, context);
        context.set("a", "02");
        context.set("b", "201808MM");
        context.set("c", "0");
        TestUtil.execute(expression1, context);
        context.set("a", "12");
        context.set("b", "201808MM");
        context.set("c", "0");
        TestUtil.execute(expression1, context);
        context.set("a", "01");
        context.set("b", "201808MM");
        context.set("c", "1");
        TestUtil.execute(expression1, context);
        context.set("a", "02");
        context.set("b", "201808MM");
        context.set("c", "1");
        TestUtil.execute(expression1, context);
        context.set("a", "12");
        context.set("b", "201808MM");
        context.set("c", "1");
        TestUtil.execute(expression1, context);
        context.set("a", "01");
        context.set("b", "201808MM");
        context.set("c", "2");
        TestUtil.execute(expression1, context);
        context.set("a", "02");
        context.set("b", "201808MM");
        context.set("c", "2");
        TestUtil.execute(expression1, context);
        context.set("a", "12");
        context.set("b", "201808MM");
        context.set("c", "2");
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testYear() throws Exception {
        String expression = "year(\"1799\",\"201808MM\",0)";
        TestUtil.execute(expression, engine);
        expression = "year(\"1801\",\"201808MM\",0)";
        TestUtil.execute(expression, engine);
        expression = "year(\"2020\",\"201808MM\",0)";
        TestUtil.execute(expression, engine);
        expression = "year(\"1799\",\"201808MM\",1)";
        TestUtil.execute(expression, engine);
        expression = "year(\"1801\",\"201808MM\",1)";
        TestUtil.execute(expression, engine);
        expression = "year(\"2020\",\"201808MM\",1)";
        TestUtil.execute(expression, engine);
        expression = "year(\"1799\",\"201808MM\",2)";
        TestUtil.execute(expression, engine);
        expression = "year(\"1801\",\"201808MM\",2)";
        TestUtil.execute(expression, engine);
        expression = "year(\"2020\",\"201808MM\",2)";
        TestUtil.execute(expression, engine);
        expression = "year(a,b,c)";
        FelContext context = engine.getContext();
        Expression expression1 = engine.compile(expression, context);
        context.set("a", "1799");
        context.set("b", "201808MM");
        context.set("c", "0");
        TestUtil.execute(expression1, context);
        context.set("a", "1801");
        context.set("b", "201808MM");
        context.set("c", "0");
        TestUtil.execute(expression1, context);
        context.set("a", "2020");
        context.set("b", "201808MM");
        context.set("c", "0");
        TestUtil.execute(expression1, context);
        context.set("a", "1799");
        context.set("b", "201808MM");
        context.set("c", "1");
        TestUtil.execute(expression1, context);
        context.set("a", "1801");
        context.set("b", "201808MM");
        context.set("c", "1");
        TestUtil.execute(expression1, context);
        context.set("a", "2020");
        context.set("b", "201808MM");
        context.set("c", "1");
        TestUtil.execute(expression1, context);
        context.set("a", "1799");
        context.set("b", "201808MM");
        context.set("c", "2");
        TestUtil.execute(expression1, context);
        context.set("a", "1801");
        context.set("b", "201808MM");
        context.set("c", "2");
        TestUtil.execute(expression1, context);
        context.set("a", "2020");
        context.set("b", "201808MM");
        context.set("c", "2");
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testTimeCompare() throws Exception {
        String expression = "timecompare(04,50,01,20)";
        TestUtil.execute(expression, engine);
        expression = "timecompare(01,50,19,20)";
        TestUtil.execute(expression, engine);
        FelContext context = engine.getContext();
        expression = "timecompare(a,b,c,d)";
        Expression expression1 = engine.compile(expression, context);
        context.set("a", "04");
        context.set("b", "50");
        context.set("c", "01");
        context.set("d", "20");
        TestUtil.execute(expression1, context);
        context.set("a", "01");
        context.set("b", "50");
        context.set("c", "19");
        context.set("d", "20");
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testInRange() throws Exception {
        String expression = "inrange(01,00,02)";
        TestUtil.execute(expression, engine);
        expression = "inrange(01,02,03)";
        TestUtil.execute(expression, engine);
        expression = "inrange(\"a\",\"ab\",\"bc\")";
        TestUtil.execute(expression, engine);
        FelContext context = engine.getContext();
        expression = "inrange(a,b,c)";
        context.set("a", "01");
        context.set("b", "00");
        context.set("c", "02");
        Expression expression1 = engine.compile(expression, context);
        TestUtil.execute(expression1, context);
        context = engine.getContext();
        context.set("a", "01");
        context.set("b", "02");
        context.set("c", "03");
        expression1 = engine.compile(expression, context);
        TestUtil.execute(expression1, context);
        context.set("a", "a");
        context.set("b", "ab");
        context.set("c", "bc");
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testMax() throws Exception {
        String expression = "max(9,1,2,3,4,5,6,7)";
        TestUtil.execute(expression, engine);
        expression = "max(9,1,2,3,4,5,6,7)";
        TestUtil.execute(expression, engine);
        FelContext context = engine.getContext();
        expression = "max(a,1,2,3,4,5,6,7)";
        context.set("a", 8);
        Expression expression1 = engine.compile(expression, context);
        TestUtil.execute(expression1, context);
        context.set("a", 1);
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testMin() throws Exception {
        String expression = "min(9,1,2,3,4,5,6,7)";
        TestUtil.execute(expression, engine);
        expression = "min(9,1,2,3,4,5,6,7)";
        TestUtil.execute(expression, engine);
        FelContext context = engine.getContext();
        expression = "min(a,1,2,3,4,5,6,7)";
        context.set("a", 8);
        Expression expression1 = engine.compile(expression, context);
        TestUtil.execute(expression1, context);
        context.set("a", 1);
        TestUtil.execute(expression1, context);
    }

    @Test
    public void testReplaceall() throws Exception {
        String expression = "replaceall('12346579', 1, 0)";
        TestUtil.execute(expression, engine);
        expression = "replaceall('12346579', 1, 999)";
        TestUtil.execute(expression, engine);
        FelContext context = engine.getContext();
        expression = "replaceall(a, b, c)";
        Expression expression1 = engine.compile(expression, context);
        context.set("a", "12346579");
        context.set("b", 1);
        context.set("c", 0);
        TestUtil.execute(expression1, context);
        context.set("a", "12346579");
        context.set("b", 1);
        context.set("c", 999);
        TestUtil.execute(expression1, context);
    }

}
