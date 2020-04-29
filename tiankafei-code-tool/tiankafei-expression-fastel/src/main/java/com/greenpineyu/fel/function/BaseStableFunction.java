package com.greenpineyu.fel.function;

import com.greenpineyu.fel.parser.Stable;

/**
 * @author tiankafei
 */
public abstract class BaseStableFunction implements Function, Stable {

    @Override
    public String getJsFunName() {
        return "RULE_" + getName();
    }

    /**
     * 求函数值是否固定不变
     * <p>
     * 当函数的参数相同时，多次执行函数，返回值都相同表示此函数是稳定的
     *
     * @see com.greenpineyu.fel.parser.Optimizable#stable()
     */
    @Override
    public boolean stable() {
        return true;
    }

}
