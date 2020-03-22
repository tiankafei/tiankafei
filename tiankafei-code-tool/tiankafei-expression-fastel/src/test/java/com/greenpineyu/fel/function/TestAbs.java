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
public class TestAbs {

    @Test
    public void test() throws Exception {
        FelEngine engine = Fel.newEngine();
        String expression = "abs(1)";
        TestUtil.execute(expression, engine);
        expression = "abs(-1)";
        TestUtil.execute(expression, engine);
        expression = "abs(1.1)";
        TestUtil.execute(expression, engine);
        expression = "abs(-1.1)";
        TestUtil.execute(expression, engine);
        expression = "abs('1')";
        TestUtil.execute(expression, engine);
        expression = "abs('-1')";
        TestUtil.execute(expression, engine);
        expression = "abs('1.1')";
        TestUtil.execute(expression, engine);
        expression = "abs('-1.1')";
        TestUtil.execute(expression, engine);
        expression = "abs('a')";
        TestUtil.execute(expression, engine);
        expression = "abs(a)";
        TestUtil.execute(expression, engine);

        expression = "abs(a)";
        FelContext context = engine.getContext();
        Expression expression1 = engine.compile(expression, context);
        context.set("a", 1);
        TestUtil.execute(expression1, context);
        context.set("a", -1);
        TestUtil.execute(expression1, context);
        context.set("a", 1.1);
        TestUtil.execute(expression1, context);
        context.set("a", -1.1);
        TestUtil.execute(expression1, context);
        context.set("a", "1");
        TestUtil.execute(expression1, context);
        context.set("a", "-1");
        TestUtil.execute(expression1, context);
        context.set("a", "1.1");
        TestUtil.execute(expression1, context);
        context.set("a", "-1.1");
        TestUtil.execute(expression1, context);
        context.set("a", "a");
        TestUtil.execute(expression1, context);
    }

}
