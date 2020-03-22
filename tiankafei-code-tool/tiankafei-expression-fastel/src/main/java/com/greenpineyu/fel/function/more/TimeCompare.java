package com.greenpineyu.fel.function.more;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseMore;

/**
 * 时间比较函数，传入四个参数（达到小时，达到分钟，离开小时，离开分钟）
 * 如果当天2点以前达到，算是第二天，如果是两点以后，则算是当天
 * 返回达到时间-离开时间 分钟
 *
 * @author tiankafei
 */
public class TimeCompare extends BaseMore {

    @Override
    public String getName() {
        return FunctionConstants.TIMECOMPARE;
    }

}
