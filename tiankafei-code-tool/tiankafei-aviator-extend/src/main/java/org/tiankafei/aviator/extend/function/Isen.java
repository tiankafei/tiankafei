package org.tiankafei.aviator.extend.function;

import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.tiankafei.aviator.extend.constant.FunctionConstants;

/**
 * @Author 魏双双
 * @Date 2020/6/1
 * @Version V1.0
 **/
public class Isen extends OneParamFunction {
    @Override
    protected AviatorObject apply(Object param) {
        if (param == null) {
            return AviatorBoolean.FALSE;
        }
        String regex = "[a-z|A-Z]{";
        if (param instanceof String) {
            regex = regex + ((String) param).length() + "}";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher((String) param);

            return AviatorBoolean.valueOf(Boolean.valueOf(matcher.matches()));

        } else {
            return AviatorBoolean.FALSE;
        }
    }

    @Override
    public String getName() {
        return FunctionConstants.ISEN;
    }
}
