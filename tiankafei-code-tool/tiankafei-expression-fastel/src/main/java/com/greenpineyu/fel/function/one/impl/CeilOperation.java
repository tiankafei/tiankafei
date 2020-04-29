package com.greenpineyu.fel.function.one.impl;

import com.greenpineyu.fel.common.NumberUtil;
import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.FunctionUtils;
import com.greenpineyu.fel.function.api.BaseOneOperation;
import java.math.BigDecimal;

/**
 * CEIL(number)：将数字的小数部分截去，向上取整。
 * Number：需要进行小数截取的参数，必须为数字。
 * 示例：
 * CEIL(1.3)等于2
 * CEIL(9.9)等于10
 *
 * @author tiankafei
 */
public class CeilOperation extends BaseOneOperation {

    private CeilOperation() {
    }

    private static class InternalClass {
        private final static BaseOneOperation INSTANCE = new CeilOperation();
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
            Object value = Math.ceil(bigDecimal.doubleValue());
            return NumberUtil.parseNumber(value.toString());
        }
        throw new Exception("ceil函数传入的数据类型错误，请确认！");
    }
}
