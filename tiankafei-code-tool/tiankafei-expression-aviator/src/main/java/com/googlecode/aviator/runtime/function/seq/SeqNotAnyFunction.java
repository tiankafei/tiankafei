package com.googlecode.aviator.runtime.function.seq;

import com.googlecode.aviator.exception.FunctionNotFoundException;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorFunction;
import com.googlecode.aviator.runtime.type.AviatorJavaType;
import com.googlecode.aviator.runtime.type.AviatorNil;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import com.googlecode.aviator.runtime.type.BaseAviatorObject;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;


/**
 * Returns false if fun.call(x) is logical true for any x in sequence, else true.
 *
 * @author tiankafei
 */
public class SeqNotAnyFunction extends AbstractFunction {

    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2) {
        Object first = arg1.getValue(env);
        AviatorFunction fun = FunctionUtils.getFunction(arg2, env, 1);
        if (fun == null) {
            throw new FunctionNotFoundException(
                    "There is no function named " + ((AviatorJavaType) arg2).getName());
        }
        if (first == null) {
            return AviatorNil.NIL;
        }
        Class<?> clazz = first.getClass();

        if (Collection.class.isAssignableFrom(clazz)) {
            for (Object obj : (Collection<?>) first) {
                if (fun.call(env, new AviatorRuntimeJavaType(obj)).booleanValue(env)) {
                    return AviatorBoolean.FALSE;
                }
            }
        } else if (clazz.isArray()) {
            int length = Array.getLength(first);
            for (int i = 0; i < length; i++) {
                Object obj = Array.get(first, i);
                if (fun.call(env, new AviatorRuntimeJavaType(obj)).booleanValue(env)) {
                    return AviatorBoolean.FALSE;
                }
            }
        } else {
            throw new IllegalArgumentException(arg1.desc(env) + " is not a seq collection");
        }
        return AviatorBoolean.TRUE;
    }


    @Override
    public String getName() {
        return "seq.not_any";
    }
}
