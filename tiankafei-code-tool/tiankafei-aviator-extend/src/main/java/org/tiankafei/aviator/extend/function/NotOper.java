package org.tiankafei.aviator.extend.function;

import com.googlecode.aviator.lexer.token.OperatorType;
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorNil;
import com.googlecode.aviator.runtime.type.AviatorObject;

/**
 * @Author 魏双双
 * @Date 2020/6/1
 * @Version V1.0
 **/
public class NotOper extends OneParamFunction {
    @Override
    protected AviatorObject apply(Object object) {
        if (object instanceof Boolean) {
            return AviatorBoolean.valueOf(!(Boolean) object);
        }
        return AviatorNil.NIL;
    }

    @Override
    public String getName() {
        return OperatorType.NOT.token;
    }
}
