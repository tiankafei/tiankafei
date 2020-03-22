package com.greenpineyu.fel.function.one.impl;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.api.BaseOneOperation;

/**
 * NOT(logical)：对参数的逻辑值求反，参数为TRUE时返回FALSE，参数为FALSE时返回TRUE
 * logical：表示计算结果为TRUE或FALSE的任意值或逻辑表达式。
 * 示例：
 * NOT(2>3) 返回TRUE
 * NOT(2+3>4) 返回FALSE
 *
 * @author tiankafei
 */
public class NotOperation extends BaseOneOperation {

    private NotOperation() {
    }

    private static class InternalClass {
        private final static BaseOneOperation INSTANCE = new NotOperation();
    }

    public static BaseOneOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    @Override
    public Object evl(Object object, FelContext context, int location) throws Exception {
        if (object instanceof Boolean) {
            return !(Boolean) object;
        }
        throw new Exception("数据类型错误，请确认！");
    }
}
