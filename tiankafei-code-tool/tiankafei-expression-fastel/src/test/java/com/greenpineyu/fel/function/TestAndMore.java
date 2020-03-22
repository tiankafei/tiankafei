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
public class TestAndMore {

    @Test
    public void test() throws Exception {
        FelEngine engine = Fel.newEngine();
        String expression = "and(1==1, 2==3, 'a'=='a')";
        TestUtil.execute(expression, engine);
        expression = "and('a'=='a', 2==2, 'a'=='a')";
        TestUtil.execute(expression, engine);

        expression = "and(a==b, c==d)";
        FelContext context = engine.getContext();
        Expression expression1 = engine.compile(expression, context);
        context.set("a", 1);
        context.set("b", 1);
        context.set("c", 2);
        context.set("d", 2);
        TestUtil.execute(expression1, context);
        context.set("a", '1');
        context.set("b", '1');
        context.set("c", '0');
        context.set("d", '0');
        TestUtil.execute(expression1, context);
        context.set("a", 1);
        context.set("b", '1');
        context.set("c", '0');
        context.set("d", 0);
        TestUtil.execute(expression1, context);
    }

}
