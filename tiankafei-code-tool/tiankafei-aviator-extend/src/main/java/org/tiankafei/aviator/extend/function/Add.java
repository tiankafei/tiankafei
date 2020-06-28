package org.tiankafei.aviator.extend.function;

import org.tiankafei.aviator.extend.util.NumberUtil;
import com.googlecode.aviator.lexer.token.OperatorType;

import java.math.BigDecimal;

/**
 * @Author 魏双双
 * @Date 2020/6/2
 * @Version V1.0
 **/
public class Add extends TwoParamFunction {

    @Override
    public String getName() {
        return OperatorType.ADD.token;
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
            object = NumberUtil.parseNumber(object.toString());
        }
        return object;
    }
}
