package com.greenpineyu.fel.function.one;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseOne;

/**
 * ROUND(number)：返回某个数字经过四舍五入后的取整整数。
 * Number：需要进行四舍五入取整的参数，必须为数字。
 * 示例：
 * ROUND(8.5)等于9
 * ROUND(1.12)等于1
 *
 * @author tiankafei
 */
public class Round extends BaseOne {

    @Override
    public String getName() {
        return FunctionConstants.ROUND;
    }
}
