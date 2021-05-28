package org.tiankafei.aviator.runtime.function.two;

import java.math.BigDecimal;
import org.tiankafei.aviator.constant.AviatorConstants;
import org.tiankafei.aviator.util.AviatorUtil;

/**
 * @author tiankafei
 */
public class GreaterThenEquals extends LessThen {

    @Override
    public String getName() {
        return AviatorConstants.FUNCTION_GREATER_THEN_EQUALS;
    }

    @Override
    public Object evlNormalOperation(Object left, Object right) {
        BigDecimal leftBigDecimal = new BigDecimal(left.toString());
        BigDecimal rightBigDecimal = new BigDecimal(right.toString());
        return leftBigDecimal.doubleValue() >= rightBigDecimal.doubleValue();
    }

    @Override
    public Object evlAbnormalOperation(Object left, Object right) {
        if (AviatorUtil.isNumerics(left.toString()) && AviatorUtil.isNumerics(right.toString())) {
            return evlNormalOperation(left, right);
        } else {
            return compareTo(left, right) >= 0;
        }
    }

}
