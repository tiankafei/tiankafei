package cn.tiankafei.aviator.extend.function;

import cn.tiankafei.aviator.extend.constant.FunctionConstants;
import cn.tiankafei.aviator.extend.util.FunctionUtils;
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
        }else{
            boolean result = false;
            if (FunctionUtils.isString(left) && FunctionUtils.isString(right)) {
                result = evlAbnormalOperation(left, right);
            } else if (FunctionUtils.isString(left) && right instanceof Number) {
                if (FunctionUtils.isNumerics(left.toString())) {
                    result = evlNormalOperation(left, right);
                } else {
                    result = evlAbnormalOperation(left, right);
                }
            } else if (left instanceof Number && FunctionUtils.isString(right)) {
                if (FunctionUtils.isNumerics(right.toString())) {
                    result = evlNormalOperation(left, right);
                } else {
                    result = evlAbnormalOperation(left, right);
                }
            } else if (left instanceof Number && right instanceof Number) {
                result = evlNormalOperation(left, right);
            }
            return AviatorBoolean.valueOf(result);
        }
    }

    public boolean evlNormalOperation(Object left, Object right) {
        BigDecimal leftBigDecimal = new BigDecimal(left.toString());
        BigDecimal rightBigDecimal = new BigDecimal(right.toString());
        return leftBigDecimal.doubleValue() == rightBigDecimal.doubleValue();
    }

    public boolean evlAbnormalOperation(Object left, Object right) {
        return left.toString().equals(right.toString());
    }

    @Override
    public String getName() {
        return FunctionConstants.EQUALS_STR;
    }
}
