package org.tiankafei.aviator.runtime.function.special;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.tiankafei.aviator.constant.AviatorConstants;
import org.tiankafei.aviator.util.AviatorUtil;

/**
 * @author tiankafei
 */
public class If extends AbstractFunction {

    @Override
    public String getName() {
        return AviatorConstants.FUNCTION_IF;
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
        return apply(Arrays.asList(arg1, arg2));
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3) {
        return apply(Arrays.asList(arg1, arg2, arg3));
    }

    protected AviatorObject apply(List<Object> valueList) {
        Object object = valueList.get(0);
        Boolean condition = AviatorUtil.toBooleanObj(object);
        if (condition) {
            return AviatorRuntimeJavaType.valueOf(valueList.get(1));
        } else {
            if (valueList.size() == 3) {
                return AviatorRuntimeJavaType.valueOf(valueList.get(2));
            } else {
                return AviatorBoolean.TRUE;
            }
        }
    }

}
