package com.greenpineyu.fel.context;

import com.greenpineyu.fel.common.Null;

/**
 * @author tiankafei
 */
public interface FelContext {


    Null NULL = new Null();

    /**
     * 获取变量值
     *
     * @param name 变量名称
     * @return 变量值，如果没有找到变量，返回FelContext.NOT_FOUND
     */
    Object get(String name);

    /**
     * 设置变量
     *
     * @param name  变量名称
     * @param value 变量值
     */
    void set(String name, Object value);

    /**
     * 获取参数
     *
     * @param name
     * @return
     */
    Var getVar(String name);

    /**
     * 设置参数
     *
     * @param var
     */
    void setVar(Var var);

    /**
     * 验证name的值是否存在
     *
     * @param name
     * @return
     */
    boolean existsKey(String name);

    /**
     * 清空属性
     */
    void clearValue();

}
