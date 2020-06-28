package org.tiankafei.aviator.extend.function;

import org.tiankafei.aviator.extend.constant.FunctionConstants;
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorNil;
import com.googlecode.aviator.runtime.type.AviatorObject;

/**
 * @Author 魏双双
 * @Date 2020/6/1
 * @Version V1.0
 **/
public class Not extends OneParamFunction {
    @Override
    protected AviatorObject apply(Object object) {
        if (object instanceof Boolean) {
            return AviatorBoolean.valueOf(!(Boolean) object);
        }
//        throw new AviatorException(getName() + "函数传入的数据类型错误，请确认！");
        return AviatorNil.NIL;
    }

    @Override
    public String getName() {
        return FunctionConstants.NOT;
    }
}