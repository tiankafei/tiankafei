package com.greenpineyu.fel;

import com.greenpineyu.fel.context.FelContext;
import org.junit.Assert;
import org.junit.Test;

public class TestFunction {

    FelEngine engine = Fel.newEngine();

    @Test(expected = Exception.class)
    public void testAdd() throws Exception {
        String expression = "1+1";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1'+1";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "1+'1'";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1'+'1'";
        System.out.println(expression + "：" + engine.eval(expression));

        expression = "1.1+1.2";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1.1'+1.2";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "1.1+'1.2'";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1.1'+'1.2'";
        System.out.println(expression + "：" + engine.eval(expression));

        FelContext context = engine.getContext();
        context.set("a", "1");
        expression = "a+1";
        System.out.println(expression + "：" + engine.eval(expression, context));
        expression = "'a'+1";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "a+'1'";
        System.out.println(expression + "：" + engine.eval(expression, context));
        expression = "'a'+'1'";
        System.out.println(expression + "：" + engine.eval(expression));
        System.out.println("=====================================================");

        Assert.fail();
    }

    @Test(expected = Exception.class)
    public void testSub() throws Exception {
        String expression = "1-1";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1'-1";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "1-'1'";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1'-'1'";
        System.out.println(expression + "：" + engine.eval(expression));

        expression = "1.1-1.2";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1.1'-1.2";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "1.1-'1.2'";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1.1'-'1.2'";
        System.out.println(expression + "：" + engine.eval(expression));

        FelContext context = engine.getContext();
        context.set("a", "1");
        expression = "a-1";
        System.out.println(expression + "：" + engine.eval(expression, context));
//        expression = "'a'-1";
//        System.out.println(expression + "：" + engine.eval(expression));
        expression = "a-'1'";
        System.out.println(expression + "：" + engine.eval(expression, context));
//        expression = "'a'-'1'";
//        System.out.println(expression + "：" + engine.eval(expression));
        System.out.println("=====================================================");

        Assert.fail();
    }

    @Test(expected = Exception.class)
    public void testMul() throws Exception {
        String expression = "1*1";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1'*1";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "1*'1'";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1'*'1'";
        System.out.println(expression + "：" + engine.eval(expression));

        expression = "1.1*1.2";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1.1'*1.2";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "1.1*'1.2'";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1.1'*'1.2'";
        System.out.println(expression + "：" + engine.eval(expression));

        FelContext context = engine.getContext();
        context.set("a", "1");
        expression = "a*1";
        System.out.println(expression + "：" + engine.eval(expression, context));
//        expression = "'a'*1";
//        System.out.println(expression + "：" + engine.eval(expression));
        expression = "a*'1'";
        System.out.println(expression + "：" + engine.eval(expression, context));
//        expression = "'a'*'1'";
//        System.out.println(expression + "：" + engine.eval(expression));
        System.out.println("=====================================================");

        Assert.fail();
    }

    @Test(expected = Exception.class)
    public void testDiv() throws Exception {
        String expression = "1/1";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1'/1";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "1/'1'";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1'/'1'";
        System.out.println(expression + "：" + engine.eval(expression));

        expression = "1.1/1.2";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1.1'/1.2";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "1.1/'1.2'";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1.1'/'1.2'";
        System.out.println(expression + "：" + engine.eval(expression));

        FelContext context = engine.getContext();
        context.set("a", "1");
        expression = "a/1";
        System.out.println(expression + "：" + engine.eval(expression, context));
//        expression = "'a'/1";
//        System.out.println(expression + "：" + engine.eval(expression));
        expression = "a/'1'";
        System.out.println(expression + "：" + engine.eval(expression, context));
//        expression = "'a'/'1'";
//        System.out.println(expression + "：" + engine.eval(expression));
        System.out.println("=====================================================");

        Assert.fail();
    }

    @Test(expected = Exception.class)
    public void testMod() throws Exception {
        String expression = "1%1";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1'%1";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "1%'1'";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1'%'1'";
        System.out.println(expression + "：" + engine.eval(expression));

        expression = "1.1%1.2";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1.1'%1.2";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "1.1%'1.2'";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1.1'%'1.2'";
        System.out.println(expression + "：" + engine.eval(expression));

        FelContext context = engine.getContext();
        context.set("a", "1");
        expression = "a%1";
        System.out.println(expression + "：" + engine.eval(expression, context));
//        expression = "'a'%1";
//        System.out.println(expression + "：" + engine.eval(expression));
        expression = "a%'1'";
        System.out.println(expression + "：" + engine.eval(expression, context));
//        expression = "'a'%'1'";
//        System.out.println(expression + "：" + engine.eval(expression));
        System.out.println("=====================================================");

        Assert.fail();
    }

