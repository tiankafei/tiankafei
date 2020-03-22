package com.greenpineyu.fel.function.one.impl;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.FunctionUtils;
import com.greenpineyu.fel.function.api.BaseOneOperation;

/**
 * ISNUM(test)：判断文本字符串是否全部为数字，如果是返回TRUE，否则返回FALSE。
 * test：需要进行判断的文本字符串。
 * 示例：
 * ISNUM("567") 返回TRUE
 * ISNUM("abc3") 返回FALSE
 *
 * @author tiankafei
 */
public class IsNumberOperation extends BaseOneOperation {

    private IsNumberOperation() {
    }

    private static class InternalClass {
        private final static BaseOneOperation INSTANCE = new IsNumberOperation();
    }

    public static BaseOneOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    @Override
    public Object evl(Object object, FelContext context, int location) throws Exception {
        Boolean result = Boolean.FALSE;
        if (object != null) {
            if (object instanceof Number) {
                result = Boolean.TRUE;
            } else if (FunctionUtils.isString(object)) {
                if (FunctionUtils.isNumerics(object)) {
                    result = Boolean.TRUE;
                }
            }
        }
        return result;
    }
}
