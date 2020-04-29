package com.greenpineyu.fel.function.one.impl;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.api.BaseOneOperation;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ISCH(test)：判断文本字符串是否全部为汉字，如果是返回TRUE，否则返回FALSE。
 * test：需要进行判断的文本字符串。
 * 示例：
 * ISCH("制度") 返回TRUE
 * ISCH("报表101") 返回FALSE
 *
 * @author tiankafei
 */
public class IschOperation extends BaseOneOperation {

    private IschOperation() {
    }

    private static class InternalClass {
        private final static BaseOneOperation INSTANCE = new IschOperation();
    }

    public static BaseOneOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    @Override
    public Object evl(Object param, FelContext context, int location) throws Exception {
        if (param == null) {
            return Boolean.FALSE;
        }
        String regex = "[\u4e00-\u9fa5]{";

        if (param instanceof String) {
            regex = regex + ((String) param).length() + "}";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher((String) param);

            return Boolean.valueOf(matcher.matches());
        } else {
            return Boolean.FALSE;
        }
    }
}
