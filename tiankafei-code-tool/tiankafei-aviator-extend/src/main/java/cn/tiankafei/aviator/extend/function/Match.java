package cn.tiankafei.aviator.extend.function;

import cn.tiankafei.aviator.extend.constant.FunctionConstants;
import cn.tiankafei.aviator.extend.exception.AviatorException;
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author 魏双双
 * @Date 2020/6/2
 * @Version V1.0
 **/
public class Match extends MoreParamFunction {
    @Override
    public String getName() {
        return FunctionConstants.MATCH;
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
        return super.call(env, arg1, arg2);
    }

    @Override
    public AviatorObject apply(List<Object> dataList) {
        int length = dataList.size();
        int number2 = 2;
        if (length == number2) {
            Object pattern = dataList.get(0);
            Object matcher = dataList.get(1);
            try {
                if (pattern == null || matcher == null) {
                    return AviatorBoolean.FALSE;
                }
                Pattern p = Pattern.compile(pattern.toString());
                Matcher m = p.matcher(matcher.toString());
                return AviatorBoolean.valueOf(m.matches());
            } catch (Exception e) {
                throw new AviatorException(getName() + "函数的参数类型不合法!");
            }
        }
        throw new AviatorException(getName() + "传入参数数组为空或者参数个数不正确!");
    }
}
