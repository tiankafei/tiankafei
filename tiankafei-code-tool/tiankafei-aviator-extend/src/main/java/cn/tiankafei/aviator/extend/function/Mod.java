package cn.tiankafei.aviator.extend.function;

import cn.tiankafei.aviator.extend.exception.AviatorException;
import cn.tiankafei.aviator.extend.util.FunctionUtils;
import cn.tiankafei.aviator.extend.util.NumberUtil;
import com.googlecode.aviator.lexer.token.OperatorType;

import java.math.BigDecimal;

/**
 * @Author 魏双双
 * @Date 2020/6/2
 * @Version V1.0
 **/
public class Mod extends TwoParamFunction {

    @Override
    public String getName() {
        return OperatorType.MOD.token;
    }

    @Override
    public Object evlNormalOperation(Object left, Object right) {
        BigDecimal leftBigDecimal = new BigDecimal(left.toString());
        BigDecimal rightBigDecimal = new BigDecimal(right.toString());
        if (rightBigDecimal.doubleValue() == 0.0) {
            throw new AviatorException("求余运算被除数不能为0！");
        }
        return leftBigDecimal.divideAndRemainder(rightBigDecimal)[1].doubleValue();
    }

    @Override
    public Object evlAbnormalOperation(Object left, Object right) {
        if (FunctionUtils.isNumerics(left.toString()) && FunctionUtils.isNumerics(right.toString())) {
            return evlNormalOperation(left, right);
        } else {
            throw new AviatorException("文本字符串不能参与求余数运算！");
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
