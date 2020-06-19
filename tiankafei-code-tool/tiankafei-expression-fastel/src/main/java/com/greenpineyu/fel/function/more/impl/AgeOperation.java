package com.greenpineyu.fel.function.more.impl;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.FunctionUtils;
import com.greenpineyu.fel.function.api.BaseMoreOperation;
import org.apache.commons.lang3.StringUtils;

import java.util.Calendar;
import java.util.List;

/**
 * AGE(出生年份，出生月份，基准年份，基准月份)：根据出生年月获得年龄。
 * 后面两个参数为空，则以当前时间为基准时间
 *
 * @author tiankafei
 */
public class AgeOperation extends BaseMoreOperation {

    private AgeOperation() {
    }

    private static class InternalClass {
        private final static BaseMoreOperation INSTANCE = new AgeOperation();
    }

    public static BaseMoreOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    @Override
    public Object evl(List<Object> dataList, FelContext context, int location) throws Exception {
        if (dataList.get(0) == null || dataList.get(1) == null) {
            return 0;
        }
        String year = dataList.get(0).toString();
        String month = dataList.get(1).toString();
        int yearInt = 0;
        if (StringUtils.isNotEmpty(year)) {
            if (FunctionUtils.isNumerics(year)) {
                yearInt = (int) Double.parseDouble(year);
            } else {
                throw new NullPointerException("age函数传入的年份只能是数字，请确认!");
            }
        }
        int monthInt = 0;
        if (StringUtils.isNotEmpty(month)) {
            if (FunctionUtils.isNumerics(month)) {
                monthInt = (int) Double.parseDouble(month);
            } else {
                throw new NullPointerException("age函数传入的月份只能是数字，请确认!");
            }
        }
        //取得系统时间
        Calendar cal = Calendar.getInstance();
        int currentYear = cal.get(Calendar.YEAR);
        int currentMonth = cal.get(Calendar.MONTH) + 1;
        int paramCount = 4;
        if (dataList.size() == paramCount) {
            if (dataList.get(2) != null) {
                if (StringUtils.isNotEmpty(dataList.get(2).toString())) {
                    if (FunctionUtils.isNumerics(dataList.get(2).toString())) {
                        currentYear = Integer.parseInt(dataList.get(2).toString());
                    } else {
                        throw new NullPointerException("age函数传入的年份只能是数字，请确认!");
                    }
                }
            }
            if (dataList.get(3) != null) {
                if (StringUtils.isNotEmpty(dataList.get(3).toString())) {
                    if (FunctionUtils.isNumerics(dataList.get(3).toString())) {
                        currentMonth = Integer.parseInt(dataList.get(3).toString());
                    } else {
                        throw new NullPointerException("age函数传入的月份只能是数字，请确认!");
                    }
                }
            }
        }
        int age = 0;
        if (currentMonth - monthInt < 0) {
            age = currentYear - yearInt - 1;
        } else {
            age = currentYear - yearInt;
        }
        return Integer.valueOf(age);
    }
}
