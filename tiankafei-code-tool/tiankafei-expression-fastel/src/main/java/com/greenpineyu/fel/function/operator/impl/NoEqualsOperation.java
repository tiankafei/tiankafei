package com.greenpineyu.fel.function.operator.impl;

import com.greenpineyu.fel.function.api.BaseTwoOperation;
import java.math.BigDecimal;

/**
 * 不等于
 *
 * @author tiankafei
 */
public class NoEqualsOperation extends EqualsOperation {

    private NoEqualsOperation() {

    }

    private static class InternalClass {
        private final static BaseTwoOperation INSTANCE = new NoEqualsOperation();
    }

    public static BaseTwoOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    @Override
    public Object evl(Object left, Object right) throws Exception {
        if (left == null && right == null) {
            return Boolean.FALSE;
        } else if (left == null || right == null) {
            return Boolean.TRUE;
        }

        return super.evl(left, right);
    }

    @Override
    public Object evlNormalOperation(Object left, Object right) throws Exception {
        BigDecimal leftBigDecimal = new BigDecimal(left.toString());
        BigDecimal rightBigDecimal = new BigDecimal(right.toString());
        return leftBigDecimal.doubleValue() != rightBigDecimal.doubleValue();
    }

    @Override
    public Object evlAbnormalOperation(Object left, Object right) throws Exception {
        return !left.toString().equals(right.toString());
    }
}
