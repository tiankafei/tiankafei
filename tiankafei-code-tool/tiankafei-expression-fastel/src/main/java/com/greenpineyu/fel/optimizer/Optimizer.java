package com.greenpineyu.fel.optimizer;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.parser.FelNode;

/**
 * 优化器
 *
 * @author yuqingsong
 */
public interface Optimizer {

    /**
     * 执行优化
     *
     * @param ctx
     * @param node
     * @return
     */
    FelNode call(FelContext ctx, FelNode node) throws Exception;
}
