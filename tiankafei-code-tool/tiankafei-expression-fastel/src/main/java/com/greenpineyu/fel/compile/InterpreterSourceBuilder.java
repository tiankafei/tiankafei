package com.greenpineyu.fel.compile;

import com.greenpineyu.fel.context.AbstractContext;
import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.interpreter.Interpreter;
import com.greenpineyu.fel.parser.FelNode;

/**
 * @author tiankafei
 */
public class InterpreterSourceBuilder implements SourceBuilder {


    private static final SourceBuilder INSTANCE;

    public static SourceBuilder getInstance() {
        return INSTANCE;
    }

    static {
        INSTANCE = new InterpreterSourceBuilder();
    }


    @Override
    public Class<?> returnType(FelContext ctx, FelNode node) throws Exception {
        return AbstractContext.getVarType(node.getInterpreter().interpret(ctx, node));
    }

    /**
     * 用户自定义解析器生成的java代码
     *
     * @param ctx
     * @param node
     * @return
     */
    @Override
    public String source(FelContext ctx, FelNode node) throws Exception {
        // 用户设置了解释器
        Interpreter inte = node.getInterpreter();
        SourceBuilder nodeBuilder = node.toMethod(ctx);
        Class<?> type = nodeBuilder.returnType(ctx, node);
        String code = "(" + type.getName() + ")";
        String varName = VarBuffer.push(inte, Interpreter.class);
        String nodeVarName = VarBuffer.push(node, FelNode.class);
        code += varName + ".interpret(context," + nodeVarName + ")";
        boolean isNumber = Number.class.isAssignableFrom(type);
        if (isNumber) {
            code = "(" + code + ").doubleValue()";
        }
        return code;
    }

    @Override
    public String sourceJs(FelContext ctx, FelNode node) throws Exception {
        return null;
    }

}
