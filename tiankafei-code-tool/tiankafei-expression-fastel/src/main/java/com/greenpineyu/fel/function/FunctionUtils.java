package com.greenpineyu.fel.function;

import com.greenpineyu.fel.Expression;
import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.parser.FelNode;

import java.util.List;

/**
 * @author tiankafei
 */
public class FunctionUtils {

    /**
     * 是字符串
     *
     * @param object
     * @return
     */
    public static Boolean isString(Object object) {
        Boolean flag = Boolean.FALSE;
        if (object instanceof CharSequence) {
            flag = Boolean.TRUE;
        } else if (object instanceof Character) {
            flag = Boolean.TRUE;
        }
        return flag;
    }

    /**
     * 字符串是否是数字
     *
     * @param object
     * @return
     */
    public static Boolean isNumerics(Object object) {
        if (object == null) {
            return Boolean.FALSE;
        }
        Boolean strResult = object.toString().matches("^[\\+\\-]?(0|[0-9]\\d*|[1-9]\\d*\\.\\d+|0\\.\\d+)");
        return strResult;
    }

    /**
     * 获取对象
     *
     * @param context
     * @param felNode
     * @return
     */
    public static Object getObject(FelContext context, Object felNode) throws Exception {
        Object object = BaseTolerantFunction.eval(context, felNode);
        if (object instanceof FelNode) {
            FelNode childNode = (FelNode) object;
            object = childNode.eval(context);
        }
        return object;
    }

    public static Object[] evalArgs(FelNode node, FelContext context) throws Exception {
        Object[] returnMe = null;
        List<FelNode> children = node.getChildren();
        if (children != null && children.size() > 0) {
            Object[] args = children.toArray();
            int size = args.length;
            returnMe = new Object[size];
            System.arraycopy(args, 0, returnMe, 0, size);
            for (int i = 0; i < size; i++) {
                Object child = args[i];
                if (child instanceof Expression) {
                    Expression childExp = ((Expression) child);
                    returnMe[i] = childExp.eval(context);
                }
            }
        }
        return returnMe;
    }

}
