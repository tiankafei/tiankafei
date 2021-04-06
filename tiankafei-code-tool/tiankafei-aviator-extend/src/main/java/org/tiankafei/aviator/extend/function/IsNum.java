package org.tiankafei.aviator.extend.function;

import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;
import org.tiankafei.aviator.extend.constant.FunctionConstants;
import org.tiankafei.aviator.extend.util.FunctionUtils;

/**
 * @Author 魏双双
 * @Date 2020/6/1
 * @Version V1.0
 **/
public class IsNum extends OneParamFunction {
    @Override
    protected AviatorObject apply(Object object) {
        if (object != null) {
            if (object instanceof Number) {
                return AviatorBoolean.TRUE;
            } else if (FunctionUtils.isString(object)) {
                if (FunctionUtils.isNumerics(object)) {
                    return AviatorBoolean.TRUE;
                }
            }
        }
        return AviatorBoolean.FALSE;
    }

    @Override
    public String getName() {
        return FunctionConstants.IS_NUM;
    }
}
