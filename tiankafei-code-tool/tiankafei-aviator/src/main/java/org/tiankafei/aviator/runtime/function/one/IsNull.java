package org.tiankafei.aviator.runtime.function.one;

import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.aviator.constant.AviatorConstants;

/**
 * @author tiankafei
 */
public class IsNull extends OneParamFunction {

    @Override
    public String getName() {
        return AviatorConstants.FUNCTION_IS_NULL;
    }

    @Override
    protected AviatorObject apply(Object object) {
        if (object == null) {
            return AviatorBoolean.TRUE;
        } else {
            if (StringUtils.isBlank(object.toString())) {
                return AviatorBoolean.TRUE;
            }
        }
        return AviatorBoolean.FALSE;
    }

}
