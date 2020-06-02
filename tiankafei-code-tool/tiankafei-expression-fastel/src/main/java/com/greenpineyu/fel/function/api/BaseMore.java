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
public abstract class BaseMore extends BaseStableFunction {

    @Override
    public Object call(FelNode node, FelContext context) throws Exception {
        List<FelNode> children = node.getChildren();
        if (children != null && !children.isEmpty()) {
            List<Object> programList = new ArrayList<Object>();
            for (int index = 0, length = children.size(); index < length; index++) {
                Object value = FunctionUtils.getObject(context, children.get(index));
                programList.add(value);
            }
            return OperationFactory.getBaseMoreOperation(getName()).evl(programList, context, node.getCharPositionInLine());
        }
        throw new AviatorException("传入参数数组为空或者参数个数不正确!");
    }

    @Override
    public FelMethod toMethod(FelNode node, FelContext ctx) throws Exception {
        List<FelNode> children = node.getChildren();
        if (children != null && !children.isEmpty()) {
            int currentStartIndex = node.getCharPositionInLine();
            StringBuilder stringBuilder = new StringBuilder();
            List<String> programList = new ArrayList<>();
            programList.add("List<Object> programList" + currentStartIndex + " = new ArrayList<Object>()");
            for (int index = 0, length = children.size(); index < length; index++) {
                FelNode felNode = children.get(index);
                SourceBuilder sourceBuilder = felNode.toMethod(ctx);
                if (sourceBuilder instanceof FelMethod) {
                    FelMethod felMethod = (FelMethod) sourceBuilder;
                    if (felMethod.getProgramList() != null) {
                        programList.addAll(felMethod.getProgramList());
                    }
                }
                String str = sourceBuilder.source(ctx, felNode);
                programList.add("Object object_" + currentStartIndex + "_" + index + " = " + str);
                programList.add("programList" + currentStartIndex + ".add(object_" + currentStartIndex + "_" + index + ")");
            }
            stringBuilder.append("OperationFactory.getBaseMoreOperation(\"").append(getName()).append("\").evl(programList" + currentStartIndex + ", context, ").append(currentStartIndex).append(")");
            FelMethod m = new FelMethod(stringBuilder.toString(), programList);
            return m;
        }
        throw new AviatorException("传入参数数组为空或者参数个数不正确!");
    }

    @Override
    public SourceBuilder toJsMethod(FelNode node, FelContext ctx) throws Exception {
        List<FelNode> children = node.getChildren();
        if (children != null && !children.isEmpty()) {
            int currentStartIndex = node.getCharPositionInLine();
            StringBuilder stringBuilder = new StringBuilder();
            List<String> programList = new ArrayList<>();
            programList.add("var programList" + currentStartIndex + " = []");
            for (int index = 0, length = children.size(); index < length; index++) {
                FelNode felNode = children.get(index);
                SourceBuilder sourceBuilder = felNode.toJsMethod(ctx);
                if (sourceBuilder instanceof FelMethod) {
                    FelMethod felMethod = (FelMethod) sourceBuilder;
                    if (felMethod.getProgramList() != null) {
                        programList.addAll(felMethod.getProgramList());
                    }
                }
                String str = sourceBuilder.source(ctx, felNode);
                programList.add("var object_" + currentStartIndex + "_" + index + " = " + str);
                programList.add("programList" + currentStartIndex + ".push(object_" + currentStartIndex + "_" + index + ")");
            }
            stringBuilder.append(getJsFunName().toUpperCase()).append("(programList" + currentStartIndex).append(")");
            FelMethod m = new FelMethod(stringBuilder.toString(), programList);
            return m;
        }
        throw new AviatorException("传入参数数组为空或者参数个数不正确!");
    }
}
