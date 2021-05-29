package org.tiankafei.aviator.runtime.function.two;

import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.tiankafei.aviator.constant.AviatorConstants;

/**
 * @author tiankafei
 */
public class Match extends TwoParamFunction {

    @Override
    public String getName() {
        return AviatorConstants.FUNCTION_MATCH;
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
