package org.tiankafei.aviator.runtime.function.one;

import com.googlecode.aviator.runtime.type.AviatorNil;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import java.math.BigDecimal;
import org.tiankafei.aviator.constant.AviatorConstants;
import org.tiankafei.aviator.util.AviatorUtil;

/**
 * @author tiankafei
 */
public class Trunc extends OneParamFunction {

    @Override
    public String getName() {
        return AviatorConstants.FUNCTION_TRUNC;
    }

    @Override
    protected AviatorObject apply(Object object) {
        BigDecimal bigDecimal = null;
        if (object instanceof Number) {
            bigDecimal = new BigDecimal(object.toString());
        } else if (AviatorUtil.isString(object)) {
            if (AviatorUtil.isNumerics(object)) {
                bigDecimal = new BigDecimal(object.toString());
            }
        }
        if (bigDecimal != null) {
            Object value = Math.floor(bigDecimal.doubleValue());
            return AviatorRuntimeJavaType.valueOf(AviatorUtil.parseNumber(value.toString()));
        }
        return AviatorNil.NIL;
    }

}
