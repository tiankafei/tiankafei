package com.greenpineyu.fel.function.one.impl;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.api.BaseOneOperation;

/**
 * 是否大写
 * 语法
 * ISUPPER(字符串)
 *
 * @author tiankafei
 */
public class IsupperOperation extends BaseOneOperation {

    private IsupperOperation() {
    }

    private static class InternalClass {
        private final static BaseOneOperation INSTANCE = new IsupperOperation();
    }

    public static BaseOneOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    @Override
    public Object evl(Object text, FelContext context, int location) throws Exception {
        if (text == null) {
            return Boolean.FALSE;
        }
        String str = text.toString();
        if (str.toUpperCase().equals(str)) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }
}
