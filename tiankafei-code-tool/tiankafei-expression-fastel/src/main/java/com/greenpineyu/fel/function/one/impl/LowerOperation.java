package com.greenpineyu.fel.function.one.impl;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.api.BaseOneOperation;

/**
 * 返回将源串转化为小写的新串
 * 语法
 * LOWER(源字符串)
 *
 * @author tiankafei
 */
public class LowerOperation extends BaseOneOperation {

    private LowerOperation() {
    }

    private static class InternalClass {
        private final static BaseOneOperation INSTANCE = new LowerOperation();
    }

    public static BaseOneOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    @Override
    public Object evl(Object text, FelContext context, int location) throws Exception {
        if (text == null) {
            return Boolean.FALSE;
        }
        return text.toString().toLowerCase();

    }
}
