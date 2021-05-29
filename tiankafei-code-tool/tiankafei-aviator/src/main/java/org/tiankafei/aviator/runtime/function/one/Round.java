package org.tiankafei.aviator.runtime.function.one;

import com.googlecode.aviator.runtime.type.AviatorNil;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import org.tiankafei.aviator.constant.AviatorConstants;
import org.tiankafei.aviator.util.AviatorUtil;

/**
 * @author tiankafei
 */
public class Round extends OneParamFunction {

    @Override
    public String getName() {
        return AviatorConstants.FUNCTION_ROUND;
    }

    @Override
    protected AviatorObject apply(Object param) {
        double result = 0;
        if (param == null) {
            return AviatorNil.NIL;
        }
        Double value = null;
        if (param instanceof Number) {
            value = Double.parseDouble(param.toString());
        } else if (AviatorUtil.isString(param)) {
            if (AviatorUtil.isNumerics(param)) {
                value = Double.parseDouble(param.toString());
            }
        }
        if (value != null) {
            return AviatorRuntimeJavaType.valueOf(Math.round(value));
        }
        return AviatorNil.NIL;
    }

}
