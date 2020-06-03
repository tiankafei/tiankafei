package cn.tiankafei.aviator.extend.function;

import cn.tiankafei.aviator.extend.constant.FunctionConstants;
import cn.tiankafei.aviator.extend.exception.AviatorException;
import cn.tiankafei.aviator.extend.util.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorNil;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorString;
import java.util.List;
import java.util.Map;

/**
 * @Author 魏双双
 * @Date 2020/6/2
 * @Version V1.0
 **/
public class Left extends MoreParamFunction {
    @Override
    public String getName() {
        return FunctionConstants.LEFT;
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
        return super.call(env, arg1, arg2);
    }

    @Override
    public AviatorObject apply(List<Object> dataList) {
        int number = 2;
        if (dataList.size() == number) {
            Object value1 = dataList.get(0);
            if (value1 == null) {
                return new AviatorString("");
            }
            Integer count = null;
            Object value2 = dataList.get(1);
            if (value2 == null) {
                throw new AviatorException(getName() + "函数截取的位置为空，请确认!");
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
//        throw new AviatorException(getName() + "传入参数数组为空或者参数个数不正确!");
        return AviatorNil.NIL;
    }
}
