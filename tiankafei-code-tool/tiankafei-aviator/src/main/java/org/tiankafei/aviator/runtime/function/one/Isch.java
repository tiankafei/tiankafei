package org.tiankafei.aviator.runtime.function.one;

import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.tiankafei.aviator.constant.AviatorConstants;

/**
 * @author tiankafei
 */
public class Isch extends OneParamFunction {

    @Override
    public String getName() {
        return AviatorConstants.FUNCTION_IS_CH;
    }

    @Override
    protected AviatorObject apply(Object param) {
        if (param == null) {
            return AviatorBoolean.FALSE;
        }
        String regex = "^[\u4e00-\u9fa5]{0,}$";

        if (param instanceof String) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher((String) param);

            return AviatorBoolean.valueOf(matcher.matches());
        } else {
            return AviatorBoolean.FALSE;
        }
    }

}
