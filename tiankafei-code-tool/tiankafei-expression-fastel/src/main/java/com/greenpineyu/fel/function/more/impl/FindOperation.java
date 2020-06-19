package com.greenpineyu.fel.function.more.impl;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.FunctionUtils;
import com.greenpineyu.fel.function.api.BaseMoreOperation;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * 正则表达式函数:根据正则表达式模式，判断文本字符串是否从指定位置之后存在匹配
 * 语法
 * FIND(text_pattern,text_matcher,start)
 * text_pattern 正则表达式模式
 * text_matcher 文本字符串
 * start 指定位置
 *
 * @author tiankafei
 */
public class FindOperation extends BaseMoreOperation {

    private FindOperation() {
    }

    private static class InternalClass {
        private final static BaseMoreOperation INSTANCE = new FindOperation();
    }

    public static BaseMoreOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    @Override
    public Object evl(List<Object> dataList, FelContext context, int location) throws Exception {
        int length = dataList.size();
        if (length == 2 || length == 3) {
            try {
                Object pattern = dataList.get(0);
                Object matcher = dataList.get(1);
                int start = 0;
                if (dataList.size() == 3) {
                    Object value3 = dataList.get(2);
                    if (value3 != null && StringUtils.isNotBlank(value3.toString())) {
                        if (FunctionUtils.isNumerics(value3.toString())) {
                            start = Integer.parseInt(value3.toString());
                        }
                    }
                }
                if (pattern == null || matcher == null) {
                    return Boolean.FALSE;
                }
                Pattern p;
                try {
                    p = Pattern.compile(pattern.toString());
                } catch (PatternSyntaxException e) {
                    //目前发现，解析左花括号“{”有问题，其他特殊符号有没有问题，未知
                    if ("{".equals(pattern) || "\\\\{".equals(pattern)) {
                        pattern = "\\{";
                    }
                    p = Pattern.compile(pattern.toString());
                }
                if (StringUtils.isEmpty(matcher.toString())) {
                    matcher = getNullString(start);
                }
                if (start > matcher.toString().length()) {
                    start = matcher.toString().length();
                }
                Matcher m = p.matcher(matcher.toString());
                return Boolean.valueOf(m.find(start));
            } catch (Exception e) {
                e.printStackTrace();
                throw new IllegalArgumentException("FIND函数的参数类型不合法!");
            }
        }
        throw new NullPointerException("传入参数数组为空或者参数个数不正确!");
    }

    private static String getNullString(int length) {
        StringBuffer bf = new StringBuffer();
        for (int i = 0; i < length; i++) {
            bf.append(" ");
        }
        return bf.toString();
    }

}
