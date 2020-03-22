package com.greenpineyu.fel.function.one.impl;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.FunctionUtils;
import com.greenpineyu.fel.function.api.BaseOneOperation;

/**
 * ROUND(number)：返回某个数字经过四舍五入后的取整整数。
 * Number：需要进行四舍五入取整的参数，必须为数字。
 * 示例：
 * ROUND(8.5)等于9
 * ROUND(1.12)等于1
 *
 * @author tiankafei
 */
public class RoundOperation extends BaseOneOperation {

    private RoundOperation() {
    }

    private static class InternalClass {
        private final static BaseOneOperation INSTANCE = new RoundOperation();
    }

    public static BaseOneOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    @Override
    public Object evl(Object param, FelContext context, int location) throws Exception {
        double result = 0;
        if (param == null) {
            return result;
        }
        Double value = null;
        if (param instanceof Number) {
            value = Double.parseDouble(param.toString());
        } else if (FunctionUtils.isString(param)) {
            if (FunctionUtils.isNumerics(param)) {
                value = Double.parseDouble(param.toString());
            }
        }
        if (value != null) {
            return Math.round(value);
        }
        throw new IllegalArgumentException("ROUND函数的参数类型不合法!");
    }
}
