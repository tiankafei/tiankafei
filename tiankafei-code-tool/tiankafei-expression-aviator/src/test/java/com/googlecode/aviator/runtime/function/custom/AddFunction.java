package com.googlecode.aviator.runtime.function.custom;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.BaseAviatorObject;

import java.util.Map;


public class AddFunction extends AbstractFunction {

    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2) {
        return arg1.add(arg2, env);
    }


    @Override
    public String getName() {
        return "myadd";
    }

}
