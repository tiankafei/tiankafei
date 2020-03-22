package com.greenpineyu.fel;

import com.greenpineyu.fel.context.FelContext;
import org.junit.Test;

public class TestCompileFunction {

    FelEngine engine = Fel.newEngine();

    @Test
    public void testAdd() throws Exception {
        String expression = "1+1";
        Expression exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1'+1";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "1+'1'";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1'+'1'";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));

        expression = "1.1+1.2";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1.1'+1.2";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "1.1+'1.2'";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1.1'+'1.2'";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));

        FelContext context = engine.getContext();
        context.set("a", "1");
        expression = "a+1";
        exp = engine.compile(expression, context);
        System.out.println(expression + "：" + exp.eval(context));
        expression = "'a'+1";
        exp = engine.compile(expression, context);
        System.out.println(expression + "：" + exp.eval(context));
        expression = "a+'1'";
        exp = engine.compile(expression, context);
        System.out.println(expression + "：" + exp.eval(context));
        expression = "'a'+'1'";
        exp = engine.compile(expression, context);
        System.out.println(expression + "：" + exp.eval(context));
        System.out.println("=====================================================");
    }

    @Test
    public void testSub() throws Exception {
        String expression = "1-1";
        Expression exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1'-1";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "1-'1'";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1'-'1'";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));

        expression = "1.1-1.2";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1.1'-1.2";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "1.1-'1.2'";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1.1'-'1.2'";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));

        FelContext context = engine.getContext();
        context.set("a", "1");
        expression = "a-1";
        exp = engine.compile(expression, context);
        System.out.println(expression + "：" + exp.eval(context));
//        expression = "'a'-1";
//        System.out.println(expression + "：" + engine.eval(expression));
        expression = "a-'1'";
        exp = engine.compile(expression, context);
        System.out.println(expression + "：" + exp.eval(context));
//        expression = "'a'-'1'";
//        System.out.println(expression + "：" + engine.eval(expression));
        System.out.println("=====================================================");
    }

    @Test
    public void testMul() throws Exception {
        String expression = "1*1";
        Expression exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1'*1";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "1*'1'";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1'*'1'";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));

        expression = "1.1*1.2";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1.1'*1.2";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "1.1*'1.2'";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1.1'*'1.2'";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));

        FelContext context = engine.getContext();
        context.set("a", "1");
        expression = "a*1";
        exp = engine.compile(expression, context);
        System.out.println(expression + "：" + exp.eval(context));
//        expression = "'a'*1";
//        System.out.println(expression + "：" + engine.eval(expression));
        expression = "a*'1'";
        exp = engine.compile(expression, context);
        System.out.println(expression + "：" + exp.eval(context));
//        expression = "'a'*'1'";
//        System.out.println(expression + "：" + engine.eval(expression));
        System.out.println("=====================================================");
    }

    @Test
    public void testDiv() throws Exception {
        String expression = "1/1";
        Expression exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1'/1";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "1/'1'";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1'/'1'";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));

        expression = "1.1/1.2";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1.1'/1.2";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "1.1/'1.2'";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1.1'/'1.2'";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));

        FelContext context = engine.getContext();
        context.set("a", "1");
        expression = "a/1";
        exp = engine.compile(expression, context);
        System.out.println(expression + "：" + exp.eval(context));
//        expression = "'a'/1";
//        System.out.println(expression + "：" + engine.eval(expression));
        expression = "a/'1'";
        exp = engine.compile(expression, context);
        System.out.println(expression + "：" + exp.eval(context));
//        expression = "'a'/'1'";
//        System.out.println(expression + "：" + engine.eval(expression));
        System.out.println("=====================================================");
    }

    @Test
    public void testMod() throws Exception {
        String expression = "1%1";
        Expression exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1'%1";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "1%'1'";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1'%'1'";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));

        expression = "1.1%1.2";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1.1'%1.2";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "1.1%'1.2'";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1.1'%'1.2'";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));

        FelContext context = engine.getContext();
        context.set("a", "1");
        expression = "a%1";
        exp = engine.compile(expression, context);
        System.out.println(expression + "：" + exp.eval(context));
//        expression = "'a'%1";
//        System.out.println(expression + "：" + engine.eval(expression));
        expression = "a%'1'";
        exp = engine.compile(expression, context);
        System.out.println(expression + "：" + exp.eval(context));
//        expression = "'a'%'1'";
//        System.out.println(expression + "：" + engine.eval(expression));
        System.out.println("=====================================================");
    }

