package com.greenpineyu.fel.function.more.impl;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.OperationFactory;
import com.greenpineyu.fel.function.api.BaseMoreOperation;

import java.util.List;

/**
 * SUM(number1,number2,…)：求所有参数之和。
 * Number1,number2,…：要进行求和操作的参数，必须为数字。
 * 示例：
 * SUM(70,80) 等于150。
 *
 * @author tiankafei
 */
public class SumOperation extends BaseMoreOperation {

    private SumOperation() {
    }

    private static class InternalClass {
        private final static BaseMoreOperation INSTANCE = new SumOperation();
    }

    public static BaseMoreOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    @Override
    public Object evl(List<Object> dataList, FelContext context, int location) throws Exception {
        int number = 2;
        if (dataList.size() >= number) {
            Object result = dataList.get(0);
            for (int index = 1, length = dataList.size(); index < length; index++) {
                Object right = dataList.get(index);
                result = OperationFactory.getBaseOperation(FunctionConstants.ADD).evl(result, right);
            }
            return result;
        }
        throw new NullPointerException("传入参数数组为空或者参数个数不正确!");
    }
}
