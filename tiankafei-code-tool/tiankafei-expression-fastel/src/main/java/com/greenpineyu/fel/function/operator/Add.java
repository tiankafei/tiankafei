package com.greenpineyu.fel.function.operator;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseTwo;

/**
 * @author tiankafei
 */
public class Add extends BaseTwo {

    @Override
    public String getName() {
        return FunctionConstants.ADD;
    }

    @Override
    public String getJsFunName() {
        return "RULE_ADD";
    }
}
