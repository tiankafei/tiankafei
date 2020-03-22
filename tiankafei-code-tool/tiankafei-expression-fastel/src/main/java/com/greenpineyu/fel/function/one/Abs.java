package com.greenpineyu.fel.function.one;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseOne;

/**
 * ABS(number)：返回参数的绝对值。
 * Number：需要取绝对值的参数，必须为数字。
 * 示例：
 * ABS(1.2-9) 结果等于7.8
 *
 * @author tiankafei
 */
public class Abs extends BaseOne {

    @Override
    public String getName() {
        return FunctionConstants.ABS;
    }
}
