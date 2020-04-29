package com.greenpineyu.fel;

import com.greenpineyu.fel.context.FelContext;
import org.junit.Test;

public class TestFunction {

    FelEngine engine = Fel.newEngine();

    @Test
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
    }

    @Test
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
    }

    @Test
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
    }

    @Test
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
    }

    @Test
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
    }

    @Test
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
    }

    @Test
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
    }

    @Test
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
    }

    @Test
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
    }

    @Test
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
    }

    @Test
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
    }

    @Test
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
    }

    @Test
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
    }

}
