package com.googlecode.aviator.runtime.function.math;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.BaseAviatorObject;

import java.util.Map;


/**
 * math.round(d) function
 *
 * @author dennis
 */
public class MathRoundFunction extends AbstractFunction {

    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg) {
        return AviatorDouble.valueOf(Math.round(FunctionUtils.getNumberValue(arg, env).doubleValue()));
    }


    @Override
    public String getName() {
        return "math.round";
    }

}
