package com.greenpineyu.fel.function.operator.impl;

import com.greenpineyu.fel.common.NumberUtil;
import com.greenpineyu.fel.function.api.BaseTwoOperation;

import java.math.BigDecimal;

/**
 * 加
 *
 * @author tiankafei
 */
public class AddOperation extends BaseTwoOperation {

    private AddOperation() {
    }

    private static class InternalClass {
        private final static BaseTwoOperation INSTANCE = new AddOperation();
    }

    public static BaseTwoOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    @Override
    public Object evlNormalOperation(Object left, Object right) throws Exception {
        BigDecimal leftBigDecimal = new BigDecimal(left.toString());
        BigDecimal rightBigDecimal = new BigDecimal(right.toString());
        return leftBigDecimal.add(rightBigDecimal).doubleValue();
    }

    @Override
    public Object evlAbnormalOperation(Object left, Object right) throws Exception {
        return left.toString() + right.toString();
    }

    @Override
    public Object getReturnValue(Object object) {
        if (object instanceof Number) {
            object = NumberUtil.parseNumber(object.toString());
        }
        return object;
    }
}
