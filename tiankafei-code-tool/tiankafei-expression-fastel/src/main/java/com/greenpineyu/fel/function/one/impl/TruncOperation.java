package com.greenpineyu.fel.function.one.impl;

import com.greenpineyu.fel.common.NumberUtil;
import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.FunctionUtils;
import com.greenpineyu.fel.function.api.BaseOneOperation;

import java.math.BigDecimal;

/**
 * TRUNC(number)：将数字的小数部分截去，返回整数。
 * Number：需要进行小数截取的参数，必须为数字。
 * 示例：
 * TRUNC(1.3)等于1
 * TRUNC(9.9)等于9
 *
 * @author tiankafei
 */
public class TruncOperation extends BaseOneOperation {

    private TruncOperation() {
    }

    private static class InternalClass {
        private final static BaseOneOperation INSTANCE = new TruncOperation();
    }

    public static BaseOneOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    @Override
    public Object evl(Object object, FelContext context, int location) throws Exception {
        BigDecimal bigDecimal = null;
        if (object instanceof Number) {
            bigDecimal = new BigDecimal(object.toString());
        } else if (FunctionUtils.isString(object)) {
            if (FunctionUtils.isNumerics(object)) {
                bigDecimal = new BigDecimal(object.toString());
            }
        }
        if (bigDecimal != null) {
            Object value = Math.floor(bigDecimal.doubleValue());
            return NumberUtil.parseNumber(value.toString());
        }
        throw new Exception("trunc函数传入的数据类型错误，请确认！");
    }
}
