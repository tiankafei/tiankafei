package org.tiankafei.aviator.runtime.function.one;

import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;
import org.tiankafei.aviator.constant.AviatorConstants;
import org.tiankafei.aviator.util.AviatorUtil;

/**
 * @author tiankafei
 */
public class IsNumber extends OneParamFunction {

    @Override
    public String getName() {
        return AviatorConstants.FUNCTION_IS_NUMBER;
    }

    @Override
    protected AviatorObject apply(Object object) {
        if (object != null) {
            if (object instanceof Number) {
                return AviatorBoolean.TRUE;
            } else if (AviatorUtil.isString(object)) {
                if (AviatorUtil.isNumerics(object)) {
                    return AviatorBoolean.TRUE;
                }
            }
        }
        return AviatorBoolean.FALSE;
    }

}
