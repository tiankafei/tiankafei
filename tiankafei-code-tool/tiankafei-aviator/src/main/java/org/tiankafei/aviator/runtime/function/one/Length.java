package org.tiankafei.aviator.runtime.function.one;

import com.googlecode.aviator.runtime.type.AviatorDecimal;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import org.tiankafei.aviator.constant.AviatorConstants;

/**
 * @author tiankafei
 */
public class Length extends OneParamFunction {

    @Override
    public String getName() {
        return AviatorConstants.FUNCTION_LENGTH;
    }

    @Override
    protected AviatorObject apply(Object param) {
        if (param == null) {
            return AviatorDecimal.valueOf(0);
        }
        return AviatorRuntimeJavaType.valueOf(param.toString().length());
    }

}
