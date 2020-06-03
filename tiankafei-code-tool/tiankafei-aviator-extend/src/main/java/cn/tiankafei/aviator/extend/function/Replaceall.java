package cn.tiankafei.aviator.extend.function;

import cn.tiankafei.aviator.extend.constant.FunctionConstants;
import cn.tiankafei.aviator.extend.exception.AviatorException;
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
public class Replaceall extends MoreParamFunction {
    @Override
    public String getName() {
        return FunctionConstants.REPLACEALL;
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3) {
        return super.call(env, arg1, arg2, arg3);
    }

    @Override
    public AviatorObject apply(List<Object> dataList) {
        int length = dataList.size();
        int number3 = 3;
        if (length == number3) {
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
//        throw new AviatorException(getName() + "传入参数数组为空或者参数个数不正确!");
        return AviatorNil.NIL;
    }
}
