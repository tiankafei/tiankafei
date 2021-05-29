package org.tiankafei.aviator.runtime.function.other;

import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import java.math.BigDecimal;
import java.util.List;
import org.tiankafei.aviator.constant.AviatorConstants;
import org.tiankafei.aviator.util.AviatorUtil;

/**
 * @author tiankafei
 */
public class Sum extends MoreParamFunction {

    @Override
    public String getName() {
        return AviatorConstants.FUNCTION_SUM;
    }

    @Override
    public AviatorObject apply(List<Object> valueList) {
        Double value = AviatorUtil.objectToDouble(valueList.get(0));
        BigDecimal result = new BigDecimal(value);

        for (int index = 1, length = valueList.size(); index < length; index++) {
            Double right = AviatorUtil.objectToDouble(valueList.get(index));
            if (value != null && right != null) {
                result = result.add(new BigDecimal(right));
            }
        }

        return AviatorRuntimeJavaType.valueOf(AviatorUtil.parseNumber(result.doubleValue()));
    }

}
