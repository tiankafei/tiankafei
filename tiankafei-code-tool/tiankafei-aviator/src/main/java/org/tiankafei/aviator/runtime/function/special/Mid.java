package org.tiankafei.aviator.runtime.function.special;

import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorString;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.aviator.constant.AviatorConstants;
import org.tiankafei.aviator.util.AviatorUtil;

/**
 * 字符串截取：mid(a, 1, 3)
 * 从哪个位置开始（从1开始），截取指定个数的字符串
 *
 * @author tiankafei
 */
public class Mid extends SpecialFunction {

    @Override
    public String getName() {
        return AviatorConstants.FUNCTION_MID;
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3) {
        String text = getValue(env, arg1).toString();
        String s1 = getValue(env, arg2).toString();
        String c1 = getValue(env, arg3).toString();

        Integer start = 1;
        if (StringUtils.isNotBlank(s1) && AviatorUtil.isNumerics(s1)) {
            start = Integer.valueOf(s1);
            if (start < 1) {
                start = 1;
            }
        }
        int length = text.length();
        Integer count = length - start;
        if (StringUtils.isNotBlank(c1) && AviatorUtil.isNumerics(c1)) {
            count = Integer.valueOf(c1);
            if (count > length - start) {
                count = length - start;
            }
        }
        return new AviatorString(text.substring(start - 1, start + count));
    }

}
