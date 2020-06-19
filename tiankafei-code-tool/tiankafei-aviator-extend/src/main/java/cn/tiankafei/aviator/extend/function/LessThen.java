package cn.tiankafei.aviator.extend.function;

import cn.tiankafei.aviator.extend.util.FunctionUtils;
import com.googlecode.aviator.lexer.token.OperatorType;

import java.math.BigDecimal;

/**
 * @Author 魏双双
 * @Date 2020/6/2
 * @Version V1.0
 **/
public class LessThen extends TwoParamFunction {

    @Override
    public String getName() {
        return OperatorType.LT.token;
    }

    @Override
    public Object evlNormalOperation(Object left, Object right) {
        BigDecimal leftBigDecimal = new BigDecimal(left.toString());
        BigDecimal rightBigDecimal = new BigDecimal(right.toString());
        return leftBigDecimal.doubleValue() < rightBigDecimal.doubleValue();
    }

    @Override
    public Object evlAbnormalOperation(Object left, Object right) {
        if (FunctionUtils.isNumerics(left.toString()) && FunctionUtils.isNumerics(right.toString())) {
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
