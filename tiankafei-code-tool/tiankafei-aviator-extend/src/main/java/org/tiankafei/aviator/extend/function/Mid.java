package org.tiankafei.aviator.extend.function;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.tiankafei.aviator.extend.constant.FunctionConstants;
import org.tiankafei.aviator.extend.exception.AviatorException;
import org.tiankafei.aviator.extend.util.FunctionUtils;

/**
 * @Author 魏双双
 * @Date 2020/6/2
 * @Version V1.0
 **/
public class Mid extends AbstractFunction {

    @Override
    public String getName() {
        return FunctionConstants.MID;
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
        if (value1 == null) {
            return new AviatorString("");
        }

        Integer start = null;
        Object value2 = dataList.get(1);
        if (value2 == null) {
            throw new AviatorException(getName() + "函数截取的起始位置为空，请确认!");
        } else {
            if (FunctionUtils.isString(value2)) {
                if (FunctionUtils.isNumerics(value2.toString())) {
                    start = Integer.valueOf(value2.toString());
                } else {
                    throw new AviatorException(getName() + "函数截取的起始位置数据类型不正确，请确认!");
                }
            } else if (value2 instanceof Number) {
                start = Integer.valueOf(value2.toString());
            }
        }

        String value = value1.toString();
        Integer end = null;
        Object value3 = dataList.get(2);
        if (value3 == null) {
            throw new AviatorException(getName() + "函数截取的结束位置为空，请确认!");
        } else {
            if (FunctionUtils.isString(value3)) {
                if (FunctionUtils.isNumerics(value3.toString())) {
                    end = Integer.valueOf(value3.toString());
                } else {
                    throw new AviatorException(getName() + "函数截取的结束位置数据类型不正确，请确认!");
                }
            } else if (value3 instanceof Number) {
                end = Integer.valueOf(value3.toString());
            }
        }
        if (start > end) {
            throw new AviatorException(getName() + "函数截取的开始位置比结束位置大，请确认!");
        }
        if (start != null && end != null) {
            if (end > value.length()) {
                end = value.length();
            }
            return new AviatorString(value.substring(start, end));
        }
        throw new AviatorException(getName() + "传入参数数组为空或者参数个数不正确!");
    }
}
