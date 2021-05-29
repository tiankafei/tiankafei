package org.tiankafei.aviator.runtime.function.special;

import com.googlecode.aviator.runtime.type.AviatorObject;
import java.util.Map;
import org.tiankafei.aviator.constant.AviatorConstants;
import org.tiankafei.aviator.runtime.function.other.MoreParamFunction;

/**
 * TODO
 * @author tiankafei
 */
public class Find extends MoreParamFunction {

    @Override
    public String getName() {
        return AviatorConstants.FUNCTION_FIND;
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
        return super.call(env, arg1, arg2);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3) {
        return super.call(env, arg1, arg2, arg3);
    }
}
