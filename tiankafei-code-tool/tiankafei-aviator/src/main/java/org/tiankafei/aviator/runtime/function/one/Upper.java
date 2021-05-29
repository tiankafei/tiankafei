package org.tiankafei.aviator.runtime.function.one;

import com.googlecode.aviator.runtime.type.AviatorNil;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorString;
import org.tiankafei.aviator.constant.AviatorConstants;

/**
 * @author tiankafei
 */
public class Upper extends OneParamFunction {

    @Override
    public String getName() {
        return AviatorConstants.FUNCTION_UPPER;
    }

    @Override
    protected AviatorObject apply(Object text) {
        if (text == null) {
            return AviatorNil.NIL;
        }
        return new AviatorString(text.toString().toUpperCase());
    }

}
