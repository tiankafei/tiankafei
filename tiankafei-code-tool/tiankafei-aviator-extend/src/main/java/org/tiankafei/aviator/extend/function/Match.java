package org.tiankafei.aviator.extend.function;

import org.tiankafei.aviator.extend.constant.FunctionConstants;
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author 魏双双
 * @Date 2020/6/2
 * @Version V1.0
 **/
public class Match extends TwoParamFunction {
    @Override
    public String getName() {
        return FunctionConstants.MATCH;
    }

    @Override
    protected AviatorObject apply(Object pattern, Object matcher) {
        try {
            if (pattern == null || matcher == null) {
                return AviatorBoolean.FALSE;
            }
            Pattern p = Pattern.compile(pattern.toString());
            Matcher m = p.matcher(matcher.toString());
            return AviatorBoolean.valueOf(m.matches());
        } catch (Exception e) {
            e.printStackTrace();
            return AviatorBoolean.FALSE;
        }
    }
}
