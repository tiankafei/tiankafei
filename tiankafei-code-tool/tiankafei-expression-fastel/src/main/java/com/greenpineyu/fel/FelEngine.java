package com.greenpineyu.fel;

import com.greenpineyu.fel.compile.CompileParamVo;
import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.Function;
import com.greenpineyu.fel.optimizer.Optimizer;
import com.greenpineyu.fel.parser.FelNode;
import com.greenpineyu.fel.parser.Parser;

/**
 * 表达式引擎
 *
 * @author yqs
 */
public interface FelEngine {

    /**
     * 默认实例
     */
    FelEngine INSTANCE = new FelEngineImpl();

    /**
     * 执行表达式，获取结果
     *
     * @param exp
     * @return
     */
    Object eval(String exp) throws Exception;

    /**
     * 使用指定的引擎上下文执行表达式，获取结果
     *
     * @param exp
     * @param ctx 引擎上下文
     * @return
     */
    Object eval(String exp, FelContext ctx) throws Exception;

    /**
     * 解析表达式为节点
     *
     * @param exp
     * @return
     */
    FelNode parse(String exp);

    /**
     * 获取解析器
     *
     * @return
     */
    Parser getParser();

    /**
     * 编译表达式
     *
     * @param exp
     * @param ctx
     * @param opts 编译优化选项
     * @return
     */
    Expression compile(String exp, FelContext ctx, Optimizer... opts) throws Exception;

    /**
     * 编译js表达式
     * @param exp
     * @param ctx
     * @param opts
     * @return
     * @throws Exception
     */
    String compileJs(String exp, FelContext ctx, Optimizer... opts) throws Exception;

    /**
     * 编译表达式
     *
     * @param exp
     * @param ctx
     * @param compileParamVo
     * @param opts
     * @return
     * @throws Exception
     */
    Expression compile(String exp, FelContext ctx, CompileParamVo compileParamVo, Optimizer... opts) throws Exception;

    String compileJs(String exp, FelContext ctx, CompileParamVo compileParamVo, Optimizer... opts) throws Exception ;

    /**
     * 获取引擎执行环境
     *
     * @return 引擎执行环境
     */
    FelContext getContext();

    /**
     * 添加函数到用户函数库中（执行表达式时，优先从用户函数库中获取函数）
     *
     * @param fun
     * @return
     */
    void addFun(Function fun);


    /**
     * 设置Context
     *
     * @param context
     */
    void setContext(FelContext context);

}
