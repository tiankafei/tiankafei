package com.greenpineyu.fel.function.operator.impl;

import com.greenpineyu.fel.common.NumberUtil;
import com.greenpineyu.fel.function.api.BaseTwoOperation;

/**
 * 或者
 *
 * @author tiankafei
 */
public class OrOperation extends AndOperation {

    private OrOperation() {

    }

    private static class InternalClass {
        private final static BaseTwoOperation INSTANCE = new OrOperation();
    }

    public static BaseTwoOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    @Override
    public Boolean evl(Object left, Object right) throws Exception {
        Boolean leftValue = NumberUtil.toBooleanObj(left);
        Boolean rightValue = NumberUtil.toBooleanObj(right);

        if (leftValue.booleanValue() || rightValue.booleanValue()) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

}
