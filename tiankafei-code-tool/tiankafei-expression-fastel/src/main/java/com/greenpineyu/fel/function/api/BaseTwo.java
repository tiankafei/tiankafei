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
 * @author 魏双双
 */
public abstract class BaseTwo extends BaseStableFunction {

    @Override
    public Object call(FelNode node, FelContext context) throws Exception {
        List<FelNode> children = node.getChildren();
        int number = 2;
        if (children != null && children.size() == number) {
            Object left = FunctionUtils.getObject(context, children.get(0));
            Object right = FunctionUtils.getObject(context, children.get(1));

            return OperationFactory.getBaseOperation(getName()).evl(left, right);
        }
        throw new NullPointerException("传入参数数组为空或者参数个数不正确!");
    }

    @Override
    public FelMethod toMethod(FelNode node, FelContext ctx) throws Exception {
        List<FelNode> children = node.getChildren();
        int number = 2;
        if (children.size() == number) {
            int currentStartIndex = node.getCharPositionInLine();
            StringBuilder stringBuilder = new StringBuilder();
            List<String> programList = new ArrayList<>();
            programList.add("List<Object> programList" + currentStartIndex + " = new ArrayList<Object>()");

            FelNode leftFelNode = children.get(0);
            SourceBuilder left = leftFelNode.toMethod(ctx);
            if (left instanceof FelMethod) {
                FelMethod felMethod = (FelMethod) left;
                if (felMethod.getProgramList() != null) {
                    programList.addAll(felMethod.getProgramList());
                }
            }
            String leftStr = left.source(ctx, leftFelNode);
            programList.add("Object object_" + currentStartIndex + "_" + 0 + " = " + leftStr);
            programList.add("programList" + currentStartIndex + ".add(object_" + currentStartIndex + "_" + 0 + ")");


            FelNode rightFelNode = children.get(1);
            SourceBuilder right = rightFelNode.toMethod(ctx);
            if (right instanceof FelMethod) {
                FelMethod felMethod = (FelMethod) right;
                if (felMethod.getProgramList() != null) {
                    programList.addAll(felMethod.getProgramList());
                }
            }
            String rightStr = right.source(ctx, rightFelNode);
            programList.add("Object object_" + currentStartIndex + "_" + 1 + " = " + rightStr);
            programList.add("programList" + currentStartIndex + ".add(object_" + currentStartIndex + "_" + 1 + ")");

            stringBuilder.append("OperationFactory.getBaseOperation(\"").append(getName()).append("\").evl(").append(leftStr).append(", ").append(rightStr).append(")");
            FelMethod m = new FelMethod(stringBuilder.toString(), programList);
            return m;
        }
        throw new NullPointerException("传入参数数组为空或者参数个数不正确!");
    }

    @Override
    public SourceBuilder toJsMethod(FelNode node, FelContext ctx) throws Exception {
        List<FelNode> children = node.getChildren();
        int number = 2;
        if (children.size() == number) {
            int currentStartIndex = node.getCharPositionInLine();
            StringBuilder stringBuilder = new StringBuilder();
            List<String> programList = new ArrayList<>();
            programList.add("var programList" + currentStartIndex + " = []");

            FelNode leftFelNode = children.get(0);
            SourceBuilder left = leftFelNode.toJsMethod(ctx);
            if (left instanceof FelMethod) {
                FelMethod felMethod = (FelMethod) left;
                if (felMethod.getProgramList() != null) {
                    programList.addAll(felMethod.getProgramList());
                }
            }
            String leftStr = left.sourceJs(ctx, leftFelNode);
            programList.add("var object_" + currentStartIndex + "_" + 0 + " = " + leftStr);
            programList.add("programList" + currentStartIndex + ".push(object_" + currentStartIndex + "_" + 0 + ")");

            FelNode rightFelNode = children.get(1);
            SourceBuilder right = rightFelNode.toJsMethod(ctx);
            if (right instanceof FelMethod) {
                FelMethod felMethod = (FelMethod) right;
                if (felMethod.getProgramList() != null) {
                    programList.addAll(felMethod.getProgramList());
                }
            }
            String rightStr = right.sourceJs(ctx, rightFelNode);
            programList.add("var object_" + currentStartIndex + "_" + 1 + " = " + rightStr);
            programList.add("programList" + currentStartIndex + ".push(object_" + currentStartIndex + "_" + 1 + ")");

            stringBuilder.append(getJsFunName().toUpperCase()).append("(").append(leftStr).append(", ").append(rightStr).append(")");
            FelMethod m = new FelMethod(stringBuilder.toString(), programList);
            return m;
        }
        throw new NullPointerException("传入参数数组为空或者参数个数不正确!");
    }

}