package org.tiankafei.aviator.runtime.function.one;

import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import org.tiankafei.aviator.constant.AviatorConstants;
import org.tiankafei.aviator.util.AviatorUtil;

/**
 * @author Administrator
 */
public class ToLong extends OneParamFunction {

    @Override
    public String getName() {
        return AviatorConstants.FUNCTION_TO_LONG;
    }

    @Override
    protected AviatorObject apply(Object object) {
        Boolean numerics = AviatorUtil.isNumerics(object);
        if (numerics) {
            return AviatorRuntimeJavaType.valueOf(Long.valueOf(object.toString()));
        }
        return AviatorRuntimeJavaType.valueOf(0L);
    }

}
