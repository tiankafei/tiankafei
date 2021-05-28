package org.tiankafei.aviator.runtime.function.two;

import cn.hutool.core.util.NumberUtil;
import com.googlecode.aviator.runtime.type.AviatorNil;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;
import org.tiankafei.aviator.constant.AviatorConstants;
import org.tiankafei.aviator.util.AviatorUtil;

/**
 * 乘法函数
 * @author tiankafei
 */
@Slf4j
public class Mul extends TwoParamFunction {

    @Override
    public String getName() {
        return AviatorConstants.FUNCTION_MUL;
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
        return leftBigDecimal.multiply(rightBigDecimal).doubleValue();
    }

    @Override
    public Object evlAbnormalOperation(Object left, Object right) {
        if (AviatorUtil.isNumerics(left.toString()) && AviatorUtil.isNumerics(right.toString())) {
            return evlNormalOperation(left, right);
        } else {
            log.error("文本字符串不能参与乘法运算！");
            return AviatorNil.NIL;
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
