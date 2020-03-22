package com.greenpineyu.fel.function.one.impl;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.api.BaseOneOperation;
import org.apache.commons.lang3.StringUtils;

/**
 * ISNULL(test)：判断文本字符串是否为空，如果为空返回TRUE，如果不为空则返回FALSE。
 * test：需要进行判断的字符串。
 * 示例：
 * ISNULL("abc") 返回FALSE
 * ISNULL("") 返回TRUE
 *
 * @author tiankafei
 */
public class IsNullOperation extends BaseOneOperation {

    private IsNullOperation() {
    }

    private static class InternalClass {
        private final static BaseOneOperation INSTANCE = new IsNullOperation();
    }

    public static BaseOneOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    @Override
    public Object evl(Object object, FelContext context, int location) throws Exception {
        Boolean result = Boolean.FALSE;
        if (object == null) {
            result = Boolean.TRUE;
        } else {
            if (StringUtils.isBlank(object.toString())) {
                result = Boolean.TRUE;
            }
        }
        return result;
    }
}
