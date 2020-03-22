package com.googlecode.aviator.runtime.function.string;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorLong;
import com.googlecode.aviator.runtime.type.BaseAviatorObject;

import java.util.Map;


/**
 * String.indexOf function
 *
 * @author boyan
 */
public class StringIndexOfFunction extends AbstractFunction {

    @Override
    public String getName() {
        return "string.indexOf";
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2) {
        String target = FunctionUtils.getStringValue(arg1, env);
        String param = FunctionUtils.getStringValue(arg2, env);
        return AviatorLong.valueOf(target.indexOf(param));
    }

}
