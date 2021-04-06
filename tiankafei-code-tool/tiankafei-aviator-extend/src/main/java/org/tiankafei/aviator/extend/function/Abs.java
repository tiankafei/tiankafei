package org.tiankafei.aviator.extend.function;

import com.googlecode.aviator.runtime.type.AviatorDecimal;
import com.googlecode.aviator.runtime.type.AviatorNil;
import com.googlecode.aviator.runtime.type.AviatorObject;
import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;
import org.tiankafei.aviator.extend.constant.FunctionConstants;
import org.tiankafei.aviator.extend.util.FunctionUtils;
import org.tiankafei.aviator.extend.util.NumberUtil;

/**
 * @Author 魏双双
 * @Date 2020/6/1
 * @Version V1.0
 **/
@Slf4j
public class Abs extends OneParamFunction {
    @Override
    protected AviatorObject apply(Object object) {
        BigDecimal bigDecimal = null;
        if (object instanceof Number) {
            bigDecimal = new BigDecimal(object.toString());
        } else if (FunctionUtils.isString(object)) {
            if (FunctionUtils.isNumerics(object)) {
                bigDecimal = new BigDecimal(object.toString());
            }
        }
        if (bigDecimal != null) {
            Object value = Math.abs(bigDecimal.doubleValue());
            return AviatorDecimal.valueOf(NumberUtil.parseNumber(value.toString()));
        }
        return AviatorNil.NIL;
    }

    @Override
    public String getName() {
        return FunctionConstants.ABS;
    }
}
