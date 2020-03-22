package com.greenpineyu.fel.parser;

import com.greenpineyu.fel.function.FunMgr;

/**
 * 用于分析表达式
 *
 * @author yuqingsong
 */
public interface Parser {

    /**
     * 将表达式解析成节点
     *
     * @param exp
     * @return
     */
    FelNode parse(String exp);

    /**
     * 获取规则引擎方法管理类对象
     *
     * @return
     */
    public FunMgr getFunMgr();

}
