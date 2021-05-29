package org.tiankafei.aviator.runtime.function.one;

import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorNil;
import com.googlecode.aviator.runtime.type.AviatorObject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.aviator.constant.AviatorConstants;

/**
 * @author tiankafei
 */
public class Isen extends OneParamFunction {

    @Override
    public String getName() {
        return AviatorConstants.FUNCTION_IS_EN;
    }

    @Override
    protected AviatorObject apply(Object param) {
        if (param == null) {
            return AviatorNil.NIL;
        }
        String str = param.toString();
        if (StringUtils.isBlank(str)) {
            return AviatorNil.NIL;
        }
        String regex = "^[A-Za-z]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return AviatorBoolean.valueOf(matcher.matches());
    }

}
