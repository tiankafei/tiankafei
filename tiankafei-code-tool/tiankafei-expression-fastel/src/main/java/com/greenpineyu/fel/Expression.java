package com.greenpineyu.fel;

import com.greenpineyu.fel.context.FelContext;

/**
 * @author tiankafei
 */
public interface Expression {
    /**
     * 求表达式的值
     *
     * @param context
     * @return
     */
    Object eval(FelContext context) throws Exception;

}
