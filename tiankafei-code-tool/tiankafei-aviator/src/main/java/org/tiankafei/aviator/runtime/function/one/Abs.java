package org.tiankafei.aviator.runtime.function.one;

import cn.hutool.core.util.NumberUtil;
import com.googlecode.aviator.runtime.type.AviatorDecimal;
import com.googlecode.aviator.runtime.type.AviatorNil;
import com.googlecode.aviator.runtime.type.AviatorObject;
import java.math.BigDecimal;
import org.tiankafei.aviator.constant.AviatorConstants;
import org.tiankafei.aviator.util.AviatorUtil;

/**
 * 绝对值
 *
 * @author tiankafei
 */
public class Abs extends OneParamFunction {

    @Override
    public String getName() {
        return AviatorConstants.FUNCTION_ABS;
    }

    @Override
    protected AviatorObject apply(Object object) {
        BigDecimal bigDecimal = null;
        if (object instanceof Number) {
            bigDecimal = new BigDecimal(object.toString());
        } else if (AviatorUtil.isString(object)) {
            if (AviatorUtil.isNumerics(object)) {
                bigDecimal = new BigDecimal(object.toString());
            }
        }
        if (bigDecimal != null) {
            Object value = Math.abs(bigDecimal.doubleValue());
            return AviatorDecimal.valueOf(NumberUtil.parseNumber(value.toString()));
        }
        return AviatorNil.NIL;
    }

}
