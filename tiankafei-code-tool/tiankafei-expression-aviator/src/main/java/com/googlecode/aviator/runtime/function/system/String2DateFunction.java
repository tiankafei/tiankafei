package com.googlecode.aviator.runtime.function.system;

import com.googlecode.aviator.exception.ExpressionRuntimeException;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import com.googlecode.aviator.runtime.type.BaseAviatorObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;


/**
 * string_to_date function
 *
 * @author boyan
 */
public class String2DateFunction extends AbstractFunction {

    @Override
    public String getName() {
        return "string_to_date";
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2) {
        String source = FunctionUtils.getStringValue(arg1, env);
        String format = FunctionUtils.getStringValue(arg2, env);
        SimpleDateFormat dateFormat = DateFormatCache.getOrCreateDateFormat(format);
        try {
            return new AviatorRuntimeJavaType(dateFormat.parse(source));
        } catch (ParseException e) {
            throw new ExpressionRuntimeException("Cast string to date failed", e);
        }
    }

}
