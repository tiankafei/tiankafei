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
public class TestAge {

    @Test
    public void test() throws Exception {
        FelEngine engine = Fel.newEngine();
        String expression = "AGE(1989, 09)";
        TestUtil.execute(expression, engine);
        expression = "age(\"1989\",\"09\")";
        TestUtil.execute(expression, engine);
        expression = "age(\"a\",09)";
        TestUtil.execute(expression, engine);
        expression = "age(1989,\"a\")";
        TestUtil.execute(expression, engine);
        expression = "age(\"a\",\"b\")";
        TestUtil.execute(expression, engine);

        expression = "age(1989,09,1999,08)";
        TestUtil.execute(expression, engine);
        expression = "age(\"1989\",\"09\",\"1999\",\"08\")";
        TestUtil.execute(expression, engine);
        expression = "age(\"a\",\"09\",\"1999\",\"09\")";
        TestUtil.execute(expression, engine);
        expression = "age(\"1989\",\"a\",\"1999\",\"09\")";
        TestUtil.execute(expression, engine);
        expression = "age(\"1989\",\"09\",\"a\",\"09\")";
        TestUtil.execute(expression, engine);
        expression = "age(\"1989\",\"09\",\"1999\",\"a\")";
        TestUtil.execute(expression, engine);
        TestUtil.execute(expression, engine);
        expression = "age(\"a\",\"b\",\"c\",\"d\")";
        TestUtil.execute(expression, engine);

        expression = "age(a, b)";
        FelContext context = engine.getContext();
        Expression expression1 = engine.compile(expression, context);
        context.set("a", 1989);
        context.set("b", 9);
        TestUtil.execute(expression1, context);
        context.set("a", "1989");
        context.set("b", "09");
        TestUtil.execute(expression1, context);

        expression = "age(a, b, c, d)";
        expression1 = engine.compile(expression, context);
        context.set("a", 1989);
        context.set("b", 9);
        context.set("c", 1999);
        context.set("d", 8);
        TestUtil.execute(expression1, context);
        context.set("a", "1989");
        context.set("b", "09");
        context.set("c", "1999");
        context.set("d", "08");
        TestUtil.execute(expression1, context);
        context.set("a", "a");
        context.set("b", "09");
        context.set("c", "1999");
        context.set("d", "08");
        TestUtil.execute(expression1, context);
    }

}
