package org.tiankafei.aviator.runtime.function.two;

import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import org.tiankafei.aviator.constant.AviatorConstants;
import org.tiankafei.aviator.util.AviatorUtil;

public class Right extends TwoParamFunction {

    @Override
    public String getName() {
        return AviatorConstants.FUNCTION_RIGHT;
    }

    @Override
    protected AviatorObject apply(Object value1, Object value2) {
        if (value1 == null) {
            return AviatorRuntimeJavaType.valueOf("");
        }
        String value = value1.toString();
        if (value2 == null) {
            return AviatorRuntimeJavaType.valueOf(value);
        } else {
            int maxLength = value.length();
            int start = maxLength;
            if (AviatorUtil.isNumerics(value2)) {
                start = Integer.valueOf(value2.toString());
                if (start > maxLength) {
                    start = maxLength;
                }
            }
            return AviatorRuntimeJavaType.valueOf(value.substring(maxLength - start));
        }
    }

}
