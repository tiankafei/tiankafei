package com.greenpineyu.fel.function.operator;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseTwo;

/**
 * @author tiankafei
 */
public class GreaterThen extends BaseTwo {

    @Override
    public String getName() {
        return FunctionConstants.GREATER_THEN;
    }

    @Override
    public String getJsFunName() {
        return "RULE_GREATERTHAN";
    }
}
