package com.greenpineyu.fel.function.more.impl;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.FunctionUtils;
import com.greenpineyu.fel.function.api.BaseMoreOperation;

import java.util.List;

/**
 * MID(text,start_num,num_chars)：返回文本串中从指定位置开始的一定数目的字符，该数目由用户指定。
 * text：包含要提取字符的文本串。
 * start_num：文本中需要提取字符的起始位置。文本中第一个字符的start_num为1，依此类推。
 * num_chars：返回字符的长度。
 * 示例:
 * MID("Hello",1,3)返回“Hel”
 * MID("Hello Everyone",7,8)返回“Everyone”
 *
 * @author tiankafei
 */
public class MidOperation extends BaseMoreOperation {

    private MidOperation() {
    }

    private static class InternalClass {
        private final static BaseMoreOperation INSTANCE = new MidOperation();
    }

    public static BaseMoreOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    @Override
    public Object evl(List<Object> dataList, FelContext context, int location) throws Exception {
        int number = 3;
        if (dataList.size() == number) {
            Object value1 = dataList.get(0);
            if (value1 == null) {
                return "";
            }

            Integer start = null;
            Object value2 = dataList.get(1);
            if (value2 == null) {
                throw new AviatorException("mid函数截取的起始位置为空，请确认!");
            } else {
                if (FunctionUtils.isString(value2)) {
                    if (FunctionUtils.isNumerics(value2.toString())) {
                        start = Integer.valueOf(value2.toString());
                    } else {
                        throw new AviatorException("mid函数截取的起始位置数据类型不正确，请确认!");
                    }
                } else if (value2 instanceof Number) {
                    start = Integer.valueOf(value2.toString());
                }
            }

            String value = value1.toString();
            Integer end = null;
            Object value3 = dataList.get(2);
            if (value3 == null) {
                throw new AviatorException("mid函数截取的结束位置为空，请确认!");
            } else {
                if (FunctionUtils.isString(value3)) {
                    if (FunctionUtils.isNumerics(value3.toString())) {
                        end = Integer.valueOf(value3.toString());
                    } else {
                        throw new AviatorException("mid函数截取的结束位置数据类型不正确，请确认!");
                    }
                } else if (value3 instanceof Number) {
                    end = Integer.valueOf(value3.toString());
                }
            }
            if (start > end) {
                throw new AviatorException("mid函数截取的开始位置比结束位置大，请确认!");
            }
            if (start != null && end != null) {
                if (end > value.length()) {
                    end = value.length();
                }
                return value.substring(start, end);
            }
            throw new AviatorException("传入参数数组为空或者参数个数不正确!");
        }
        throw new AviatorException("传入参数数组为空或者参数个数不正确!");
    }
}
