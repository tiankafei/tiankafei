package org.tiankafei.aviator.extend.function;

import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;
import org.tiankafei.aviator.extend.constant.FunctionConstants;

/**
 * @Author 魏双双
 * @Date 2020/6/1
 * @Version V1.0
 **/
public class Isupper extends OneParamFunction {
    @Override
    protected AviatorObject apply(Object text) {
        if (text == null) {
            return AviatorBoolean.FALSE;
        }
        String str = text.toString();
        if (str.toUpperCase().equals(str)) {
            return AviatorBoolean.TRUE;
        } else {
            return AviatorBoolean.FALSE;
        }
    }

    @Override
    public String getName() {
        return FunctionConstants.ISUPPER;
    }
}
