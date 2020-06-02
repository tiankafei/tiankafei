package com.greenpineyu.fel.function.more.impl;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.FunctionUtils;
import com.greenpineyu.fel.function.api.BaseMoreOperation;

import java.util.List;

/**
 * RIGHT(text,num_chars)：根据指定的字符数从右开始返回文本串中的最后一个或几个字符。
 * text：需要提取字符的文本串。
 * num_chars：指定RIGHT函数从文本串中提取的字符数，必须等于或大于0。
 * 示例：
 * RIGHT("Huge sale",4) 返回“sale”
 *
 * @author tiankafei
 */
public class RightOperation extends BaseMoreOperation {

    private RightOperation() {
    }

    private static class InternalClass {
        private final static BaseMoreOperation INSTANCE = new RightOperation();
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
                throw new AviatorException("right函数截取的位置为空，请确认!");
            } else {
                if (FunctionUtils.isString(value2)) {
                    if (FunctionUtils.isNumerics(value2.toString())) {
                        count = Integer.valueOf(value2.toString());
                    } else {
                        throw new AviatorException("right函数截取的位置数据类型不正确，请确认!");
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
                return value.substring(value.length() - count);
            }
            throw new AviatorException("right函数传入参数数组为空或者参数个数不正确!");
        }
        throw new AviatorException("right函数传入参数数组为空或者参数个数不正确!");
    }
}
