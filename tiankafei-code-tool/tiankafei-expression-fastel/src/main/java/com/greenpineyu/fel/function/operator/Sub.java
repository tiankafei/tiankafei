package com.greenpineyu.fel.function.operator;

import com.greenpineyu.fel.compile.FelMethod;
import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.FunctionUtils;
import com.greenpineyu.fel.function.OperationFactory;
import com.greenpineyu.fel.function.api.BaseTwo;
import com.greenpineyu.fel.parser.ConstNode;
import com.greenpineyu.fel.parser.FelNode;

import java.util.List;

/**
 * @author tiankafei
 */
public class Sub extends BaseTwo {

    @Override
    public String getName() {
        return FunctionConstants.SUB;
    }

    @Override
    public Object call(FelNode node, FelContext context) throws Exception {
        List<FelNode> children = node.getChildren();
        int number = 2;
        if (children != null) {
            FelNode leftFelNode = children.get(0);
            if (children.size() == number) {
                Object left = FunctionUtils.getObject(context, leftFelNode);
                Object right = FunctionUtils.getObject(context, children.get(1));
                return OperationFactory.getBaseOperation(getName()).evl(left, right);
            } else if (children.size() == 1) {
                if (leftFelNode instanceof ConstNode) {
                    ConstNode constNode = (ConstNode) leftFelNode;
                    StringBuilder stringBuilder = new StringBuilder("-").append(constNode.eval(context));
                    return stringBuilder.toString();
                }
            }
        }
        throw new NullPointerException("传入参数数组为空或者参数个数不正确!");
    }

    @Override
    public FelMethod toMethod(FelNode node, FelContext ctx) throws Exception {
        List<FelNode> children = node.getChildren();
        if (children != null) {
            int number = 2;
            if (children.size() == number) {
                return super.toMethod(node, ctx);
            } else if (children.size() == 1) {
                FelNode felNode = children.get(0);
                if (felNode instanceof ConstNode) {
                    ConstNode constNode = (ConstNode) felNode;
                    StringBuilder stringBuilder = new StringBuilder("-").append(constNode.eval(ctx));
                    FelMethod m = new FelMethod(stringBuilder.toString());
                    return m;
                }
            }
        }
        throw new NullPointerException("传入参数数组为空或者参数个数不正确!");
    }

}
