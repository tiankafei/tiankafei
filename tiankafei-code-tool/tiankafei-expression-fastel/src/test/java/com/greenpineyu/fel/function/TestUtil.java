package com.greenpineyu.fel.function;

import com.greenpineyu.fel.Expression;
import com.greenpineyu.fel.FelEngine;
import com.greenpineyu.fel.context.FelContext;

/**
 * @Author tiankafei
 * @Date 2019/12/10
 * @Version V1.0
 **/
public class TestUtil {

    public static void execute(String expression, FelEngine engine) {
        try {
            System.out.println(expression + "：" + engine.eval(expression));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void execute(Expression expression, FelContext context) {
        try {
            System.out.println(expression + "：" + expression.eval(context));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
