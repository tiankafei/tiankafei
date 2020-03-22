package com.greenpineyu.fel.common;

/**
 * 可调用接口
 *
 * @param <R> 参数返回值
 * @param <P> 参数类型
 * @author yuqingsong
 */
public interface Callable<R, P> {

    /**
     * 执行调用
     *
     * @param arg
     * @return
     */
    R call(P... arg);

}
