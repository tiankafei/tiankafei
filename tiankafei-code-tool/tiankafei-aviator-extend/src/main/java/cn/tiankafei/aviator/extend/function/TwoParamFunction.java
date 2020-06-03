package cn.tiankafei.aviator.extend.function;

import cn.tiankafei.aviator.extend.util.FunctionUtils;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Slf4j
public abstract class TwoParamFunction extends AbstractFunction {

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
        Object left = arg1.getValue(env);
        Object right = arg2.getValue(env);
        return this.apply(left, right);
    }

    protected AviatorObject apply(Object left, Object right) {
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
