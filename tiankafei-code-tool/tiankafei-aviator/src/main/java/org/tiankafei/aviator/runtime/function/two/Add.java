package org.tiankafei.aviator.runtime.function.two;

import com.googlecode.aviator.runtime.type.AviatorNil;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import java.math.BigDecimal;
import org.tiankafei.aviator.constant.AviatorConstants;
import org.tiankafei.aviator.util.AviatorUtil;

/**
 * @author tiankafei
 */
public class Add extends TwoParamFunction {

    @Override
    public String getName() {
        return AviatorConstants.FUNCTION_ADD;
    }

    @Override
    protected AviatorObject apply(Object left, Object right) {
        if (left == null && right == null) {
            return AviatorNil.NIL;
        } else if (left == null) {
            return AviatorRuntimeJavaType.valueOf(right);
        } else if (right == null) {
            return AviatorRuntimeJavaType.valueOf(left);
        } else {
            return super.apply(left, right);
        }
    }

    @Override
    public Object evlNormalOperation(Object left, Object right) {
        BigDecimal leftBigDecimal = new BigDecimal(left.toString());
        BigDecimal rightBigDecimal = new BigDecimal(right.toString());
        return leftBigDecimal.add(rightBigDecimal).doubleValue();
    }

    @Override
    public Object evlAbnormalOperation(Object left, Object right) {
        return left.toString() + right.toString();
    }

    @Override
    public Object getReturnValue(Object object) {
        if (object instanceof Number) {
            object = AviatorUtil.parseNumber(object.toString());
        }
        return object;
    }

}
