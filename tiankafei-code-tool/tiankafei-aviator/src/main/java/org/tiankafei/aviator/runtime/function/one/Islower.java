package org.tiankafei.aviator.runtime.function.one;

import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;
import org.tiankafei.aviator.constant.AviatorConstants;

/**
 * @author tiankafei
 */
public class Islower extends OneParamFunction {

    @Override
    public String getName() {
        return AviatorConstants.FUNCTION_ISLOWER;
    }

    @Override
    protected AviatorObject apply(Object text) {
        if (text == null) {
            return AviatorBoolean.FALSE;
        }
        String str = text.toString();
        if (str.toLowerCase().equals(str)) {
            return AviatorBoolean.TRUE;
        } else {
            return AviatorBoolean.FALSE;
        }
    }

}
