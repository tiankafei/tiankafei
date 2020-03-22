package com.greenpineyu.fel.function.operator.impl;

import com.greenpineyu.fel.common.NumberUtil;
import com.greenpineyu.fel.function.FunctionUtils;
import com.greenpineyu.fel.function.api.BaseTwoOperation;

import java.math.BigDecimal;

/**
 * 减
 *
 * @author tiankafei
 */
public class SubOperation extends BaseTwoOperation {

    private SubOperation() {
    }

    private static class InternalClass {
        private final static BaseTwoOperation INSTANCE = new SubOperation();
    }

    public static BaseTwoOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    /**
     * 获取值
     *
     * @param object
     * @return
     * @throws Exception
     */
    public static Object getValue(Object object) throws Exception {
        BigDecimal bigDecimal = null;
        if (FunctionUtils.isString(object)) {
            if (FunctionUtils.isNumerics(object)) {
                bigDecimal = new BigDecimal(object.toString());
            }
        } else if (object instanceof Number) {
            bigDecimal = new BigDecimal(object.toString());
        }
        if (bigDecimal != null) {
            return bigDecimal.multiply(new BigDecimal("-1"));
        }
        throw new Exception("数据类型错误，请确认！");
    }

    @Override
    public Object evlNormalOperation(Object left, Object right) throws Exception {
        BigDecimal leftBigDecimal = new BigDecimal(left.toString());
        BigDecimal rightBigDecimal = new BigDecimal(right.toString());
        return leftBigDecimal.subtract(rightBigDecimal).doubleValue();
    }

    @Override
    public Object evlAbnormalOperation(Object left, Object right) throws Exception {
        if (FunctionUtils.isNumerics(left.toString()) && FunctionUtils.isNumerics(right.toString())) {
            return evlNormalOperation(left, right);
        } else {
            throw new Exception("文本字符串不能参与减法运算！");
        }
    }

    @Override
    public Object getReturnValue(Object object) {
        if (object instanceof Number) {
            object = NumberUtil.parseNumber(object.toString());
        }
        return object;
    }
}
