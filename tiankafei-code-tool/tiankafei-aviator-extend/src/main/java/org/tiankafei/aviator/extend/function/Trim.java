package org.tiankafei.aviator.extend.function;

import org.tiankafei.aviator.extend.constant.FunctionConstants;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorString;

/**
 * @Author 魏双双
 * @Date 2020/6/1
 * @Version V1.0
 **/
public class Trim extends OneParamFunction {
    @Override
    protected AviatorObject apply(Object object) {
        if (object == null) {
            return new AviatorString("");
        }
        return new AviatorString(object.toString().trim());
    }

    @Override
    public String getName() {
        return FunctionConstants.TRIM;
    }
}
