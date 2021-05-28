package org.tiankafei.aviator.runtime.function.two;

import com.googlecode.aviator.runtime.type.AviatorObject;
import java.math.BigDecimal;
import org.tiankafei.aviator.constant.AviatorConstants;
import org.tiankafei.aviator.util.AviatorUtil;

/**
 * @author tiankafei
 */
public class LessThen extends TwoParamFunction {

    @Override
    public String getName() {
        return AviatorConstants.FUNCTION_LESS_THEN;
    }

    @Override
    protected AviatorObject apply(Object left, Object right) {
        if (left == null) {
            left = "";
        }
        if (right == null) {
            right = "";
        }
        return super.apply(left, right);
    }

    @Override
    public Object evlNormalOperation(Object left, Object right) {
        BigDecimal leftBigDecimal = new BigDecimal(left.toString());
        BigDecimal rightBigDecimal = new BigDecimal(right.toString());
        return leftBigDecimal.doubleValue() < rightBigDecimal.doubleValue();
    }

    @Override
    public Object evlAbnormalOperation(Object left, Object right) {
        if (AviatorUtil.isNumerics(left.toString()) && AviatorUtil.isNumerics(right.toString())) {
            return evlNormalOperation(left, right);
        } else {
            return compareTo(left, right) < 0;
        }
    }

    /**
     * 执行字符串比较
     *
     * @param left
     * @param right
     * @return
     */
    protected static int compareTo(Object left, Object right) {
        return left.toString().compareTo(right.toString());
    }

}
