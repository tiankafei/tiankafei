package com.googlecode.aviator.runtime.function.seq;

import com.googlecode.aviator.runtime.function.AbstractVariadicFunction;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import com.googlecode.aviator.runtime.type.BaseAviatorObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * seq.list function to new an array list.
 *
 * @author dennis
 * @since 4.1.2
 */
public class SeqNewListFunction extends AbstractVariadicFunction {

    @Override
    public String getName() {
        return "seq.list";
    }

    @Override
    public BaseAviatorObject variadicCall(Map<String, Object> env, BaseAviatorObject... args) {
        List<Object> list = new ArrayList<>();

        for (BaseAviatorObject obj : args) {
            list.add(obj.getValue(env));
        }

        return new AviatorRuntimeJavaType(list);
    }


}
