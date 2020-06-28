package org.tiankafei.aviator.extend.function;

import org.tiankafei.aviator.extend.constant.FunctionConstants;
import org.tiankafei.aviator.extend.exception.AviatorException;
import org.tiankafei.aviator.extend.util.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorString;

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
            return new AviatorString("");
        }
        Integer count = null;
        if (value2 == null) {
            return new AviatorString(value1.toString());
        } else {
            if (FunctionUtils.isString(value2)) {
                if (FunctionUtils.isNumerics(value2.toString())) {
                    count = Integer.valueOf(value2.toString());
                } else {
                    throw new AviatorException(getName() + "函数截取的位置数据类型不正确，请确认!");
                }
            } else if (value2 instanceof Number) {
                count = Integer.valueOf(value2.toString());
            }
        }
        if (count != null) {
            String value = value1.toString();
            if (count > value.length()) {
                count = value.length();
            }
            return new AviatorString(value.substring(0, count));
        }
        throw new AviatorException(getName() + "传入参数数组为空或者参数个数不正确!");
    }
}
