package cn.tiankafei.aviator.extend.function;

import cn.tiankafei.aviator.extend.constant.FunctionConstants;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author 魏双双
 * @Date 2020/6/2
 * @Version V1.0
 **/
public class Replaceall extends AbstractFunction {
    @Override
    public String getName() {
        return FunctionConstants.REPLACEALL;
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
        Object text = dataList.get(0);
        if (text == null) {
            return new AviatorString("");
        }
        Object regex = dataList.get(1);
        if (regex == null) {
            return new AviatorString("");
        }
        Object replacement = dataList.get(2);
        if (replacement == null) {
            return new AviatorString("");
        }

        String str = text.toString();
        return new AviatorString(str.replaceAll(regex.toString(), replacement.toString()));
    }
}
