package com.googlecode.aviator.runtime.function;

import com.googlecode.aviator.runtime.type.AviatorFunction;
import com.googlecode.aviator.runtime.type.AviatorType;
import com.googlecode.aviator.runtime.type.BaseAviatorObject;

import java.util.Map;


/**
 * Abstract function implementation
 *
 * @author boyan
 */
public abstract class AbstractFunction extends BaseAviatorObject implements AviatorFunction {
    public BaseAviatorObject throwArity(int n) {
        String name = this.getName();
        throw new IllegalArgumentException("Wrong number of args (" + n + ") passed to: " + name);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env) {
        return this.throwArity(0);
    }


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
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1) {
        return this.throwArity(1);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2) {
        return this.throwArity(2);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3) {
        return this.throwArity(3);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4) {
        return this.throwArity(4);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5) {
        return this.throwArity(5);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6) {
        return this.throwArity(6);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7) {
        return this.throwArity(7);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8) {
        return this.throwArity(8);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9) {
        return this.throwArity(9);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10) {
        return this.throwArity(10);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11) {
        return this.throwArity(11);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12) {
        return this.throwArity(12);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13) {
        return this.throwArity(13);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14) {
        return this.throwArity(14);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14,
                                  BaseAviatorObject arg15) {
        return this.throwArity(15);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14,
                                  BaseAviatorObject arg15, BaseAviatorObject arg16) {
        return this.throwArity(16);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14,
                                  BaseAviatorObject arg15, BaseAviatorObject arg16, BaseAviatorObject arg17) {
        return this.throwArity(17);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14,
                                  BaseAviatorObject arg15, BaseAviatorObject arg16, BaseAviatorObject arg17, BaseAviatorObject arg18) {
        return this.throwArity(18);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14,
                                  BaseAviatorObject arg15, BaseAviatorObject arg16, BaseAviatorObject arg17, BaseAviatorObject arg18,
                                  BaseAviatorObject arg19) {
        return this.throwArity(19);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14,
                                  BaseAviatorObject arg15, BaseAviatorObject arg16, BaseAviatorObject arg17, BaseAviatorObject arg18,
                                  BaseAviatorObject arg19, BaseAviatorObject arg20) {
        return this.throwArity(20);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14,
                                  BaseAviatorObject arg15, BaseAviatorObject arg16, BaseAviatorObject arg17, BaseAviatorObject arg18,
                                  BaseAviatorObject arg19, BaseAviatorObject arg20, BaseAviatorObject... args) {
        return this.throwArity(21);
    }

}
