package com.googlecode.aviator.runtime.function.seq;

import com.googlecode.aviator.runtime.function.AbstractVariadicFunction;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import com.googlecode.aviator.runtime.type.BaseAviatorObject;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * seq.set function to new a hash set.
 *
 * @author dennis
 * @since 4.1.2
 */
public class SeqNewSetFunction extends AbstractVariadicFunction {

    @Override
    public String getName() {
        return "seq.set";
    }

    @Override
    public BaseAviatorObject variadicCall(Map<String, Object> env, BaseAviatorObject... args) {
        Set<Object> set = new HashSet<>();

        for (BaseAviatorObject obj : args) {
            set.add(obj.getValue(env));
        }

        return new AviatorRuntimeJavaType(set);
    }


}
