package org.tiankafei.aviator.runtime.function.two;

import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import org.tiankafei.aviator.constant.AviatorConstants;
import org.tiankafei.aviator.util.AviatorUtil;

/**
 * 截取位置从1开始
 *
 * @author tiankafei
 */
public class Left extends TwoParamFunction {

    @Override
    public String getName() {
        return AviatorConstants.FUNCTION_LEFT;
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
            int start = 1;
            if (AviatorUtil.isNumerics(value2)) {
                start = Integer.valueOf(value2.toString());
                if (start < 1) {
                    start = 1;
                }
            }
            return AviatorRuntimeJavaType.valueOf(value.substring(start - 1));
        }
    }

}
