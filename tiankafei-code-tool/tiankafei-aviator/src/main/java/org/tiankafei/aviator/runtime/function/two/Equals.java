package org.tiankafei.aviator.runtime.function.two;

import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;
import java.math.BigDecimal;
import org.tiankafei.aviator.constant.AviatorConstants;

/**
 * @author tiankafei
 */
public class Equals extends TwoParamFunction {

    @Override
    public String getName() {
        return AviatorConstants.FUNCTION_EQUALS;
    }

    @Override
    protected AviatorObject apply(Object left, Object right) {
        if (left == null && right == null) {
            return AviatorBoolean.TRUE;
        } else if (left == null || right == null) {
            return AviatorBoolean.FALSE;
        }

        return super.apply(left, right);
    }

    @Override
    public Object evlNormalOperation(Object left, Object right) {
        BigDecimal leftBigDecimal = new BigDecimal(left.toString());
        BigDecimal rightBigDecimal = new BigDecimal(right.toString());
        return leftBigDecimal.doubleValue() == rightBigDecimal.doubleValue();
    }

    @Override
    public Object evlAbnormalOperation(Object left, Object right) {
        return left.toString().equals(right.toString());
    }

}
