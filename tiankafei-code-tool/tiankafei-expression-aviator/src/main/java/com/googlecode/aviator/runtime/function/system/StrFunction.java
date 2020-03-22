package com.googlecode.aviator.runtime.function.system;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorString;
import com.googlecode.aviator.runtime.type.BaseAviatorObject;

import java.util.Map;


/**
 * Cast value to string
 *
 * @author dennis
 * @since 1.1.1
 */
public class StrFunction extends AbstractFunction {

    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1) {
        final Object value = arg1.getValue(env);
        return new AviatorString(value == null ? "null" : value.toString());
    }

    @Override
    public String getName() {
        return "str";
    }

}