    @Test(expected = Exception.class)
    public void testEquals() throws Exception {
        String expression = "1-1==0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1'-1==0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "1-'1'==0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1'-'1'==0";
        System.out.println(expression + "：" + engine.eval(expression));

        expression = "1.1-1.2==0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1.1'-1.2==0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "1.1-'1.2'==0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1.1'-'1.2'==0";
        System.out.println(expression + "：" + engine.eval(expression));

        FelContext context = engine.getContext();
        context.set("a", "1");
        expression = "a-1==0";
        System.out.println(expression + "：" + engine.eval(expression, context));
//        expression = "'a'-1==0";
//        System.out.println(expression + "：" + engine.eval(expression));
        expression = "a-'1'==0";
        System.out.println(expression + "：" + engine.eval(expression, context));
//        expression = "'a'-'1'==0";
//        System.out.println(expression + "：" + engine.eval(expression));
        System.out.println("=====================================================");

        Assert.fail();
    }

    @Test(expected = Exception.class)
    public void testNoEquals() throws Exception {
        String expression = "1-1!=0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1'-1!=0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "1-'1'!=0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1'-'1'!=0";
        System.out.println(expression + "：" + engine.eval(expression));

        expression = "1.1-1.2!=0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1.1'-1.2!=0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "1.1-'1.2'!=0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1.1'-'1.2'!=0";
        System.out.println(expression + "：" + engine.eval(expression));

        FelContext context = engine.getContext();
        context.set("a", "1");
        expression = "a-1!=0";
        System.out.println(expression + "：" + engine.eval(expression, context));
//        expression = "'a'-1!=0";
//        System.out.println(expression + "：" + engine.eval(expression));
        expression = "a-'1'!=0";
        System.out.println(expression + "：" + engine.eval(expression, context));
//        expression = "'a'-'1'!=0";
//        System.out.println(expression + "：" + engine.eval(expression));
        System.out.println("=====================================================");

        Assert.fail();
    }

    @Test(expected = Exception.class)
    public void testLessThen() throws Exception {
        String expression = "1-1<0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1'-1<0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "1-'1'<0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1'-'1'<0";
        System.out.println(expression + "：" + engine.eval(expression));

        expression = "1.1-1.2<0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1.1'-1.2<0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "1.1-'1.2'<0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1.1'-'1.2'<0";
        System.out.println(expression + "：" + engine.eval(expression));

        FelContext context = engine.getContext();
        context.set("a", "1");
        expression = "a-1<0";
        System.out.println(expression + "：" + engine.eval(expression, context));
//        expression = "'a'-1<0";
//        System.out.println(expression + "：" + engine.eval(expression));
        expression = "a-'1'<0";
        System.out.println(expression + "：" + engine.eval(expression, context));
//        expression = "'a'-'1'<0";
//        System.out.println(expression + "：" + engine.eval(expression));
        System.out.println("=====================================================");

        Assert.fail();
    }

    @Test(expected = Exception.class)
    public void testLessThenEquals() throws Exception {
        String expression = "1-1<=0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1'-1<=0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "1-'1'<=0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1'-'1'<=0";
        System.out.println(expression + "：" + engine.eval(expression));

        expression = "1.1-1.2<=0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1.1'-1.2<=0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "1.1-'1.2'<=0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1.1'-'1.2'<=0";
        System.out.println(expression + "：" + engine.eval(expression));

        FelContext context = engine.getContext();
        context.set("a", "1");
        expression = "a-1<=0";
        System.out.println(expression + "：" + engine.eval(expression, context));
//        expression = "'a'-1<=0";
//        System.out.println(expression + "：" + engine.eval(expression));
        expression = "a-'1'<=0";
        System.out.println(expression + "：" + engine.eval(expression, context));
//        expression = "'a'-'1'<=0";
//        System.out.println(expression + "：" + engine.eval(expression));
        System.out.println("=====================================================");

        Assert.fail();
    }

