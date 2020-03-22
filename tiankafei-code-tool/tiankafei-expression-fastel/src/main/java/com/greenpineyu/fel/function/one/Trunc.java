package com.greenpineyu.fel.function.one;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseOne;

/**
 * TRUNC(number)：将数字的小数部分截去，返回整数。
 * Number：需要进行小数截取的参数，必须为数字。
 * 示例：
 * TRUNC(1.3)等于1
 * TRUNC(9.9)等于9
 *
 * @author tiankafei
 */
public class Trunc extends BaseOne {

    @Override
    public String getName() {
        return FunctionConstants.TRUNC;
    }
}
