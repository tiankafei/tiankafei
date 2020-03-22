package com.greenpineyu.fel.function.operator.impl;

import com.greenpineyu.fel.common.NumberUtil;
import com.greenpineyu.fel.function.FunctionUtils;
import com.greenpineyu.fel.function.api.BaseTwoOperation;

import java.math.BigDecimal;

/**
 * 除
 *
 * @author tiankafei
 */
public class DivOperation extends BaseTwoOperation {

    private DivOperation() {
    }

    private static class InternalClass {
        private final static BaseTwoOperation INSTANCE = new DivOperation();
    }

    public static BaseTwoOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    @Override
    public Object evlNormalOperation(Object left, Object right) throws Exception {
        BigDecimal leftBigDecimal = new BigDecimal(left.toString());
        BigDecimal rightBigDecimal = new BigDecimal(right.toString());
        if (rightBigDecimal.doubleValue() == 0.0) {
            throw new Exception("除法运算被除数不能为0！");
        }
        return leftBigDecimal.divide(rightBigDecimal, 20, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    @Override
    public Object evlAbnormalOperation(Object left, Object right) throws Exception {
        if (FunctionUtils.isNumerics(left.toString()) && FunctionUtils.isNumerics(right.toString())) {
            return evlNormalOperation(left, right);
        } else {
            throw new Exception("文本字符串不能参与除法运算！");
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
