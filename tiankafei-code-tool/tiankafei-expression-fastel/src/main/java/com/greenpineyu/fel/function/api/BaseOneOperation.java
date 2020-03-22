package com.greenpineyu.fel.function.api;

import com.greenpineyu.fel.context.FelContext;

/**
 * @author tiankafei
 */
public abstract class BaseOneOperation {

    /**
     * 执行运算
     *
     * @param object   数据
     * @param context  参数
     * @param location 当前函数的定位
     * @return
     * @throws Exception
     */
    public abstract Object evl(Object object, FelContext context, int location) throws Exception;

}
