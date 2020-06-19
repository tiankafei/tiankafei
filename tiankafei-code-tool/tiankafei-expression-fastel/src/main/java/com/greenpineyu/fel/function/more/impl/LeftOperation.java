package com.greenpineyu.fel.function.more.impl;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.FunctionUtils;
import com.greenpineyu.fel.function.api.BaseMoreOperation;

import java.util.List;

/**
 * LEFT(text,num_chars)：根据指定的字符数返回文本串中的第一个或前几个字符。
 * text：需要选取字符的文本串。
 * num_chars：指定返回的字符串长度，必须等于或大于0。
 * 示例：
 * LEFT("Hello Everyone",5) 返回“Hello”。
 *
 * @author tiankafei
 */
public class LeftOperation extends BaseMoreOperation {

    private LeftOperation() {
    }

    private static class InternalClass {
        private final static BaseMoreOperation INSTANCE = new LeftOperation();
    }

    public static BaseMoreOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    @Override
    public Object evl(List<Object> dataList, FelContext context, int location) throws Exception {
        int number = 2;
        if (dataList.size() == number) {
            Object value1 = dataList.get(0);
            if (value1 == null) {
                return "";
            }
            Integer count = null;
            Object value2 = dataList.get(1);
            if (value2 == null) {
                throw new NullPointerException("left函数截取的位置为空，请确认!");
            } else {
                if (FunctionUtils.isString(value2)) {
                    if (FunctionUtils.isNumerics(value2.toString())) {
                        count = Integer.valueOf(value2.toString());
                    } else {
                        throw new NullPointerException("left函数截取的位置数据类型不正确，请确认!");
                    }
                } else if (value2 instanceof Number) {
                    count = Integer.valueOf(value2.toString());
                }
            }
            if (count != null) {
                String value = value1.toString();
                if (count > value.length()) {
                    count = value.length();
                }
                return value.substring(0, count);
            }
            throw new NullPointerException("传入参数数组为空或者参数个数不正确!");
        }
        throw new NullPointerException("传入参数数组为空或者参数个数不正确!");
    }
}
