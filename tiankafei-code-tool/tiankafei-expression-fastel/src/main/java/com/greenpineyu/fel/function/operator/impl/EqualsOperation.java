package com.greenpineyu.fel.function.operator.impl;

import com.greenpineyu.fel.function.api.BaseTwoOperation;

import java.math.BigDecimal;

/**
 * 等于
 *
 * @author tiankafei
 */
public class EqualsOperation extends BaseTwoOperation {

    private static class InternalClass {
        private final static BaseTwoOperation INSTANCE = new EqualsOperation();
    }

    public static BaseTwoOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    @Override
    public Object evl(Object left, Object right) throws Exception {
        if (left == null && right == null) {
            return Boolean.TRUE;
        } else if (left == null || right == null) {
            return Boolean.FALSE;
        }

        return super.evl(left, right);
    }

    @Override
    public Object evlNormalOperation(Object left, Object right) throws Exception {
        BigDecimal leftBigDecimal = new BigDecimal(left.toString());
        BigDecimal rightBigDecimal = new BigDecimal(right.toString());
        return leftBigDecimal.doubleValue() == rightBigDecimal.doubleValue();
    }

    @Override
    public Object evlAbnormalOperation(Object left, Object right) throws Exception {
        return left.toString().equals(right.toString());
    }

}
