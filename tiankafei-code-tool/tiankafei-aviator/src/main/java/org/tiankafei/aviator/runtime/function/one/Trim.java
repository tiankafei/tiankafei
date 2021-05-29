package org.tiankafei.aviator.runtime.function.one;

import com.googlecode.aviator.runtime.type.AviatorNil;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorString;
import org.tiankafei.aviator.constant.AviatorConstants;

/**
 * @author tiankafei
 */
public class Trim extends OneParamFunction {

    @Override
    public String getName() {
        return AviatorConstants.FUNCTION_TRIM;
    }

    @Override
    protected AviatorObject apply(Object object) {
        if (object == null) {
            return AviatorNil.NIL;
        }
        return new AviatorString(object.toString().trim());
    }

}
