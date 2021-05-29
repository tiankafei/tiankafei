package org.tiankafei.aviator.runtime.function.two;

import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.tiankafei.aviator.constant.AviatorConstants;

/**
 * lookingAt:部分匹配，总是从第一个字符进行匹配,匹配成功了不再继续匹配，匹配失败了,也不继续匹配。
 *
 * @author tiankafei
 */
public class Lookat extends TwoParamFunction {

    @Override
    public String getName() {
        return AviatorConstants.FUNCTION_LOOKAT;
    }

    @Override
    protected AviatorObject apply(Object pattern, Object matcher) {
        try {
            if (pattern == null || matcher == null) {
                return AviatorBoolean.FALSE;
            }
            Pattern p = Pattern.compile(pattern.toString());
            Matcher m = p.matcher(matcher.toString());
            return AviatorBoolean.valueOf(m.lookingAt());
        } catch (Exception e) {
            e.printStackTrace();
            return AviatorBoolean.FALSE;
        }
    }

}