    @Test
    public void testEquals() throws Exception {
        String expression = "1-1==0";
        Expression exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1'-1==0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "1-'1'==0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1'-'1'==0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));

        expression = "1.1-1.2==0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1.1'-1.2==0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "1.1-'1.2'==0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1.1'-'1.2'==0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));

        FelContext context = engine.getContext();
        context.set("a", "1");
        expression = "a-1==0";
        exp = engine.compile(expression, context);
        System.out.println(expression + "：" + exp.eval(context));
//        expression = "'a'-1==0";
//        System.out.println(expression + "：" + engine.eval(expression));
        expression = "a-'1'==0";
        exp = engine.compile(expression, context);
        System.out.println(expression + "：" + exp.eval(context));
//        expression = "'a'-'1'==0";
//        System.out.println(expression + "：" + engine.eval(expression));
        System.out.println("=====================================================");
    }

    @Test
    public void testNoEquals() throws Exception {
        String expression = "1-1!=0";
        Expression exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1'-1!=0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "1-'1'!=0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1'-'1'!=0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));

        expression = "1.1-1.2!=0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1.1'-1.2!=0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "1.1-'1.2'!=0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1.1'-'1.2'!=0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));

        FelContext context = engine.getContext();
        context.set("a", "1");
        expression = "a-1!=0";
        exp = engine.compile(expression, context);
        System.out.println(expression + "：" + exp.eval(context));
//        expression = "'a'-1!=0";
//        System.out.println(expression + "：" + engine.eval(expression));
        expression = "a-'1'!=0";
        exp = engine.compile(expression, context);
        System.out.println(expression + "：" + exp.eval(context));
//        expression = "'a'-'1'!=0";
//        System.out.println(expression + "：" + engine.eval(expression));
        System.out.println("=====================================================");
    }

    @Test
    public void testLessThen() throws Exception {
        String expression = "1-1<0";
        Expression exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1'-1<0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "1-'1'<0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1'-'1'<0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));

        expression = "1.1-1.2<0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1.1'-1.2<0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "1.1-'1.2'<0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1.1'-'1.2'<0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));

        FelContext context = engine.getContext();
        context.set("a", "1");
        expression = "a-1<0";
        exp = engine.compile(expression, context);
        System.out.println(expression + "：" + exp.eval(context));
//        expression = "'a'-1<0";
//        System.out.println(expression + "：" + engine.eval(expression));
        expression = "a-'1'<0";
        exp = engine.compile(expression, context);
        System.out.println(expression + "：" + exp.eval(context));
//        expression = "'a'-'1'<0";
//        System.out.println(expression + "：" + engine.eval(expression));
        System.out.println("=====================================================");
    }

    @Test
    public void testLessThenEquals() throws Exception {
        String expression = "1-1<=0";
        Expression exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1'-1<=0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "1-'1'<=0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1'-'1'<=0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));

        expression = "1.1-1.2<=0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1.1'-1.2<=0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "1.1-'1.2'<=0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1.1'-'1.2'<=0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));

        FelContext context = engine.getContext();
        context.set("a", "1");
        expression = "a-1<=0";
        exp = engine.compile(expression, context);
        System.out.println(expression + "：" + exp.eval(context));
//        expression = "'a'-1<=0";
//        System.out.println(expression + "：" + engine.eval(expression));
        expression = "a-'1'<=0";
        exp = engine.compile(expression, context);
        System.out.println(expression + "：" + exp.eval(context));
//        expression = "'a'-'1'<=0";
//        System.out.println(expression + "：" + engine.eval(expression));
        System.out.println("=====================================================");
    }

    @Test
    public void testGreaterThen() throws Exception {
        String expression = "1-1>0";
        Expression exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1'-1>0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "1-'1'>0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1'-'1'>0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));

        expression = "1.1-1.2>0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1.1'-1.2>0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "1.1-'1.2'>0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1.1'-'1.2'>0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));

        FelContext context = engine.getContext();
        context.set("a", "1");
        expression = "a-1>0";
        exp = engine.compile(expression, context);
        System.out.println(expression + "：" + exp.eval(context));
