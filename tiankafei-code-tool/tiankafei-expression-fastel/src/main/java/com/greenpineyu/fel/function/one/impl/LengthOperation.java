package com.greenpineyu.fel.function.one.impl;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.api.BaseOneOperation;

/**
 * LEN(text)：返回文本串中的字符数。
 * text：需要求其长度的文本，空格也计为字符。
 * 示例：
 * LEN("Hello") 返回5
 * LEN(" ") 返回1
 *
 * @author tiankafei
 */
public class LengthOperation extends BaseOneOperation {

    private LengthOperation() {
    }

    private static class InternalClass {
        private final static BaseOneOperation INSTANCE = new LengthOperation();
    }

    public static BaseOneOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    @Override
    public Object evl(Object param, FelContext context, int location) throws Exception {
        if (param == null) {
            return 0;
        }
        return param.toString().length();
    }
}
