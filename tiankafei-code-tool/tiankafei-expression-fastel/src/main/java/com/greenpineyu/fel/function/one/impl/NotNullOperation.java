package com.greenpineyu.fel.function.one.impl;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.api.BaseOneOperation;
import org.apache.commons.lang3.StringUtils;

/**
 * NOTNULL(test)：判断文本字符串是否不为空，如果不为空返回TRUE，如果为空则返回FALSE。
 * test：需要进行判断的字符串。
 * 示例：
 * NOTNULL("abc") 返回TRUE
 * NOTNULL("") 返回FALSE
 *
 * @author tiankafei
 */
public class NotNullOperation extends BaseOneOperation {

    private NotNullOperation() {
    }

    private static class InternalClass {
        private final static BaseOneOperation INSTANCE = new NotNullOperation();
    }

    public static BaseOneOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    @Override
    public Object evl(Object object, FelContext context, int location) throws Exception {
        Boolean result = Boolean.FALSE;
        if (object != null) {
            if (StringUtils.isNotBlank(object.toString())) {
                result = Boolean.TRUE;
            }
        }
        return result;
    }
}
