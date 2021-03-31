package org.tiankafei.aviator.extend.function;

import com.googlecode.aviator.lexer.token.OperatorType;
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;
import java.math.BigDecimal;

/**
 * @Author 魏双双
 * @Date 2020/6/2
 * @Version V1.0
 **/
public class Equals extends TwoParamFunction {

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

    @Override
    public String getName() {
        return OperatorType.EQ.token;
    }
}
