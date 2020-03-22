package com.greenpineyu.fel.function.more.impl;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.FunctionUtils;
import com.greenpineyu.fel.function.api.BaseMoreOperation;

import java.util.List;

/**
 * MIN(number1,number2,…)：返回参数列表中的最小值。
 * Number1,number2,…：需要找出最小值的参数，必须为数字。
 * 示例:
 * MIN(5,3,9)等于3
 *
 * @author tiankafei
 */
public class MinOperation extends BaseMoreOperation {

    private MinOperation() {
    }

    private static class InternalClass {
        private final static BaseMoreOperation INSTANCE = new MinOperation();
    }

    public static BaseMoreOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    @Override
    public Object evl(List<Object> dataList, FelContext context, int location) throws Exception {
        int length = dataList.size();
        if (length > 0) {
            Double standValue = null;
            Integer maxLocation = 0;
            for (int index = 0; index < length; index++) {
                Object object = dataList.get(index);

                Double temp = null;
                if (FunctionUtils.isString(object)) {
                    if (FunctionUtils.isNumerics(object.toString())) {
                        temp = Double.parseDouble(object.toString());
                    } else {
                        throw new Exception("max函数传入的数据类型错误，请确认！");
                    }
                } else if (object instanceof Number) {
                    temp = Double.parseDouble(object.toString());
                }
                if (temp == null) {
                    throw new Exception("max函数传入的数据类型错误，请确认！");
                }
                if (index == 0) {
                    //记录标准值
                    standValue = temp;
                    maxLocation = index;
                } else {
                    //进行比较
                    if (standValue > temp) {
                        standValue = temp;
                        maxLocation = index;
                    }
                }
            }
            return dataList.get(maxLocation);
        }
        throw new NullPointerException("传入参数数组为空或者参数个数不正确!");
    }
}
