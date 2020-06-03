package com.greenpineyu.fel.function.more.impl;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.api.BaseMoreOperation;
import java.util.List;

/**
 * AND(logical1,logical2,...)：所有参数的逻辑值为真时，返回TRUE；只要一个参数的逻辑值为假，即返回FALSE。
 * Logical1,logical2,...：为需要进行检验的一个或者多个条件，分别为TRUE或者FALSE。
 * 示例：
 * AND(3=3) 返回TRUE
 * AND(1+1=2,2+2=5) 返回FALSE，其中一个参数的逻辑值为FALSE
 * AND(1+2=3,2+2=4) 返回TRUE，所有参数的逻辑值为TRUE
 *
 * @author tiankafei
 */
public class AndMoreOperation extends BaseMoreOperation {

    private AndMoreOperation() {
    }

    private static class InternalClass {
        private final static BaseMoreOperation INSTANCE = new AndMoreOperation();
    }

    public static BaseMoreOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    @Override
    public Object evl(List<Object> dataList, FelContext context, int location) throws Exception {
        Boolean result = Boolean.TRUE;
        for (int index = 0, length = dataList.size(); index < length; index++) {
            Object object = dataList.get(index);
            if (object instanceof Boolean) {
                Boolean flag = (Boolean) object;
                if (!flag.booleanValue()) {
                    result = Boolean.FALSE;
                    break;
                }
            } else {
                throw new Exception("表达式错误，请确认！");
            }
        }
        return result;
    }
}