    @Test(expected = Exception.class)
    public void testGreaterThen() throws Exception {
        String expression = "1-1>0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1'-1>0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "1-'1'>0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1'-'1'>0";
        System.out.println(expression + "：" + engine.eval(expression));

        expression = "1.1-1.2>0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1.1'-1.2>0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "1.1-'1.2'>0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1.1'-'1.2'>0";
        System.out.println(expression + "：" + engine.eval(expression));

        FelContext context = engine.getContext();
        context.set("a", "1");
        expression = "a-1>0";
        System.out.println(expression + "：" + engine.eval(expression, context));
//        expression = "'a'-1>0";
//        System.out.println(expression + "：" + engine.eval(expression));
        expression = "a-'1'>0";
        System.out.println(expression + "：" + engine.eval(expression, context));
//        expression = "'a'-'1'>0";
//        System.out.println(expression + "：" + engine.eval(expression));
        System.out.println("=====================================================");

        Assert.fail();
    }

    @Test(expected = Exception.class)
    public void testGreaterThenEquals() throws Exception {
        String expression = "1-1>=0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1'-1>=0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "1-'1'>=0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1'-'1'>=0";
        System.out.println(expression + "：" + engine.eval(expression));

        expression = "1.1-1.2>=0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1.1'-1.2>=0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "1.1-'1.2'>=0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1.1'-'1.2'>=0";
        System.out.println(expression + "：" + engine.eval(expression));

        FelContext context = engine.getContext();
        context.set("a", "1");
        expression = "a-1>=0";
        System.out.println(expression + "：" + engine.eval(expression, context));
//        expression = "'a'-1>=0";
//        System.out.println(expression + "：" + engine.eval(expression));
        expression = "a-'1'>=0";
        System.out.println(expression + "：" + engine.eval(expression, context));
//        expression = "'a'-'1'>=0";
//        System.out.println(expression + "：" + engine.eval(expression));
        System.out.println("=====================================================");

        Assert.fail();
    }

    @Test(expected = Exception.class)
    public void testAnd() throws Exception {
        String expression = "1-1>=0 && 1-1<0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1'-1>=0 && '1'-1<0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "1-'1'>=0 && 1-'1'<0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1'-'1'>=0 && '1'-'1'<0";
        System.out.println(expression + "：" + engine.eval(expression));

        expression = "1.1-1.2>=0 && 1.1-1.2<0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1.1'-1.2>=0 && '1.1'-1.2<0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "1.1-'1.2'>=0 && 1.1-'1.2'<0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1.1'-'1.2'>=0 && '1.1'-'1.2'<0";
        System.out.println(expression + "：" + engine.eval(expression));

        FelContext context = engine.getContext();
        context.set("a", "1");
        expression = "a-1>=0 && a-1<0";
        System.out.println(expression + "：" + engine.eval(expression, context));
//        expression = "'a'-1>=0 && 'a'-1<0";
//        System.out.println(expression + "：" + engine.eval(expression));
        expression = "a-'1'>=0 && a-'1'<0";
        System.out.println(expression + "：" + engine.eval(expression, context));
//        expression = "'a'-'1'>=0 && 'a'-'1'<0";
//        System.out.println(expression + "：" + engine.eval(expression));
        System.out.println("=====================================================");

        Assert.fail();
    }

    @Test(expected = Exception.class)
    public void testOr() throws Exception {
        String expression = "1-1>=0 || 1-1<0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1'-1>=0 || '1'-1<0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "1-'1'>=0 || 1-'1'<0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1'-'1'>=0 || '1'-'1'<0";
        System.out.println(expression + "：" + engine.eval(expression));

        expression = "1.1-1.2>=0 || 1.1-1.2<0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1.1'-1.2>=0 || '1.1'-1.2<0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "1.1-'1.2'>=0 || 1.1-'1.2'<0";
        System.out.println(expression + "：" + engine.eval(expression));
        expression = "'1.1'-'1.2'>=0 || '1.1'-'1.2'<0";
        System.out.println(expression + "：" + engine.eval(expression));

        FelContext context = engine.getContext();
        context.set("a", "1");
        expression = "a-1>=0 || a-1<0";
        System.out.println(expression + "：" + engine.eval(expression, context));
//        expression = "'a'-1>=0 || 'a'-1<0";
//        System.out.println(expression + "：" + engine.eval(expression));
        expression = "a-'1'>=0 || a-'1'<0";
        System.out.println(expression + "：" + engine.eval(expression, context));
//        expression = "'a'-'1'>=0 || 'a'-'1'<0";
//        System.out.println(expression + "：" + engine.eval(expression));
        System.out.println("=====================================================");

        Assert.fail();
    }

}
