package com.greenpineyu.fel.compile;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.optimizer.Optimizer;
import com.greenpineyu.fel.parser.FelNode;

/**
 * @author tiankafei
 */
public interface SourceGenerator {

    /**
     * 获取表达式JAVA源代码
     *
     * @param ctx
     * @param node
     * @return
     */
    JavaSource getSource(FelContext ctx, FelNode node, CompileParamVo compileParamVo) throws Exception;

    /**
     * 添加优化器
     *
     * @param opti
     */
    void addOpti(Optimizer opti);


}
