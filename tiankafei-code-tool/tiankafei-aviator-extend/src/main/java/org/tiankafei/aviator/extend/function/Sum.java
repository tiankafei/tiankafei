package org.tiankafei.aviator.extend.function;

import org.tiankafei.aviator.extend.constant.FunctionConstants;
import org.tiankafei.aviator.extend.util.FunctionUtils;
import org.tiankafei.aviator.extend.util.NumberUtil;
import com.googlecode.aviator.runtime.type.AviatorDecimal;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author 魏双双
 * @Date 2020/6/2
 * @Version V1.0
 **/
public class Sum extends MoreParamFunction {
    @Override
    public String getName() {
        return FunctionConstants.SUM;
    }

    @Override
    public AviatorObject apply(List<Object> dataList) {
        Object result = 0;
        for (int index = 1, length = dataList.size(); index < length; index++) {
            Object right = dataList.get(index);
            result = evl(result, right);
        }
        return AviatorDecimal.valueOf(result);
    }

    private Object evl(Object left, Object right) {
        Object result = null;

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

        return getReturnValue(result);
    }

    private Object evlNormalOperation(Object left, Object right) {
        BigDecimal leftBigDecimal = new BigDecimal(left.toString());
        BigDecimal rightBigDecimal = new BigDecimal(right.toString());
        return leftBigDecimal.add(rightBigDecimal).doubleValue();
    }

    private Object evlAbnormalOperation(Object left, Object right) {
        return left.toString() + right.toString();
    }

    private Object getReturnValue(Object object) {
        if (object instanceof Number) {
            object = NumberUtil.parseNumber(object.toString());
        }
        return object;
    }

}
