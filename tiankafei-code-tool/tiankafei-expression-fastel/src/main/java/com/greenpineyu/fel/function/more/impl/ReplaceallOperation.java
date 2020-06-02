package com.greenpineyu.fel.function.more.impl;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.api.BaseMoreOperation;
import java.util.List;

/**
 * 字符串替换函数 返回将源串中的匹配项全部替换为替换项之后的新串
 * 语法
 * REPLACEALL(text, regex, replacement)
 * text 源字符串
 * regex 匹配项字符串
 * replacement 替换字符串
 *
 * @author tiankafei
 */
public class ReplaceallOperation extends BaseMoreOperation {

    private ReplaceallOperation() {
    }

    private static class InternalClass {
        private final static BaseMoreOperation INSTANCE = new ReplaceallOperation();
    }

    public static BaseMoreOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    @Override
    public Object evl(List<Object> dataList, FelContext context, int location) throws Exception {
        int length = dataList.size();
        int number3 = 3;
        if (length == number3) {
            Object text = dataList.get(0);
            if (text == null) {
                return null;
            }
            Object regex = dataList.get(1);
            if (regex == null) {
                return null;
            }
            Object replacement = dataList.get(2);
            if (replacement == null) {
                return null;
            }

            String str = text.toString();
            return str.replaceAll(regex.toString(), replacement.toString());
        }
        throw new AviatorException("传入参数数组为空或者参数个数不正确!");
    }

}
