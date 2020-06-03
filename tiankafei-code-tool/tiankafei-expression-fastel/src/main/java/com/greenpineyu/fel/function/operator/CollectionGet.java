package com.greenpineyu.fel.function.operator;

import com.greenpineyu.fel.compile.FelMethod;
import com.greenpineyu.fel.compile.InterpreterSourceBuilder;
import com.greenpineyu.fel.compile.SourceBuilder;
import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.BaseStableFunction;
import com.greenpineyu.fel.function.FunctionUtils;
import com.greenpineyu.fel.parser.FelNode;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 根据索引获取某个集合的值,相当于List.get(i)方法和array[i]方法。 用于处理array[i],list[i]等表达式，
 * 同时也可以处理支持实现了iterator的类，如Set。
 *
 * @author yuqingsong
 */
public class CollectionGet extends BaseStableFunction {

    @Override
    public Object call(FelNode node, FelContext context) throws Exception {
        int number = 2;
        if (node.getChildCount() >= number) {
            Object coll = FunctionUtils.getObject(context, node.getChild(0));
            Object index = FunctionUtils.getObject(context, node.getChild(1));
            int i = 0;
            if (index instanceof Number) {
                i = ((Number) index).intValue();
            }
            return get(coll, i);
        }
//        return null;
        throw new NullPointerException("语法错误!");
    }

    @Override
    public String getName() {
        return "[";
    }

    @Override
    public SourceBuilder toMethod(FelNode node, FelContext ctx) throws Exception {
        Class<?> type = null;
        List<FelNode> children = node.getChildren();
        FelNode left = children.get(0);
        SourceBuilder leftMethod = left.toMethod(ctx);
        Class<?> leftType = leftMethod.returnType(ctx, left);

        if (!leftType.isArray() && !List.class.isAssignableFrom(leftType)) {
            // 不是数组，也不是list,直接生成 使用与解释执行相同的代码
            return InterpreterSourceBuilder.getInstance();
        }
        FelNode right = children.get(1);
        SourceBuilder rightMethod = right.toMethod(ctx);
        Class<?> rightType = rightMethod.returnType(ctx, right);

        String leftSrc = leftMethod.source(ctx, left);
        String rightSrc = getRightSrc(ctx, right, rightMethod, rightType);
        String src = "";
        if (leftType.isArray()) {
            // 获取数组内容
            type = leftType.getComponentType();
            src = "(" + leftSrc + ")[" + rightSrc + "]";
        } else if (List.class.isAssignableFrom(leftType)) {
            type = Object.class;
            src = "(" + leftSrc + ").get(" + rightSrc + ")";
        }
        return new FelMethod(type, src);
    }

    @Override
    public SourceBuilder toJsMethod(FelNode node, FelContext ctx) throws Exception {
        return null;
    }

    /**
     * 获取索引的java代码，如果索引不是int类型，要转换成int类型
     *
     * @param ctx
     * @param right       索引对应的节点
     * @param rightMethod
     * @param rightType
     * @return
     */
    private String getRightSrc(FelContext ctx, FelNode right,
                               SourceBuilder rightMethod, Class<?> rightType) throws Exception {
        String rightSrc = "";
        Class<?>[] cls = new Class<?>[]{Integer.class, Short.class,
                Character.class, Byte.class, int.class, short.class,
                char.class, byte.class};
        boolean isInt = false;
        for (int i = 0; i < cls.length; i++) {
            if (cls[i].isAssignableFrom(rightType)) {
                isInt = true;
                break;
            }
        }
        if (isInt) {
            // 可以直接转换成int类型，可以直接使用
            rightSrc = rightMethod.source(ctx, right);
        } else if (Number.class.isAssignableFrom(rightType)) {
            rightSrc = "(" + rightMethod.source(ctx, right) + ").intValue()";
        }
        return rightSrc;
    }

    public static Object get(Object object, int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative: "
                    + index);
        }
        if (object instanceof Map<?, ?>) {
            Map<?, ?> map = (Map<?, ?>) object;
            Iterator<?> iterator = map.entrySet().iterator();
            return get(iterator, index);
        } else if (object instanceof List<?>) {
            return ((List<?>) object).get(index);
        } else if (object instanceof Object[]) {
            return ((Object[]) object)[index];
        } else if (object instanceof Iterator<?>) {
            Iterator<?> it = (Iterator<?>) object;
            while (it.hasNext()) {
                index--;
                if (index == -1) {
                    return it.next();
                } else {
                    it.next();
                }
            }
            throw new IndexOutOfBoundsException("Entry does not exist: "
                    + index);
        } else if (object instanceof Collection<?>) {
            Iterator<?> iterator = ((Collection<?>) object).iterator();
            return get(iterator, index);
        } else if (object instanceof Enumeration<?>) {
            Enumeration<?> it = (Enumeration<?>) object;
            while (it.hasMoreElements()) {
                index--;
                if (index == -1) {
                    return it.nextElement();
                } else {
                    it.nextElement();
                }
            }
            throw new IndexOutOfBoundsException("Entry does not exist: "
                    + index);
        } else if (object == null) {
            throw new IllegalArgumentException("Unsupported object type: null");
        } else {
            try {
                return Array.get(object, index);
            } catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException("Unsupported object type: "
                        + object.getClass().getName());
            }
        }
    }

}
