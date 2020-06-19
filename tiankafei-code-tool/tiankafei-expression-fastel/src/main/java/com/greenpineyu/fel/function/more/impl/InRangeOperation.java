package com.greenpineyu.fel.function.more.impl;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.FunctionUtils;
import com.greenpineyu.fel.function.api.BaseMoreOperation;

import java.util.List;

/**
 * INRANGE(text,start_range,end_range)：判断文本字符串是否在另一文本字符串范围内，在范围内返回TRUE，否则返回 FALSE。
 * text：需要进行范围判断的文本字符串
 * start_range：范围开始字符串。
 * end_range：范围结束字符串。
 * 示例：
 * INRANGE("05","01","12") 返回TRUE
 * INRANGE("20","20","30") 返回TRUE
 * INRANGE("abc","db","ef") 返回FALSE
 *
 * @author tiankafei
 */
public class InRangeOperation extends BaseMoreOperation {

    private InRangeOperation() {
    }

    private static class InternalClass {
        private final static BaseMoreOperation INSTANCE = new InRangeOperation();
    }

    public static BaseMoreOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    @Override
    public Object evl(List<Object> dataList, FelContext context, int location) throws Exception {
        int length = dataList.size();
        int number = 3;
        if (length == number) {
            Object text = dataList.get(0);
            Object beginTxt = dataList.get(1);
            Object endTxt = dataList.get(2);

            if (text != null && beginTxt != null && endTxt != null) {
                if (FunctionUtils.isString(text) || FunctionUtils.isString(beginTxt) || FunctionUtils.isString(endTxt)) {
                    //只要有一个是字符串的时候
                    if (FunctionUtils.isNumerics(text.toString())
                            && FunctionUtils.isNumerics(beginTxt.toString())
                            && FunctionUtils.isNumerics(endTxt.toString())) {
                        //全部为数字时，走数字的比较
                        return Boolean.valueOf(Double.parseDouble(text.toString()) >= Double.parseDouble(beginTxt.toString()) && Double.parseDouble(text.toString()) <= Double.parseDouble(endTxt.toString()));
                    } else {
                        //部分为数字时，走字符串的比较
                        String strText = text.toString();
                        String strBeginTxt = beginTxt.toString();
                        String strEndTxt = endTxt.toString();
                        return Boolean.valueOf((strText).compareTo(strBeginTxt) >= 0 && (strText).compareTo(strEndTxt) <= 0);
                    }
                }
                if (text instanceof Number && beginTxt instanceof Number && endTxt instanceof Number) {
                    return Boolean.valueOf(((Number) text).doubleValue() >= ((Number) beginTxt).doubleValue() && ((Number) text).doubleValue() <= ((Number) endTxt).doubleValue());
                }
            }
            return Boolean.FALSE;
        }
        throw new NullPointerException("传入参数数组为空或者参数个数不正确!");
    }
}
