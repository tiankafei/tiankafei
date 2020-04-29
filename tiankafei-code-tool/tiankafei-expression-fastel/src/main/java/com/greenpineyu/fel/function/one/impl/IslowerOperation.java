package com.greenpineyu.fel.function.one.impl;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.api.BaseOneOperation;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 是否小写
 * 语法
 * ISLOWER(字符串)
 *
 * @author tiankafei
 */
public class IslowerOperation extends BaseOneOperation {

    private IslowerOperation() {
    }

    private static class InternalClass {
        private final static BaseOneOperation INSTANCE = new IslowerOperation();
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
        if (str.toLowerCase().equals(str)) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }
}
