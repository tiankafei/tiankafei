package com.greenpineyu.fel.function.more;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseMore;

/**
 * MIN(number1,number2,…)：返回参数列表中的最小值。
 * Number1,number2,…：需要找出最小值的参数，必须为数字。
 * 示例:
 * MIN(5,3,9)等于3
 *
 * @author tiankafei
 */
public class Min extends BaseMore {

    @Override
    public String getName() {
        return FunctionConstants.MIN;
    }

}
