package com.greenpineyu.fel.function.more.impl;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.api.BaseMoreOperation;

import java.util.List;

/**
 * OR(logical1,logical2,...)：在其参数组中，任何一个参数逻辑值为TRUE，即返回TRUE；任何一个参数的逻辑值为FALSE，即返回FALSE。
 * Logical1,logical2,...：为需要进行检验的一个或者多个条件，分别为TRUE或者FALSE。
 * 示例：
 * OR(3=3) 返回TRUE
 * OR(1+1=1,2+2=5) 返回FALSE，所有参数的逻辑值为FALSE
 * OR(1+2=3,2+2=5) 返回TRUE，其中一个参数的逻辑值为TRUE
 *
 * @author tiankafei
 */
public class OrMoreOperation extends BaseMoreOperation {

    private OrMoreOperation() {
    }

    private static class InternalClass {
        private final static BaseMoreOperation INSTANCE = new OrMoreOperation();
    }

    public static BaseMoreOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    @Override
    public Object evl(List<Object> dataList, FelContext context, int location) throws Exception {
        Boolean result = Boolean.FALSE;
        for (int index = 0, length = dataList.size(); index < length; index++) {
            Object object = dataList.get(index);
            if (object instanceof Boolean) {
                Boolean flag = (Boolean) object;
                if (flag.booleanValue()) {
                    result = Boolean.TRUE;
                    break;
                }
            } else {
                throw new Exception("表达式错误，请确认！");
            }
        }
        return result;
    }
}
