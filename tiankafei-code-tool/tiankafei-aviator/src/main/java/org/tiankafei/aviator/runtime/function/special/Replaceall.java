package org.tiankafei.aviator.runtime.function.special;

import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorString;
import java.util.Map;
import org.tiankafei.aviator.constant.AviatorConstants;

/**
 * @author tiankafei
 */
public class Replaceall extends SpecialFunction {

    @Override
    public String getName() {
        return AviatorConstants.FUNCTION_REPLACE_ALL;
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3) {
        Object value = getValue(env, arg1);
        Object regex = getValue(env, arg2);
        Object replacement = getValue(env, arg3);

        return new AviatorString(value.toString().replaceAll(regex.toString(), replacement.toString()));
    }

}
