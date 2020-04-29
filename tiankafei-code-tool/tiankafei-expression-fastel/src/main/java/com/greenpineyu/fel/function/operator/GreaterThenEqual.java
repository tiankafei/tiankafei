package com.greenpineyu.fel.function.operator;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseTwo;

/**
 * @author tiankafei
 */
public class GreaterThenEqual extends BaseTwo {

    @Override
    public String getName() {
        return FunctionConstants.GREATER_THEN_EQUALS;
    }

    @Override
    public String getJsFunName() {
        return "RULE_GREATERTHAN_EQUAL";
    }

}
