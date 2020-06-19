package com.greenpineyu.fel.function.one.impl;

import com.greenpineyu.fel.common.NumberUtil;
import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.FunctionUtils;
import com.greenpineyu.fel.function.api.BaseOneOperation;

import java.math.BigDecimal;

/**
 * ABS(number)：返回参数的绝对值。
 * Number：需要取绝对值的参数，必须为数字。
 * 示例：
 * ABS(1.2-9) 结果等于7.8
 *
 * @author tiankafei
 */
public class AbsOperation extends BaseOneOperation {

    private AbsOperation() {
    }

    private static class InternalClass {
        private final static BaseOneOperation INSTANCE = new AbsOperation();
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
            Object value = Math.abs(bigDecimal.doubleValue());
            return NumberUtil.parseNumber(value.toString());
        }
        throw new Exception("abs函数的参数不能是非数字，请确认！");
    }
}
