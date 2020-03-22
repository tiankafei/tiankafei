package com.greenpineyu.fel.function.operator;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseTwo;

/**
 * 逻辑操作符
 *
 * @author tiankafei
 */
public class And extends BaseTwo {

    @Override
    public String getName() {
        return FunctionConstants.AND;
    }

}