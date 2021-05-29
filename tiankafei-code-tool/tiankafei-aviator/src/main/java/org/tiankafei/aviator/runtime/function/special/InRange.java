package org.tiankafei.aviator.runtime.function.special;

import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;
import java.math.BigDecimal;
import java.util.Map;
import org.tiankafei.aviator.constant.AviatorConstants;
import org.tiankafei.aviator.util.AviatorUtil;

/**
 * @author tiankafei
 */
public class InRange extends SpecialFunction {

    @Override
    public String getName() {
        return AviatorConstants.FUNCTION_IN_RANGE;
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3) {
        Object value = getValue(env, arg1);
        Object start = getValue(env, arg2);
        Object end = getValue(env, arg3);

        if (AviatorUtil.isString(value) || AviatorUtil.isString(start) || AviatorUtil.isString(end)) {
            if (AviatorUtil.isNumerics(value.toString())
                    && AviatorUtil.isNumerics(start.toString())
                    && AviatorUtil.isNumerics(end.toString())) {
                // 全部是数字字符串时
                BigDecimal v = new BigDecimal(value.toString());
                BigDecimal s = new BigDecimal(start.toString());
                BigDecimal e = new BigDecimal(end.toString());
                return AviatorBoolean.valueOf(v.doubleValue() >= s.doubleValue() && (v.doubleValue() <= e.doubleValue()));
            } else {
                //部分为数字时，走字符串的比较
                String strText = value.toString();
                String strBeginTxt = start.toString();
                String strEndTxt = end.toString();
                return AviatorBoolean.valueOf((strText).compareTo(strBeginTxt) >= 0 && (strText).compareTo(strEndTxt) <= 0);
            }
        } else if (value instanceof Number && start instanceof Number && end instanceof Number) {
            BigDecimal v = new BigDecimal(value.toString());
            BigDecimal s = new BigDecimal(start.toString());
            BigDecimal e = new BigDecimal(end.toString());
            return AviatorBoolean.valueOf(v.doubleValue() >= s.doubleValue() && (v.doubleValue() <= e.doubleValue()));
        }
        return AviatorBoolean.FALSE;
    }

}
