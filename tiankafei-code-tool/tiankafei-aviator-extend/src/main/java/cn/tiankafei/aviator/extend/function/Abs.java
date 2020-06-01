package cn.tiankafei.aviator.extend.function;

import cn.tiankafei.aviator.extend.exception.AviatorException;
import cn.tiankafei.aviator.extend.util.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDecimal;
import com.googlecode.aviator.runtime.type.AviatorObject;
import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author 魏双双
 * @Date 2020/6/1
 * @Version V1.0
 **/
@Slf4j
public class Abs extends OneParamFunction {
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
            Object value = Math.abs(bigDecimal.doubleValue());
            return AviatorDecimal.valueOf(NumberUtil.parseNumber(value.toString()));
        }
        throw new AviatorException("abs函数的参数不能是非数字，请确认！");
    }

    @Override
    public String getName() {
        return "abs";
    }
}
