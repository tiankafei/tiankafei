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
public class IsNum extends OneParamFunction {
    @Override
    protected AviatorObject apply(Object object) {
        Boolean result = Boolean.FALSE;
        if (object != null) {
            if (object instanceof Number) {
                result = Boolean.TRUE;
            } else if (FunctionUtils.isString(object)) {
                if (FunctionUtils.isNumerics(object)) {
                    result = Boolean.TRUE;
                }
            }
        }
        return AviatorBoolean.valueOf(result);
    }

    @Override
    public String getName() {
        return FunctionConstants.IS_NUM;
    }
}
