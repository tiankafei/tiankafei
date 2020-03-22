package com.greenpineyu.fel.function;

import com.greenpineyu.fel.compile.SourceBuilder;
import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.parser.FelNode;

/**
 * @author tiankafei
 * @uml.dependency supplier=".script.context.ScriptContext"
 */
public interface Function {

    /**
     * 获取函数的名称
     *
     * @return
     */
    String getName();

    /**
     * 调用函数
     *
     * @param node
     * @param context
     * @return
     */
    Object call(FelNode node, FelContext context) throws Exception;


    /**
     * 编译执行
     *
     * @param node
     * @param ctx
     * @return
     */
    SourceBuilder toMethod(FelNode node, FelContext ctx) throws Exception;


}
