package com.greenpineyu.fel.parser;

import com.greenpineyu.fel.Expression;
import com.greenpineyu.fel.compile.SourceBuilder;
import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.interpreter.Interpreter;
import org.antlr.runtime.tree.Tree;

import java.util.List;

/**
 * 解析后的节点，组成表达式的元素都会被解析成节点。
 *
 * @author yqs
 */
public interface FelNode extends Expression, Tree, Stable {

    /**
     * 获取子节点
     *
     * @return
     */
    List<FelNode> getChildren();

    /**
     * 重置解释器
     *
     * @return
     */
    void resetInterpreter();

    /**
     * 节点中的解释器是否默认的解释器
     *
     * @return
     */
    boolean isDefaultInterpreter();

    /**
     * 获取解析器,用于解析AstNode的值
     *
     * @return 解析器, 用于解析AstNode的值
     */
    Interpreter getInterpreter();

    /**
     * 设置解析器,用于解析AstNode的值
     *
     * @param interpreter 解析器,用于解析AstNode的值
     */
    void setInterpreter(Interpreter interpreter);

    /**
     * 设置创建java源码接口
     *
     * @param builder 创建java源码接口
     */
    void setSourcebuilder(SourceBuilder builder);

    /**
     * 编译执行逻辑
     *
     * @param ctx
     * @return
     */
    SourceBuilder toMethod(FelContext ctx) throws Exception;


}
