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
 * @author tiankafei
 */
@Slf4j
public class Div extends TwoParamFunction {

    @Override
    public String getName() {
        return AviatorConstants.FUNCTION_DIV;
    }

    @Override
    protected AviatorObject apply(Object left, Object right) {
        if (left == null && right == null) {
            return AviatorNil.NIL;
        } else if (left == null) {
            return AviatorNil.NIL;
        } else if (right == null) {
            if (AviatorUtil.isNumerics(left)) {
                return AviatorRuntimeJavaType.valueOf(left);
            } else {
                return AviatorNil.NIL;
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
            log.info("除法运算被除数不能为0！");
            return AviatorNil.NIL;
        }
        return leftBigDecimal.divide(rightBigDecimal, 20, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    @Override
    public Object evlAbnormalOperation(Object left, Object right) {
        if (AviatorUtil.isNumerics(left.toString()) && AviatorUtil.isNumerics(right.toString())) {
            return evlNormalOperation(left, right);
        } else {
            log.error("文本字符串不能参与除法运算！");
            return AviatorNil.NIL;
        }
    }

    @Override
    public Object getReturnValue(Object object) {
        if (object instanceof Number) {
            object = AviatorUtil.parseNumber(object.toString());
        }
        return object;
    }

}
