package com.greenpineyu.fel.interpreter;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.parser.FelNode;

/**
 * 解析器,用于解析AstNode的值
 *
 * @author yqs
 */
public interface Interpreter {

    /**
     * 执行解析
     *
     * @param context
     * @param node
     * @return
     */
    Object interpret(FelContext context, FelNode node) throws Exception;

}
