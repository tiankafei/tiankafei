package com.greenpineyu.fel.security;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * @author tiankafei
 */
public interface ReflectMgr {

    /**
     * 是否允许访问某个方法
     *
     * @param m
     * @return
     */
    boolean isCallable(Method m);

    /**
     * 添加可访问的方法
     *
     * @param m
     */
    void addCallableMethod(Method m);

    /**
     * 删除
     *
     * @param m
     */
    void removeCallableMethod(Method m);

    /**
     * 添加不可访问的方法
     *
     * @param m
     */
    void addUncallableMethod(Method m);

    /**
     * 删除
     *
     * @param m
     */
    void removeUncallableMethod(Method m);

    /**
     * 获取
     *
     * @return
     */
    Set<Method> getCallableMethods();

    /**
     * 获取
     *
     * @return
     */
    Set<Method> getUnCallableMethods();

}
