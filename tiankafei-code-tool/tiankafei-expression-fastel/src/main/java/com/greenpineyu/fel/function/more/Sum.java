package com.greenpineyu.fel.function.more;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseMore;

/**
 * SUM(number1,number2,…)：求所有参数之和。
 * Number1,number2,…：要进行求和操作的参数，必须为数字。
 * 示例：
 * SUM(70,80) 等于150。
 *
 * @author tiankafei
 */
public class Sum extends BaseMore {

    @Override
    public String getName() {
        return FunctionConstants.SUM;
    }

}
