package com.greenpineyu.fel.function.operator;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseTwo;

/**
 * @author tiankafei
 */
public class LessThenEqual extends BaseTwo {

    @Override
    public String getName() {
        return FunctionConstants.LESS_THEN_EQUALS;
    }

    @Override
    public String getJsFunName() {
        return "RULE_LESSTHAN_EQUAL";
    }

}
