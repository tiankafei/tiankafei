package com.googlecode.aviator.runtime.function.custom;

import com.googlecode.aviator.runtime.function.AbstractVariadicFunction;
import com.googlecode.aviator.runtime.type.AviatorString;
import com.googlecode.aviator.runtime.type.BaseAviatorObject;

import java.util.Map;


/**
 * From user's issue report https://github.com/killme2008/aviator/issues/12
 *
 * @author dennis
 */
public class GetFirstNonNullFunction extends AbstractVariadicFunction {

    public BaseAviatorObject variadicCall(Map<String, Object> env, BaseAviatorObject... args) {
        if (args != null) {
            for (BaseAviatorObject arg : args) {
                if (arg.getValue(env) != null) {
                    return arg;
                }
            }
        }
        return new AviatorString(null);
    }


    @Override
    public String getName() {
        return "getFirstNonNull";
    }

}
