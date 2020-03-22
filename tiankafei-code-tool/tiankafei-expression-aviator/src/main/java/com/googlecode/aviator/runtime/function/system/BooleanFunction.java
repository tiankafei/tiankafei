package com.googlecode.aviator.runtime.function.system;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.BaseAviatorObject;

import java.util.Map;


/**
 * Cast value to double,double(a) eg.
 *
 * @author dennis
 * @since 4.0.0
 */
public class BooleanFunction extends AbstractFunction {

    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1) {
        switch (arg1.getAviatorType()) {
            case Boolean:
                return arg1;
            default:
                if (arg1.getValue(env) == null) {
                    return AviatorBoolean.FALSE;
                } else {
                    return AviatorBoolean.TRUE;
                }
        }
    }


    @Override
    public String getName() {
        return "boolean";
    }

}
