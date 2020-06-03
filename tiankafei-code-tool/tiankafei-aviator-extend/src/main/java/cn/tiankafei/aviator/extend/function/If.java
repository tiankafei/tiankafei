package cn.tiankafei.aviator.extend.function;

import cn.tiankafei.aviator.extend.constant.FunctionConstants;
import cn.tiankafei.aviator.extend.exception.AviatorException;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author 魏双双
 * @Date 2020/6/2
 * @Version V1.0
 **/
public class If extends AbstractFunction {

    @Override
    public String getName() {
        return FunctionConstants.IF;
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
        return this.call(env, Arrays.asList(arg1, arg2));
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3) {
        return this.call(env, Arrays.asList(arg1, arg2, arg3));
    }

    protected AviatorObject call(Map<String, Object> env, List<AviatorObject> valueList) {
        List<Object> dataList = new ArrayList<>();
        for (int index = 0, length = valueList.size(); index < length; index++) {
            AviatorObject aviatorObject = valueList.get(index);
            dataList.add(aviatorObject.getValue(env));
        }
        Object value1 = dataList.get(0);
        if (value1 instanceof Boolean) {
            boolean flag = (boolean) value1;
            if (flag) {
                Object value2 = dataList.get(1);
                return AviatorRuntimeJavaType.valueOf(value2);
            } else {
                if (dataList.size() == 3) {
                    Object value3 = dataList.get(2);
                    return AviatorRuntimeJavaType.valueOf(value3);
                }
            }
            return AviatorBoolean.TRUE;
        }
        throw new AviatorException(getName() + "参数类型不正确，请确认!");
    }
}
