package com.greenpineyu.fel.function;

import com.greenpineyu.fel.Expression;
import com.greenpineyu.fel.Fel;
import com.greenpineyu.fel.FelEngine;
import com.greenpineyu.fel.context.FelContext;
import org.junit.Test;

/**
 * @Author 魏双双
 * @Date 2019/12/10
 * @Version V1.0
 **/
public class TestSub {

    @Test
    public void test() throws Exception {
        FelEngine engine = Fel.newEngine();
        String expression = "1-0";
        TestUtil.execute(expression, engine);
        expression = "'1'-0";
        TestUtil.execute(expression, engine);
        expression = "1-'0'";
        TestUtil.execute(expression, engine);
        expression = "'1'-'0'";
        TestUtil.execute(expression, engine);
        expression = "'a'-'0'";
        TestUtil.execute(expression, engine);
        expression = "'a'-'b'";
        TestUtil.execute(expression, engine);

        expression = "a-b";
        FelContext context = engine.getContext();
        Expression expression1 = engine.compile(expression, context);
        context.set("a", 1);
        context.set("b", 0);
        TestUtil.execute(expression1, context);
        context.set("a", "1");
        context.set("b", 0);
        TestUtil.execute(expression1, context);
        context.set("a", 1);
        context.set("b", "0");
        TestUtil.execute(expression1, context);
        context.set("a", "1");
        context.set("b", "0");
        TestUtil.execute(expression1, context);
        context.set("a", "a");
        context.set("b", "0");
        TestUtil.execute(expression1, context);
        context.set("a", "a");
        context.set("b", "b");
        TestUtil.execute(expression1, context);
    }

}
