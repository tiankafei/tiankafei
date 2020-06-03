package com.greenpineyu.fel.function.api;

import com.greenpineyu.fel.context.FelContext;
import java.util.List;

/**
 * 处理多个参数的函数处理
 *
 * @author tiankafei
 */
public abstract class BaseMoreOperation {

    /**
     * 执行处理多个参数的函数处理
     *
     * @param dataList 需要执行的参数列表
     * @param context  参数
     * @param location 当前函数的定位
     * @return
     * @throws Exception
     */
    public abstract Object evl(List<Object> dataList, FelContext context, int location) throws Exception;

}
