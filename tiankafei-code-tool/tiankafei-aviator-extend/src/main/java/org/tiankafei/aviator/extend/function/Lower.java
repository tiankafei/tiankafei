package org.tiankafei.aviator.extend.function;

import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorString;
import org.tiankafei.aviator.extend.constant.FunctionConstants;

/**
 * @Author 魏双双
 * @Date 2020/6/1
 * @Version V1.0
 **/
public class Lower extends OneParamFunction {
    @Override
    protected AviatorObject apply(Object text) {
        if (text == null) {
            return AviatorBoolean.FALSE;
        }
        return new AviatorString(text.toString().toLowerCase());
    }

    @Override
    public String getName() {
        return FunctionConstants.LOWER;
    }
}
