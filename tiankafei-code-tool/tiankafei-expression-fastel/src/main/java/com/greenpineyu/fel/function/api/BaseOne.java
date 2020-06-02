package com.greenpineyu.fel.function.api;

import com.greenpineyu.fel.compile.FelMethod;
import com.greenpineyu.fel.compile.SourceBuilder;
import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.BaseStableFunction;
import com.greenpineyu.fel.function.FunctionUtils;
import com.greenpineyu.fel.function.OperationFactory;
import com.greenpineyu.fel.parser.FelNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tiankafei
 */
public abstract class BaseOne extends BaseStableFunction {

    @Override
    public Object call(FelNode node, FelContext context) throws Exception {
        List<FelNode> children = node.getChildren();
        if (children != null && children.size() == 1) {
            Object value = FunctionUtils.getObject(context, children.get(0));
            return OperationFactory.getBaseOneOperation(getName()).evl(value, context, node.getTokenStartIndex());
        }
        throw new NullPointerException("传入参数数组为空或者参数个数不正确!");
    }

    @Override
    public FelMethod toMethod(FelNode node, FelContext ctx) throws Exception {
        List<FelNode> children = node.getChildren();
        if (children.size() == 1) {
            int currentStartIndex = node.getCharPositionInLine();
            StringBuilder stringBuilder = new StringBuilder();
            List<String> programList = new ArrayList<>();
            programList.add("List<Object> programList" + currentStartIndex + " = new ArrayList<Object>()");

            FelNode felNode = children.get(0);
            SourceBuilder sourceBuilder = felNode.toMethod(ctx);
            if (sourceBuilder instanceof FelMethod) {
                FelMethod felMethod = (FelMethod) sourceBuilder;
                if (felMethod.getProgramList() != null) {
                    programList.addAll(felMethod.getProgramList());
                }
            }
            String str = sourceBuilder.source(ctx, felNode);
            programList.add("Object object_" + currentStartIndex + "_" + 0 + " = " + str);
            programList.add("programList" + currentStartIndex + ".add(object_" + currentStartIndex + "_" + 0 + ")");

            stringBuilder.append("OperationFactory.getBaseOneOperation(\"").append(getName()).append("\").evl(").append(str).append(", context, ").append(node.getCharPositionInLine()).append(")");

            FelMethod m = new FelMethod(stringBuilder.toString(), programList);
            return m;
        }
        throw new NullPointerException("传入参数数组为空或者参数个数不正确!");
    }

    @Override
    public SourceBuilder toJsMethod(FelNode node, FelContext ctx) throws Exception {
        List<FelNode> children = node.getChildren();
        if (children.size() == 1) {
            int currentStartIndex = node.getCharPositionInLine();
            StringBuilder stringBuilder = new StringBuilder();
            List<String> programList = new ArrayList<>();
            programList.add("var programList" + currentStartIndex + " = []");

            FelNode felNode = children.get(0);
            SourceBuilder sourceBuilder = felNode.toJsMethod(ctx);
            if (sourceBuilder instanceof FelMethod) {
                FelMethod felMethod = (FelMethod) sourceBuilder;
                if (felMethod.getProgramList() != null) {
                    programList.addAll(felMethod.getProgramList());
                }
            }
            String str = sourceBuilder.source(ctx, felNode);
            programList.add("var object_" + currentStartIndex + "_" + 0 + " = " + str);
            programList.add("programList" + currentStartIndex + ".push(object_" + currentStartIndex + "_" + 0 + ")");

            stringBuilder.append(getJsFunName().toUpperCase()).append("(").append(str).append(")");

            FelMethod m = new FelMethod(stringBuilder.toString(), programList);
            return m;
        }
        throw new NullPointerException("传入参数数组为空或者参数个数不正确!");
    }
}