//        expression = "'a'-1>0";
//        System.out.println(expression + "：" + engine.eval(expression));
        expression = "a-'1'>0";
        exp = engine.compile(expression, context);
        System.out.println(expression + "：" + exp.eval(context));
//        expression = "'a'-'1'>0";
//        System.out.println(expression + "：" + engine.eval(expression));
        System.out.println("=====================================================");
    }

    @Test
    public void testGreaterThenEquals() throws Exception {
        String expression = "1-1>=0";
        Expression exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1'-1>=0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "1-'1'>=0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1'-'1'>=0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));

        expression = "1.1-1.2>=0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1.1'-1.2>=0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "1.1-'1.2'>=0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1.1'-'1.2'>=0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));

        FelContext context = engine.getContext();
        context.set("a", "1");
        expression = "a-1>=0";
        exp = engine.compile(expression, context);
        System.out.println(expression + "：" + exp.eval(context));
//        expression = "'a'-1>=0";
//        System.out.println(expression + "：" + engine.eval(expression));
        expression = "a-'1'>=0";
        exp = engine.compile(expression, context);
        System.out.println(expression + "：" + exp.eval(context));
//        expression = "'a'-'1'>=0";
//        System.out.println(expression + "：" + engine.eval(expression));
        System.out.println("=====================================================");
    }

    @Test
    public void testAnd() throws Exception {
        String expression = "1-1>=0 && 1-1<0";
        Expression exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1'-1>=0 && '1'-1<0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "1-'1'>=0 && 1-'1'<0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1'-'1'>=0 && '1'-'1'<0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));

        expression = "1.1-1.2>=0 && 1.1-1.2<0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1.1'-1.2>=0 && '1.1'-1.2<0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "1.1-'1.2'>=0 && 1.1-'1.2'<0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1.1'-'1.2'>=0 && '1.1'-'1.2'<0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));

        FelContext context = engine.getContext();
        context.set("a", "1");
        expression = "a-1>=0 && a-1<0";
        exp = engine.compile(expression, context);
        System.out.println(expression + "：" + exp.eval(context));
//        expression = "'a'-1>=0 && 'a'-1<0";
//        System.out.println(expression + "：" + engine.eval(expression));
        expression = "a-'1'>=0 && a-'1'<0";
        exp = engine.compile(expression, context);
        System.out.println(expression + "：" + exp.eval(context));
//        expression = "'a'-'1'>=0 && 'a'-'1'<0";
//        System.out.println(expression + "：" + engine.eval(expression));
        System.out.println("=====================================================");
    }

    @Test
    public void testOr() throws Exception {
        String expression = "1-1>=0 || 1-1<0";
        Expression exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1'-1>=0 || '1'-1<0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "1-'1'>=0 || 1-'1'<0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1'-'1'>=0 || '1'-'1'<0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));

        expression = "1.1-1.2>=0 || 1.1-1.2<0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1.1'-1.2>=0 || '1.1'-1.2<0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "1.1-'1.2'>=0 || 1.1-'1.2'<0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));
        expression = "'1.1'-'1.2'>=0 || '1.1'-'1.2'<0";
        exp = engine.compile(expression, null);
        System.out.println(expression + "：" + exp.eval(null));

        FelContext context = engine.getContext();
        context.set("a", "1");
        expression = "a-1>=0 || a-1<0";
        exp = engine.compile(expression, context);
        System.out.println(expression + "：" + exp.eval(context));
//        expression = "'a'-1>=0 || 'a'-1<0";
//        System.out.println(expression + "：" + engine.eval(expression));
        expression = "a-'1'>=0 || a-'1'<0";
        exp = engine.compile(expression, context);
        System.out.println(expression + "：" + exp.eval(context));
//        expression = "'a'-'1'>=0 || 'a'-'1'<0";
//        System.out.println(expression + "：" + engine.eval(expression));
        System.out.println("=====================================================");
    }

}
