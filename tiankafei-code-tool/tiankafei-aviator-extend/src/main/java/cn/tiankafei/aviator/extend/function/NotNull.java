package cn.tiankafei.aviator.extend.function;

import cn.tiankafei.aviator.extend.constant.FunctionConstants;
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author 魏双双
 * @Date 2020/6/1
 * @Version V1.0
 **/
public class NotNull extends OneParamFunction {
    @Override
    protected AviatorObject apply(Object object) {
        if (object != null) {
            if (StringUtils.isNotBlank(object.toString())) {
                return AviatorBoolean.TRUE;
            }
        }
        return AviatorBoolean.FALSE;
    }

    @Override
    public String getName() {
        return FunctionConstants.NOT_NULL;
    }
}
