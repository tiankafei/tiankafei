package org.tiankafei.aviator.runtime.function.two;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import java.util.Map;
import org.tiankafei.aviator.util.AviatorUtil;

/**
 * @author tiankafei
 */
public abstract class TwoParamFunction extends AbstractFunction {

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
        Object left = arg1.getValue(env);
        Object right = arg2.getValue(env);
        return this.apply(left, right);
    }

    protected AviatorObject apply(Object left, Object right) {
        Object result = null;

        if (AviatorUtil.isString(left) && AviatorUtil.isString(right)) {
            result = evlAbnormalOperation(left, right);
        } else if (AviatorUtil.isString(left) && right instanceof Number) {
            if (AviatorUtil.isNumerics(left.toString())) {
                result = evlNormalOperation(left, right);
            } else {
                result = evlAbnormalOperation(left, right);
            }
        } else if (left instanceof Number && AviatorUtil.isString(right)) {
            if (AviatorUtil.isNumerics(right.toString())) {
                result = evlNormalOperation(left, right);
            } else {
                result = evlAbnormalOperation(left, right);
            }
        } else if (left instanceof Number && right instanceof Number) {
            result = evlNormalOperation(left, right);
        } else if (left instanceof Boolean && right instanceof Boolean) {
            result = evlAbnormalOperation(left, right);
        }

        return AviatorRuntimeJavaType.valueOf(getReturnValue(result));
    }

    /**
     * 获取返回值
     *
     * @param object
     * @return
     */
    protected Object getReturnValue(Object object) {
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
    protected Object evlNormalOperation(Object left, Object right) {
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
    protected Object evlAbnormalOperation(Object left, Object right) {
        return null;
    }

}
