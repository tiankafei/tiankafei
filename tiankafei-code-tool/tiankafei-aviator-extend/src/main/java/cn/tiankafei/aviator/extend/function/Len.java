package cn.tiankafei.aviator.extend.function;

import cn.tiankafei.aviator.extend.constant.FunctionConstants;
import com.googlecode.aviator.runtime.type.AviatorDecimal;
import com.googlecode.aviator.runtime.type.AviatorObject;

/**
 * @Author 魏双双
 * @Date 2020/6/1
 * @Version V1.0
 **/
public class Len extends OneParamFunction {
    @Override
    protected AviatorObject apply(Object param) {
        if (param == null) {
            return AviatorDecimal.valueOf(0);
        }
        return AviatorDecimal.valueOf(param.toString().length());
    }

    @Override
    public String getName() {
        return FunctionConstants.LEN;
    }
}
