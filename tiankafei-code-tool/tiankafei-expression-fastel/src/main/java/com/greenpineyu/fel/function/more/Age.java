package com.greenpineyu.fel.function.more;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseMore;

/**
 * AGE(出生年份，出生月份，基准年份，基准月份)：根据出生年月获得年龄。
 * 后面两个参数为空，则以当前时间为基准时间
 *
 * @author tiankafei
 */
public class Age extends BaseMore {

    @Override
    public String getName() {
        return FunctionConstants.AGE;
    }

}
