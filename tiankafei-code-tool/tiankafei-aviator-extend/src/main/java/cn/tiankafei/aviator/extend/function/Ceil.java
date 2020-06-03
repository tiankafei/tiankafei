package cn.tiankafei.aviator.extend.function;

import cn.tiankafei.aviator.extend.constant.FunctionConstants;
import cn.tiankafei.aviator.extend.exception.AviatorException;
import cn.tiankafei.aviator.extend.util.FunctionUtils;
import cn.tiankafei.aviator.extend.util.NumberUtil;
import com.googlecode.aviator.runtime.type.AviatorDecimal;
import com.googlecode.aviator.runtime.type.AviatorNil;
import com.googlecode.aviator.runtime.type.AviatorObject;
import java.math.BigDecimal;

/**
 * @Author 魏双双
 * @Date 2020/6/1
 * @Version V1.0
 **/
public class Ceil extends OneParamFunction {
    @Override
    protected AviatorObject apply(Object object) {
        BigDecimal bigDecimal = null;
        if (object instanceof Number) {
            bigDecimal = new BigDecimal(object.toString());
        } else if (FunctionUtils.isString(object)) {
            if (FunctionUtils.isNumerics(object)) {
                bigDecimal = new BigDecimal(object.toString());
            }
        }
        if (bigDecimal != null) {
            Object value = Math.ceil(bigDecimal.doubleValue());
            return AviatorDecimal.valueOf(NumberUtil.parseNumber(value.toString()));
        }
//        throw new AviatorException(getName() + "函数传入的数据类型错误，请确认！");
        return AviatorNil.NIL;
    }

    @Override
    public String getName() {
        return FunctionConstants.CEIL;
    }
}
