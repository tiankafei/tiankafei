package org.tiankafei.aviator.runtime.function.one;

import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import org.tiankafei.aviator.constant.AviatorConstants;

/**
 * @author Administrator
 */
public class ToBoolean extends OneParamFunction {

    @Override
    public String getName() {
        return AviatorConstants.FUNCTION_TO_BOOLEAN;
    }

    @Override
    protected AviatorObject apply(Object object) {
        if (object != null) {
            return AviatorRuntimeJavaType.valueOf(Boolean.valueOf(object.toString()));
        }
        return AviatorRuntimeJavaType.valueOf(Boolean.FALSE);
    }

}
