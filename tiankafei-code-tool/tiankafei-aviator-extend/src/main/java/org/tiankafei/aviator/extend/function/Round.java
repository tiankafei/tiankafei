package org.tiankafei.aviator.extend.function;

import com.googlecode.aviator.runtime.type.AviatorDecimal;
import com.googlecode.aviator.runtime.type.AviatorNil;
import com.googlecode.aviator.runtime.type.AviatorObject;
import org.tiankafei.aviator.extend.constant.FunctionConstants;
import org.tiankafei.aviator.extend.util.FunctionUtils;

/**
 * @Author 魏双双
 * @Date 2020/6/1
 * @Version V1.0
 **/
public class Round extends OneParamFunction {
    @Override
    protected AviatorObject apply(Object param) {
        double result = 0;
        if (param == null) {
            return AviatorDecimal.valueOf(result);
        }
        Double value = null;
        if (param instanceof Number) {
            value = Double.parseDouble(param.toString());
        } else if (FunctionUtils.isString(param)) {
            if (FunctionUtils.isNumerics(param)) {
                value = Double.parseDouble(param.toString());
            }
        }
        if (value != null) {
            return AviatorDecimal.valueOf(Math.round(value));
        }
        return AviatorNil.NIL;
    }

    @Override
    public String getName() {
        return FunctionConstants.ROUND;
    }
}
