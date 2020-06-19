package com.greenpineyu.fel.function.operator.impl;

import com.greenpineyu.fel.function.FunctionUtils;
import com.greenpineyu.fel.function.api.BaseTwoOperation;

import java.math.BigDecimal;

/**
 * 小于等于
 *
 * @author tiankafei
 */
public class LessThenEqualsOperation extends LessThenOperation {

    private LessThenEqualsOperation() {
    }

    private static class InternalClass {
        private final static BaseTwoOperation INSTANCE = new LessThenEqualsOperation();
    }

    public static BaseTwoOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    @Override
    public Object evlNormalOperation(Object left, Object right) throws Exception {
        BigDecimal leftBigDecimal = new BigDecimal(left.toString());
        BigDecimal rightBigDecimal = new BigDecimal(right.toString());
        return leftBigDecimal.doubleValue() <= rightBigDecimal.doubleValue();
    }

    @Override
    public Object evlAbnormalOperation(Object left, Object right) throws Exception {
        if (FunctionUtils.isNumerics(left.toString()) && FunctionUtils.isNumerics(right.toString())) {
            return evlNormalOperation(left, right);
        } else {
            return compareTo(left, right) <= 0;
        }
    }
}
