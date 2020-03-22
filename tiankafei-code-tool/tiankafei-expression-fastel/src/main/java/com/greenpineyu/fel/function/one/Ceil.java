package com.greenpineyu.fel.function.one;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseOne;

/**
 * CEIL(number)：将数字的小数部分截去，向上取整。
 * Number：需要进行小数截取的参数，必须为数字。
 * 示例：
 * CEIL(1.3)等于2
 * CEIL(9.9)等于10
 *
 * @author tiankafei
 */
public class Ceil extends BaseOne {

    @Override
    public String getName() {
        return FunctionConstants.CEIL;
    }
}
