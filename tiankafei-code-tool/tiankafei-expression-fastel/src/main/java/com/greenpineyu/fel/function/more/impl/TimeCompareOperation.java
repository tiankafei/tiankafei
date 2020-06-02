package com.greenpineyu.fel.function.more.impl;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.FunctionUtils;
import com.greenpineyu.fel.function.api.BaseMoreOperation;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 * 时间比较函数，传入四个参数（达到小时，达到分钟，离开小时，离开分钟）
 * 如果当天2点以前达到，算是第二天，如果是两点以后，则算是当天
 * 返回达到时间-离开时间 分钟
 *
 * @author tiankafei
 */
public class TimeCompareOperation extends BaseMoreOperation {

    private TimeCompareOperation() {
    }

    private static class InternalClass {
        private final static BaseMoreOperation INSTANCE = new TimeCompareOperation();
    }

    public static BaseMoreOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    @Override
    public Object evl(List<Object> dataList, FelContext context, int location) throws Exception {
        int length = dataList.size();
        int number4 = 4;
        if (length == number4) {
            Object arriveHoursObj = dataList.get(0);
            Object arriveMinuteObj = dataList.get(1);
            Object leaveHoursObj = dataList.get(2);
            Object leaveMinuteObj = dataList.get(3);

            boolean flag = arriveHoursObj != null && StringUtils.isNotBlank(arriveHoursObj.toString()) && FunctionUtils.isNumerics(arriveHoursObj)
                    && arriveMinuteObj != null && StringUtils.isNotBlank(arriveMinuteObj.toString()) && FunctionUtils.isNumerics(arriveMinuteObj)
                    && leaveHoursObj != null && StringUtils.isNotBlank(leaveHoursObj.toString()) && FunctionUtils.isNumerics(leaveHoursObj)
                    && leaveMinuteObj != null && StringUtils.isNotBlank(leaveMinuteObj.toString()) && FunctionUtils.isNumerics(leaveMinuteObj);
            if (flag) {
                int arriveHours = Integer.parseInt(arriveHoursObj.toString());
                int arriveMinute = Integer.parseInt(arriveMinuteObj.toString());
                int leaveHours = Integer.parseInt(leaveHoursObj.toString());
                int leaveMinute = Integer.parseInt(leaveMinuteObj.toString());

                if (arriveHours < 2) {
                    arriveHours += 24;
                }

                return (arriveHours * 60 + arriveMinute) - (leaveHours * 60 + leaveMinute);
            } else {
                throw new NullPointerException("timecompare传入参数不能为空且必须得是数字，请确认!");
            }
        }
        throw new NullPointerException("timecompare传入参数数组为空或者参数个数不正确!");
    }

}
