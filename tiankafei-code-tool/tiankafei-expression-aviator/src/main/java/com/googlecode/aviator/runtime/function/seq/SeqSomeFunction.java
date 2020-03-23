package com.googlecode.aviator.runtime.function.seq;

import com.googlecode.aviator.exception.FunctionNotFoundException;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorFunction;
import com.googlecode.aviator.runtime.type.AviatorJavaType;
import com.googlecode.aviator.runtime.type.AviatorNil;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import com.googlecode.aviator.runtime.type.BaseAviatorObject;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;


/**
 * Returns the first logical true value of fun.call(x) for any x in sequence, else returns nil.
 *
 * @author dennis
 */
public class SeqSomeFunction extends AbstractFunction {

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
                // return first fun returns true element.
                if (fun.call(env, new AviatorRuntimeJavaType(obj)).booleanValue(env)) {
                    return new AviatorRuntimeJavaType(obj);
                }
            }
        } else if (clazz.isArray()) {
            int length = Array.getLength(first);
            for (int i = 0; i < length; i++) {
                Object obj = Array.get(first, i);
                // return first fun returns true element.
                if (fun.call(env, new AviatorRuntimeJavaType(obj)).booleanValue(env)) {
                    return new AviatorRuntimeJavaType(obj);
                }
            }
        } else {
            throw new IllegalArgumentException(arg1.desc(env) + " is not a seq collection");
        }
        // else return nil
        return AviatorNil.NIL;
    }


    @Override
    public String getName() {
        return "seq.some";
    }
}