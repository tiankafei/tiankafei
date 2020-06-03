package cn.tiankafei.aviator.extend.function;

import cn.tiankafei.aviator.extend.constant.FunctionConstants;
import cn.tiankafei.aviator.extend.exception.AviatorException;
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorDecimal;
import com.googlecode.aviator.runtime.type.AviatorJavaType;
import com.googlecode.aviator.runtime.type.AviatorNil;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import com.googlecode.aviator.runtime.type.AviatorString;
import java.util.List;
import java.util.Map;

/**
 * @Author 魏双双
 * @Date 2020/6/2
 * @Version V1.0
 **/
public class If extends MoreParamFunction {
    @Override
    public String getName() {
        return FunctionConstants.IF;
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
        return super.call(env, arg1, arg2);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3) {
        return super.call(env, arg1, arg2, arg3);
    }

    @Override
    public AviatorObject apply(List<Object> dataList) {
        int number2 = 2;
        int number3 = 3;
        int length = dataList.size();
        if (length == number2 || length == number3) {
            Object value1 = dataList.get(0);
            if (value1 instanceof Boolean) {
                boolean flag = (boolean) value1;
                if (flag) {
                    Object value2 = dataList.get(1);
                    return AviatorRuntimeJavaType.valueOf(value2);
                } else {
                    if (length == number3) {
                        Object value3 = dataList.get(2);
                        return AviatorRuntimeJavaType.valueOf(value3);
                    }
                }
                return AviatorBoolean.TRUE;
            }
            throw new AviatorException(getName() + "参数类型不正确，请确认!");
        }
//        throw new AviatorException(getName() + "传入参数数组为空或者参数个数不正确!");
        return AviatorNil.NIL;
    }
}
