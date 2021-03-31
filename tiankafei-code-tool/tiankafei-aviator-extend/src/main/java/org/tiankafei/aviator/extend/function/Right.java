package org.tiankafei.aviator.extend.function;

import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import org.tiankafei.aviator.extend.constant.FunctionConstants;
import org.tiankafei.aviator.extend.util.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorObject;

/**
 * @Author 魏双双
 * @Date 2020/6/2
 * @Version V1.0
 **/
public class Right extends TwoParamFunction {

    @Override
    public String getName() {
        return FunctionConstants.RIGHT;
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
            if(FunctionUtils.isNumerics(value2)){
                start = Integer.valueOf(value2.toString());
                if(start > maxLength){
                    start = maxLength;
                }
            }
            return AviatorRuntimeJavaType.valueOf(value.substring(maxLength - start));
        }
    }
}
