package com.googlecode.aviator.runtime.function.system;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.BaseAviatorObject;

import java.util.Map;

/**
 * identity function return the argument itself.
 *
 * @author dennis
 */
public class IdentityFunction extends AbstractFunction {

    @Override
    public String getName() {
        return "identity";
    }

    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1) {
        return arg1;
    }
}
