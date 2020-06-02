package cn.tiankafei.aviator.extend.function;

import cn.tiankafei.aviator.extend.constant.FunctionConstants;
import cn.tiankafei.aviator.extend.util.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;

/**
 * @Author 魏双双
 * @Date 2020/6/1
 * @Version V1.0
 **/
public class IsNumber extends OneParamFunction {
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
        return FunctionConstants.IS_NUMBER;
    }
}
