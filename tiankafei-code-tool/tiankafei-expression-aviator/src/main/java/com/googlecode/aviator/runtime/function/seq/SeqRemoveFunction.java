package com.googlecode.aviator.runtime.function.seq;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.BaseAviatorObject;

import java.util.Collection;
import java.util.Map;

/**
 * seq.add function to add an element into seq.
 *
 * @author dennis
 * @since 4.1.2
 */
public class SeqRemoveFunction extends AbstractFunction {

    @Override
    public String getName() {
        return "seq.remove";
    }

    @SuppressWarnings("rawtypes")
    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2) {

        Object coll = arg1.getValue(env);
        Object element = arg2.getValue(env);
        if (coll == null) {
            throw new NullPointerException("null seq");
        }
        Class<?> clazz = coll.getClass();

        if (Collection.class.isAssignableFrom(clazz)) {
            ((Collection) coll).remove(element);
            return arg1;
        } else if (Map.class.isAssignableFrom(clazz)) {
            ((Map) coll).remove(element);
            return arg1;
        } else {
            throw new IllegalArgumentException(arg1.desc(env) + " is not a collection or map.");
        }

    }

}
