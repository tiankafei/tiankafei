package com.googlecode.aviator.runtime.function.string;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorString;
import com.googlecode.aviator.runtime.type.BaseAviatorObject;

import java.util.Map;


/**
 * string.replace_first function
 *
 * @author boyan
 */
public class StringReplaceFirstFunction extends AbstractFunction {
    @Override
    public String getName() {
        return "string.replace_first";
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3) {
        String target = FunctionUtils.getStringValue(arg1, env);
        String regex = FunctionUtils.getStringValue(arg2, env);
        String replacement = FunctionUtils.getStringValue(arg3, env);
        return new AviatorString(target.replaceFirst(regex, replacement));

    }

}
