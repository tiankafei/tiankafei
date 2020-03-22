package com.googlecode.aviator.runtime.function;

import com.googlecode.aviator.runtime.type.AviatorFunction;
import com.googlecode.aviator.runtime.type.AviatorType;
import com.googlecode.aviator.runtime.type.BaseAviatorObject;

import java.util.Map;


/**
 * Abstract function to implement variadic arguments function.
 *
 * @author dennis
 * @since 3.0.0
 */
public abstract class AbstractVariadicFunction extends BaseAviatorObject implements AviatorFunction {

    @Override
    public AviatorType getAviatorType() {
        return AviatorType.Lambda;
    }

    @Override
    public Object getValue(Map<String, Object> env) {
        return this;
    }

    @Override
    public int compare(BaseAviatorObject other, Map<String, Object> env) {
        throw new UnsupportedOperationException("Lambda function can't be compared.");
    }

    @Override
    public BaseAviatorObject call(Map<String, Object> env) {
        return this.variadicCall(env);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1) {
        return this.variadicCall(env, arg1);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2) {
        return variadicCall(env, arg1, arg2);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3) {
        return variadicCall(env, arg1, arg2, arg3);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4) {
        return variadicCall(env, arg1, arg2, arg3, arg4);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5) {
        return variadicCall(env, arg1, arg2, arg3, arg4, arg5);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6) {
        return variadicCall(env, arg1, arg2, arg3, arg4, arg5, arg6);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7) {
        return variadicCall(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8) {
        return variadicCall(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9) {
        return variadicCall(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10) {
        return variadicCall(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11) {
        return variadicCall(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12) {
        return variadicCall(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11,
                arg12);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13) {
        return variadicCall(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11,
                arg12, arg13);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14) {
        return variadicCall(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11,
                arg12, arg13, arg14);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14,
                                  BaseAviatorObject arg15) {
        return variadicCall(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11,
                arg12, arg13, arg14, arg15);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14,
                                  BaseAviatorObject arg15, BaseAviatorObject arg16) {
        return variadicCall(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11,
                arg12, arg13, arg14, arg15, arg16);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14,
                                  BaseAviatorObject arg15, BaseAviatorObject arg16, BaseAviatorObject arg17) {
        return variadicCall(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11,
                arg12, arg13, arg14, arg15, arg16, arg17);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14,
                                  BaseAviatorObject arg15, BaseAviatorObject arg16, BaseAviatorObject arg17, BaseAviatorObject arg18) {
        return variadicCall(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11,
                arg12, arg13, arg14, arg15, arg16, arg17, arg18);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14,
                                  BaseAviatorObject arg15, BaseAviatorObject arg16, BaseAviatorObject arg17, BaseAviatorObject arg18,
                                  BaseAviatorObject arg19) {
        return variadicCall(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11,
                arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14,
                                  BaseAviatorObject arg15, BaseAviatorObject arg16, BaseAviatorObject arg17, BaseAviatorObject arg18,
                                  BaseAviatorObject arg19, BaseAviatorObject arg20) {
        return variadicCall(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11,
                arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14,
                                  BaseAviatorObject arg15, BaseAviatorObject arg16, BaseAviatorObject arg17, BaseAviatorObject arg18,
                                  BaseAviatorObject arg19, BaseAviatorObject arg20, BaseAviatorObject... args) {
        if (args == null || args.length == 0) {
            return this.variadicCall(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10,
                    arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20);
        } else {
            BaseAviatorObject[] allArgs = new BaseAviatorObject[20 + args.length];
            allArgs[0] = arg1;
            allArgs[1] = arg2;
            allArgs[2] = arg3;
            allArgs[3] = arg4;
            allArgs[4] = arg5;
            allArgs[5] = arg6;
            allArgs[6] = arg7;
            allArgs[7] = arg8;
            allArgs[8] = arg9;
            allArgs[9] = arg10;
            allArgs[10] = arg11;
            allArgs[11] = arg12;
            allArgs[12] = arg13;
            allArgs[13] = arg14;
            allArgs[14] = arg15;
            allArgs[15] = arg16;
            allArgs[16] = arg17;
            allArgs[17] = arg18;
            allArgs[18] = arg19;
            allArgs[19] = arg20;
            System.arraycopy(args, 0, allArgs, 20, args.length);
            return this.variadicCall(env, allArgs);
        }
    }


    /**
     * Call with variadic arguments.The subclass must implement this method.
     *
     * @param env
     * @param args
     * @return
     * @since 3.0.0
     */
    public abstract BaseAviatorObject variadicCall(Map<String, Object> env, BaseAviatorObject... args);

}
