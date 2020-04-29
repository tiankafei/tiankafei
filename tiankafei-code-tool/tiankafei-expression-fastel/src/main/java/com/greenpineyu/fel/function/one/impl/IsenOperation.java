package com.greenpineyu.fel.function.one.impl;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.api.BaseOneOperation;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ISEN(test)：判断文本字符串是否全部为英文字母，如果是返回TRUE，否则返回FALSE。
 * test：需要进行判断的文本字符串。
 * 示例：
 * ISEN("abc") 返回TRUE
 * ISEN("def5") 返回FALSE
 *
 * @author tiankafei
 */
public class IsenOperation extends BaseOneOperation {

    private IsenOperation() {
    }

    private static class InternalClass {
        private final static BaseOneOperation INSTANCE = new IsenOperation();
    }

    public static BaseOneOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    @Override
    public Object evl(Object param, FelContext context, int location) throws Exception {
        if (param == null) {
            return Boolean.FALSE;
        }
        String regex = "[a-z|A-Z]{";
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
