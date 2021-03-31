package org.tiankafei.aviator.extend.function;

import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import org.tiankafei.aviator.extend.exception.AviatorException;
import org.tiankafei.aviator.extend.util.FunctionUtils;
import org.tiankafei.aviator.extend.util.NumberUtil;
import com.googlecode.aviator.lexer.token.OperatorType;

import java.math.BigDecimal;

/**
 * @Author 魏双双
 * @Date 2020/6/2
 * @Version V1.0
 **/
public class Div extends TwoParamFunction {

    @Override
    public String getName() {
        return OperatorType.DIV.token;
    }

    @Override
    protected AviatorObject apply(Object left, Object right) {
        if (left == null && right == null) {
            return AviatorRuntimeJavaType.valueOf(null);
        } else if (left == null) {
            return AviatorRuntimeJavaType.valueOf(null);
        } else if (right == null) {
            if (FunctionUtils.isNumerics(left)) {
                return AviatorRuntimeJavaType.valueOf(left);
            } else {
                return AviatorRuntimeJavaType.valueOf(null);
            }
        } else {
            return super.apply(left, right);
        }
    }

    @Override
    public Object evlNormalOperation(Object left, Object right) {
        BigDecimal leftBigDecimal = new BigDecimal(left.toString());
        BigDecimal rightBigDecimal = new BigDecimal(right.toString());
        if (rightBigDecimal.doubleValue() == 0.0) {
            throw new AviatorException("除法运算被除数不能为0！");
        }
        return leftBigDecimal.divide(rightBigDecimal, 20, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    @Override
    public Object evlAbnormalOperation(Object left, Object right) {
        if (FunctionUtils.isNumerics(left.toString()) && FunctionUtils.isNumerics(right.toString())) {
            return evlNormalOperation(left, right);
        } else {
            return AviatorRuntimeJavaType.valueOf(null);
        }
    }

    @Override
    public Object getReturnValue(Object object) {
        if (object instanceof Number) {
            object = NumberUtil.parseNumber(object.toString());
        }
        return object;
    }
}
