package com.googlecode.aviator.runtime.function.system;

import com.googlecode.aviator.runtime.function.AbstractVariadicFunction;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import com.googlecode.aviator.runtime.type.BaseAviatorObject;

import java.util.Map;

/**
 * tuple(x,y,z, ...) function to return an object array.
 *
 * @author dennis
 * @since 4.0.0
 */
public class TupleFunction extends AbstractVariadicFunction {

    @Override
    public String getName() {
        return "tuple";
    }

    @Override
    public BaseAviatorObject variadicCall(Map<String, Object> env, BaseAviatorObject... args) {
        Object[] tuple = new Object[args.length];
        for (int i = 0; i < args.length; i++) {
            tuple[i] = args[i].getValue(env);
        }
        return new AviatorRuntimeJavaType(tuple);
    }

}
