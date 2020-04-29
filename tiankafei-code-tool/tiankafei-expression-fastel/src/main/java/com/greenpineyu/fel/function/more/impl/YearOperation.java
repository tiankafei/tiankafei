package com.greenpineyu.fel.function.more.impl;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.FunctionUtils;
import com.greenpineyu.fel.function.api.BaseMoreOperation;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 * YEAR函数
 * 描述：用于检测年份
 * 语法：YEAR(单元格/行/列,CURRENTBGQFULL(),"0")
 * 返回：TRUE OR FALSE
 * 参数说明：有三个参数
 * (1)要检测的年份
 * (2)CURRENTBGQFULL() 当前报告期全称
 * (3)截止年份标识
 * "0" 判断年份是否在1800年到当前报告期所在的年份 [1800,当前报告期]
 * "1" 判断年份是否大于等于1800年 [1800,]
 * "2" 判断年份是否大于等当前报告期所在的年份 [当前报告期,]
 *
 * @author tiankafei
 */
public class YearOperation extends BaseMoreOperation {

    private YearOperation() {
    }

    private static class InternalClass {
        private final static BaseMoreOperation INSTANCE = new YearOperation();
    }

    public static BaseMoreOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    @Override
    public Object evl(List<Object> dataList, FelContext context, int location) throws Exception {
        int length = dataList.size();
        int number3 = 3;
        if (length == number3) {
            Object yearObj = dataList.get(0);
            Object currentBgqObj = dataList.get(1);
            Object tagObj = dataList.get(2);
            boolean flag = yearObj != null && StringUtils.isNotBlank(yearObj.toString())
                    && currentBgqObj != null && StringUtils.isNotBlank(currentBgqObj.toString())
                    && tagObj != null && StringUtils.isNotBlank(tagObj.toString());
            if (!flag) {
                return Boolean.FALSE;
            }
            String currentBgq = dataList.get(1).toString();
            String endTag = dataList.get(2).toString();

            String yearStr = "";
            if (FunctionUtils.isNumerics(yearObj.toString())) {
                yearStr = Double.valueOf(yearObj.toString()).intValue() + "";
            } else {
                return Boolean.FALSE;
            }
            String currentYear = "";
            if (currentBgq.length() > 4) {
                currentYear = currentBgq.substring(0, 4);
            } else {
                return Boolean.FALSE;
            }
            int year = Integer.valueOf(yearStr);
            if ("0".equals(endTag)) {
                return Boolean.valueOf((year - 1800 >= 0) && (Integer.valueOf(currentYear) - year >= 0));
            } else if ("1".equals(endTag)) {
                return Boolean.valueOf(year - 1800 >= 0);
            } else if ("2".equals(endTag)) {
                return Boolean.valueOf(year - Integer.valueOf(currentYear) >= 0);
            } else {
                return Boolean.FALSE;
            }
        }
        throw new NullPointerException("传入参数数组为空或者参数个数不正确!");
    }

}
