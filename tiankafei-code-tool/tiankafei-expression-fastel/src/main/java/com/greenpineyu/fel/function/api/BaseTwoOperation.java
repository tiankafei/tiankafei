package com.greenpineyu.fel.function.api;

import com.greenpineyu.fel.function.FunctionUtils;

/**
 * @author tiankafei
 */
public abstract class BaseTwoOperation {

    /**
     * 执行运算
     *
     * @param left
     * @param right
     * @return
     */
    public Object evl(Object left, Object right) throws Exception {
        Object result = null;

        if (FunctionUtils.isString(left) && FunctionUtils.isString(right)) {
            result = evlAbnormalOperation(left, right);
        } else if (FunctionUtils.isString(left) && right instanceof Number) {
            if (FunctionUtils.isNumerics(left.toString())) {
                result = evlNormalOperation(left, right);
            } else {
                result = evlAbnormalOperation(left, right);
            }
        } else if (left instanceof Number && FunctionUtils.isString(right)) {
            if (FunctionUtils.isNumerics(right.toString())) {
                result = evlNormalOperation(left, right);
            } else {
                result = evlAbnormalOperation(left, right);
            }
        } else if (left instanceof Number && right instanceof Number) {
            result = evlNormalOperation(left, right);
        }

        return getReturnValue(result);
    }

    /**
     * 获取返回值
     *
     * @param object
     * @return
     */
    public Object getReturnValue(Object object) {
        return object;
    }

    /**
     * 执行正常运算
     *
     * @param left
     * @param right
     * @return
     * @throws Exception
     */
    public Object evlNormalOperation(Object left, Object right) throws Exception {
        return null;
    }

    /**
     * 执行异常运算
     *
     * @param left
     * @param right
     * @return
     * @throws Exception
     */
    public Object evlAbnormalOperation(Object left, Object right) throws Exception {
        return null;
    }

}
