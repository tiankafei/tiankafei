package cn.tiankafei.aviator.extend.function;

import cn.tiankafei.aviator.extend.constant.FunctionConstants;
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;

/**
 * @Author 魏双双
 * @Date 2020/6/1
 * @Version V1.0
 **/
public class Islower extends OneParamFunction {
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

    @Override
    public String getName() {
        return FunctionConstants.ISLOWER;
    }
}
