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
public class Left extends TwoParamFunction {

    @Override
    public String getName() {
        return FunctionConstants.LEFT;
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
            if(FunctionUtils.isNumerics(value2)){
                start = Integer.valueOf(value2.toString());
                if(start < 1){
                    start = 1;
                }
            }
            return AviatorRuntimeJavaType.valueOf(value.substring(start - 1));
        }
    }
}
