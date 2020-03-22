package com.greenpineyu.fel.function.more.impl;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.api.BaseMoreOperation;

import java.util.List;

/**
 * IF(logical,value_if_true,value_if_false)：判断一个条件是否满足，如果满足返回一个值，如果不满足则返回另一个值。
 * logical：表示计算结果为TRUE或FALSE的任意值或逻辑表达式。
 * value_if_true：logical为TRUE时返回的值。
 * value_if_false：logical为FALSE时返回的值。
 * 示例：
 * IF(3>2,1,-1) 返回1
 * IF(2+3>6,1,-1) 返回-1
 *
 * @author tiankafei
 */
public class IfOperation extends BaseMoreOperation {

    private IfOperation() {
    }

    private static class InternalClass {
        private final static BaseMoreOperation INSTANCE = new IfOperation();
    }

    public static BaseMoreOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    @Override
    public Object evl(List<Object> dataList, FelContext context, int location) throws Exception {
        int number2 = 2;
        int number3 = 3;
        int length = dataList.size();
        if (length == number2 || length == number3) {
            Object value1 = dataList.get(0);
            if (value1 instanceof Boolean) {
                boolean flag = (boolean) value1;
                if (flag) {
                    Object value2 = dataList.get(1);
                    return value2;
                } else {
                    if (length == number3) {
                        Object value3 = dataList.get(2);
                        return value3;
                    }
                }
                return Boolean.TRUE;
            }
            throw new NullPointerException("参数类型不正确，请确认!");
        }
        throw new NullPointerException("传入参数数组为空或者参数个数不正确!");
    }
}
