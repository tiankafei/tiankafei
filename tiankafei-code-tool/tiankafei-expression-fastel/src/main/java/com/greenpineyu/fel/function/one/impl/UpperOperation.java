package com.greenpineyu.fel.function.one.impl;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.api.BaseOneOperation;

/**
 * 返回将源串转化为大写的新串
 * 语法
 * UPPER(源字符串)
 *
 * @author tiankafei
 */
public class UpperOperation extends BaseOneOperation {

    private UpperOperation() {
    }

    private static class InternalClass {
        private final static BaseOneOperation INSTANCE = new UpperOperation();
    }

    public static BaseOneOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    @Override
    public Object evl(Object text, FelContext context, int location) throws Exception {
        if (text == null) {
            return Boolean.FALSE;
        }
        return text.toString().toUpperCase();
    }
}
