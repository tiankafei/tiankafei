package com.greenpineyu.fel.function.operator;

import com.greenpineyu.fel.function.FunctionUtils;

import java.util.List;

import com.greenpineyu.fel.compile.SourceBuilder;
import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.BaseStableFunction;
import com.greenpineyu.fel.parser.FelNode;

/**
 * 取反操作符
 *
 * @author tiankafei
 */
public class NotOper extends BaseStableFunction {

    @Override
    public Object call(FelNode node, FelContext context) throws Exception {
        List<FelNode> children = node.getChildren();
        Object eval = FunctionUtils.getObject(context, children.get(0));
        if (eval != null && eval instanceof Boolean) {
            return !(Boolean) eval;
        }
        return null;
    }

    @Override
    public String getName() {
        return "!";
    }

    @Override
    public String getJsFunName() {
        return "RULE_NOT";
    }

    @Override
    public SourceBuilder toMethod(FelNode node, FelContext ctx) {
        return new SourceBuilder() {

            @Override
            public String source(FelContext ctx, FelNode node) throws Exception {
                List<FelNode> children = node.getChildren();
                FelNode child = children.get(0);
                String src = "";
                SourceBuilder builder = child.toMethod(ctx);
                Class<?> returnType = builder.returnType(ctx, child);
                if (boolean.class.isAssignableFrom(returnType) || Boolean.class.isAssignableFrom(returnType)) {
                    src = "!(" + builder.source(ctx, child) + ")";
                } else {
                    throw new NullPointerException("抛出编译异常!");
                }
                return src;
            }

            @Override
            public String sourceJs(FelContext ctx, FelNode node) throws Exception {
                return null;
            }

            @Override
            public Class<?> returnType(FelContext ctx, FelNode node) {
                return Boolean.class;
            }
        };
    }

    @Override
    public SourceBuilder toJsMethod(FelNode node, FelContext ctx) throws Exception {
        return new SourceBuilder() {

            @Override
            public String source(FelContext ctx, FelNode node) throws Exception {
                return null;
            }

            @Override
            public String sourceJs(FelContext ctx, FelNode node) throws Exception {
                List<FelNode> children = node.getChildren();
                FelNode child = children.get(0);
                String src = "";
                SourceBuilder builder = child.toMethod(ctx);
                Class<?> returnType = builder.returnType(ctx, child);
                if (boolean.class.isAssignableFrom(returnType) || Boolean.class.isAssignableFrom(returnType)) {
                    src = "!(" + builder.source(ctx, child) + ")";
                } else {
                    throw new NullPointerException("抛出编译异常!");
                }
                return src;
            }

            @Override
            public Class<?> returnType(FelContext ctx, FelNode node) {
                return Boolean.class;
            }
        };
    }
}
