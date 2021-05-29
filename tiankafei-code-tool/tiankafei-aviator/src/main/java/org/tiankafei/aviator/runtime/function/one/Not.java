package org.tiankafei.aviator.runtime.function.one;

import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorNil;
import com.googlecode.aviator.runtime.type.AviatorObject;
import org.tiankafei.aviator.constant.AviatorConstants;

/**
 * @author tiankafei
 */
public class Not extends OneParamFunction {

    @Override
    public String getName() {
        return AviatorConstants.FUNCTION_NOT;
    }

    @Override
    protected AviatorObject apply(Object object) {
        if (object instanceof Boolean) {
            return AviatorBoolean.valueOf(!(Boolean) object);
        }
        return AviatorNil.NIL;
    }

}
