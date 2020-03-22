package com.greenpineyu.fel.function.operator.impl;

import com.greenpineyu.fel.common.NumberUtil;
import com.greenpineyu.fel.function.api.BaseTwoOperation;

/**
 * 不等于
 *
 * @author tiankafei
 */
public class AndOperation extends BaseTwoOperation {

    private static class InternalClass {
        private final static BaseTwoOperation INSTANCE = new AndOperation();
    }

    public static BaseTwoOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    @Override
    public Boolean evl(Object left, Object right) throws Exception {
        Boolean leftValue = NumberUtil.toBooleanObj(left);
        Boolean rightValue = NumberUtil.toBooleanObj(right);

        if (leftValue.booleanValue() && rightValue.booleanValue()) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

}
