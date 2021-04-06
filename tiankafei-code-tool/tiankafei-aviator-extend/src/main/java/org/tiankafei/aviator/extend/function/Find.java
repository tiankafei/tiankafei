package org.tiankafei.aviator.extend.function;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.aviator.extend.constant.FunctionConstants;
import org.tiankafei.aviator.extend.exception.AviatorException;
import org.tiankafei.aviator.extend.util.FunctionUtils;

/**
 * @Author 魏双双
 * @Date 2020/6/2
 * @Version V1.0
 **/
public class Find extends AbstractFunction {

    @Override
    public String getName() {
        return FunctionConstants.FIND;
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
        return this.call(env, Arrays.asList(arg1, arg2));
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
        try {
            Object pattern = dataList.get(0);
            Object matcher = dataList.get(1);
            int start = 0;
            if (dataList.size() == 3) {
                Object value3 = dataList.get(2);
                if (value3 != null && StringUtils.isNotBlank(value3.toString())) {
                    if (FunctionUtils.isNumerics(value3.toString())) {
                        start = Integer.parseInt(value3.toString());
                    }
                }
            }
            if (pattern == null || matcher == null) {
                return AviatorBoolean.FALSE;
            }
            Pattern p;
            try {
                p = Pattern.compile(pattern.toString());
            } catch (PatternSyntaxException e) {
                //目前发现，解析左花括号“{”有问题，其他特殊符号有没有问题，未知
                if ("{".equals(pattern) || "\\\\{".equals(pattern)) {
                    pattern = "\\{";
                }
                p = Pattern.compile(pattern.toString());
            }
            if (StringUtils.isEmpty(matcher.toString())) {
                matcher = getNullString(start);
            }
            if (start > matcher.toString().length()) {
                start = matcher.toString().length();
            }
            Matcher m = p.matcher(matcher.toString());
            return AviatorBoolean.valueOf(m.find(start));
        } catch (Exception e) {
            e.printStackTrace();
            throw new AviatorException(getName() + "函数的参数类型不合法!");
        }
    }

    private String getNullString(int length) {
        StringBuffer bf = new StringBuffer();
        for (int i = 0; i < length; i++) {
            bf.append(" ");
        }
        return bf.toString();
    }
}
