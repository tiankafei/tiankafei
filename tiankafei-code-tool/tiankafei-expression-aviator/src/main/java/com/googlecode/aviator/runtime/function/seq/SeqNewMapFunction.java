package com.googlecode.aviator.runtime.function.seq;

import com.googlecode.aviator.runtime.function.AbstractVariadicFunction;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import com.googlecode.aviator.runtime.type.BaseAviatorObject;

import java.util.HashMap;
import java.util.Map;

/**
 * seq.map function to new a hash map.
 *
 * @author dennis
 * @since 4.1.2
 */
public class SeqNewMapFunction extends AbstractVariadicFunction {

    @Override
    public String getName() {
        return "seq.map";
    }

    @Override
    public BaseAviatorObject variadicCall(Map<String, Object> env, BaseAviatorObject... args) {
        Map<Object, Object> map = new HashMap<>(args.length);

        int number = 2;
        if (args.length % number != 0) {
            throw new IllegalArgumentException("Expect arguments in even number as key/value pairs.");
        }

        for (int i = 0; i < args.length; ) {
            map.put(args[i].getValue(env), args[i + 1].getValue(env));
            i += 2;
        }

        return new AviatorRuntimeJavaType(map);
    }

}
