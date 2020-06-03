package com.greenpineyu.fel;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.FunctionUtils;
import org.junit.Test;

public class TestValue {

    @Test
    public void test1() throws Exception {
        FelEngine engine = Fel.newEngine();
        System.out.println(engine.eval("-1-1"));
        System.out.println(engine.eval("-1-1>=-1"));

        FelContext context = engine.getContext();
        context.set("a", "-1");
        context.set("b", "-1");
        Expression expression = engine.compile("a-b>=-1", context);
        System.out.println(expression.eval(context));


    }

    @Test
    public void test2() {
        String value = "1";
        System.out.println(value + "：" + FunctionUtils.isNumerics(value));
        value = "1.1";
        System.out.println(value + "：" + FunctionUtils.isNumerics(value));
        value = "-1.1";
        System.out.println(value + "：" + FunctionUtils.isNumerics(value));
        value = "--1.1";
        System.out.println(value + "：" + FunctionUtils.isNumerics(value));
        System.out.println("=====================================================");
    }

    @Test
    public void test3() {


    }

}
