package com.greenpineyu.fel.function.one;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseOne;

/**
 * 返回将源串转化为小写的新串
 * 语法
 * LOWER(源字符串)
 *
 * @author tiankafei
 */
public class Lower extends BaseOne {

    @Override
    public String getName() {
        return FunctionConstants.LOWER;
    }
}
