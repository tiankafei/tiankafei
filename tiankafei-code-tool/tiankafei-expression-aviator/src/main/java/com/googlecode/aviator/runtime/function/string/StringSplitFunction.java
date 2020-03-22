package com.googlecode.aviator.runtime.function.string;

import com.googlecode.aviator.exception.ExpressionRuntimeException;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import com.googlecode.aviator.runtime.type.BaseAviatorObject;

import java.util.Map;


/**
 * string.split function
 *
 * @author boyan
 */
public class StringSplitFunction extends AbstractFunction {
    @Override
    public String getName() {
        return "string.split";
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3) {
        String target = FunctionUtils.getStringValue(arg1, env);
        if (target == null) {
            throw new ExpressionRuntimeException("Could not split with null string");
        }
        String regex = FunctionUtils.getStringValue(arg2, env);
        int limit = FunctionUtils.getNumberValue(arg3, env).intValue();
        return new AviatorRuntimeJavaType(target.split(regex, limit));
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2) {
        String target = FunctionUtils.getStringValue(arg1, env);
        if (target == null) {
            throw new ExpressionRuntimeException("Could not replace with null string");
        }
        String regex = FunctionUtils.getStringValue(arg2, env);
        return new AviatorRuntimeJavaType(target.split(regex));
    }
}
