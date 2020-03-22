package com.greenpineyu.fel.function.more;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseMore;

/**
 * MAX(number1,number2,…)：返回参数列表中的最大值。
 * Number1,number2,…：需要找出最大值的参数，必须为数字。
 * 示例：
 * MAX(0.1,0,1.2)等于1.2
 *
 * @author tiankafei
 */
public class Max extends BaseMore {

    @Override
    public String getName() {
        return FunctionConstants.MAX;
    }

}
