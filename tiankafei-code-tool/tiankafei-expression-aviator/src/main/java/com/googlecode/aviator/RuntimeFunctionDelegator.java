package com.googlecode.aviator;

import com.googlecode.aviator.exception.FunctionNotFoundException;
import com.googlecode.aviator.runtime.type.AviatorFunction;
import com.googlecode.aviator.runtime.type.AviatorType;
import com.googlecode.aviator.runtime.type.BaseAviatorObject;

import java.util.Map;

/**
 * Runtime function delegator
 *
 * @author dennis
 */
final class RuntimeFunctionDelegator extends BaseAviatorObject implements AviatorFunction {


    @Override
    public int compare(BaseAviatorObject other, Map<String, Object> env) {
        throw new UnsupportedOperationException("Lambda function can't be compared.");
    }

    @Override
    public AviatorType getAviatorType() {
        return AviatorType.Lambda;
    }

    @Override
    public Object getValue(Map<String, Object> env) {
        return this;
    }

    @Override
    public BaseAviatorObject call(Map<String, Object> env) {
        return getFunc(env).call(env);
    }

    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1) {
        return getFunc(env).call(env, arg1);
    }

    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2) {
        return getFunc(env).call(env, arg1, arg2);
    }

    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3) {
        return getFunc(env).call(env, arg1, arg2, arg3);
    }

    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4) {
        return getFunc(env).call(env, arg1, arg2, arg3, arg4);
    }

    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5) {
        return getFunc(env).call(env, arg1, arg2, arg3, arg4, arg5);
    }

    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6) {
        return getFunc(env).call(env, arg1, arg2, arg3, arg4, arg5, arg6);
    }

    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7) {
        return getFunc(env).call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }

    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8) {
        return getFunc(env).call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9) {
        return getFunc(env).call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    }

    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10) {
        return getFunc(env).call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11) {
        return getFunc(env).call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10,
                arg11);
    }

    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12) {
        return getFunc(env).call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10,
                arg11, arg12);
    }

    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13) {
        return getFunc(env).call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10,
                arg11, arg12, arg13);
    }

    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14) {
        return getFunc(env).call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10,
                arg11, arg12, arg13, arg14);
    }

    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14,
                                  BaseAviatorObject arg15) {
        return getFunc(env).call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10,
                arg11, arg12, arg13, arg14, arg15);
    }

    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14,
                                  BaseAviatorObject arg15, BaseAviatorObject arg16) {
        return getFunc(env).call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10,
                arg11, arg12, arg13, arg14, arg15, arg16);
    }

    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14,
                                  BaseAviatorObject arg15, BaseAviatorObject arg16, BaseAviatorObject arg17) {
        return getFunc(env).call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10,
                arg11, arg12, arg13, arg14, arg15, arg16, arg17);
    }

    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14,
                                  BaseAviatorObject arg15, BaseAviatorObject arg16, BaseAviatorObject arg17, BaseAviatorObject arg18) {
        return getFunc(env).call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10,
                arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18);
    }

    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14,
                                  BaseAviatorObject arg15, BaseAviatorObject arg16, BaseAviatorObject arg17, BaseAviatorObject arg18,
                                  BaseAviatorObject arg19) {
        return getFunc(env).call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10,
                arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19);
    }

    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14,
                                  BaseAviatorObject arg15, BaseAviatorObject arg16, BaseAviatorObject arg17, BaseAviatorObject arg18,
                                  BaseAviatorObject arg19, BaseAviatorObject arg20) {
        return getFunc(env).call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10,
                arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20);
    }

    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14,
                                  BaseAviatorObject arg15, BaseAviatorObject arg16, BaseAviatorObject arg17, BaseAviatorObject arg18,
                                  BaseAviatorObject arg19, BaseAviatorObject arg20, BaseAviatorObject... args) {
        return getFunc(env).call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10,
                arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, args);
    }

    private final String name;

    RuntimeFunctionDelegator(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    private AviatorFunction getFunc(Map<String, Object> env) {
        Object val = env.get(name);
        if (val instanceof AviatorFunction) {
            return (AviatorFunction) val;
        }
        throw new FunctionNotFoundException("Function not found: " + this.name);
    }
}
