package com.googlecode.aviator.runtime.function;

import com.googlecode.aviator.runtime.RuntimeUtils;
import com.googlecode.aviator.runtime.type.AviatorFunction;
import com.googlecode.aviator.runtime.type.BaseAviatorObject;

import java.util.Map;

/**
 * Trace eval function.
 *
 * @author dennis
 */
public class TraceFunction implements AviatorFunction {

    private AviatorFunction rawFunc;


    private TraceFunction(AviatorFunction rawFunc) {
        super();
        this.rawFunc = rawFunc;
    }

    public static AviatorFunction wrapTrace(AviatorFunction func) {
        return new TraceFunction(func);
    }

    private void trace(Map<String, Object> env, Object... args) {
        StringBuilder sb = new StringBuilder();
        boolean wasFirst = true;
        for (Object arg : args) {
            if (wasFirst) {
                wasFirst = false;
            } else {
                sb.append(",");
            }
            if (arg instanceof String) {
                sb.append(arg.toString());
            } else {
                sb.append(((BaseAviatorObject) arg).desc(env));
            }
        }
        RuntimeUtils.printTrace(env, "Func   : " + this.getName() + "(" + sb.toString() + ")");
    }

    @Override
    public String getName() {
        return this.rawFunc.getName();
    }

    @Override
    public BaseAviatorObject call(Map<String, Object> env) {
        trace(env);
        return this.rawFunc.call(env);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1) {
        trace(env, arg1);
        return this.rawFunc.call(env, arg1);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2) {
        trace(env, arg1, arg2);
        return rawFunc.call(env, arg1, arg2);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3) {
        trace(env, arg1, arg2, arg3);
        return rawFunc.call(env, arg1, arg2, arg3);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4) {
        trace(env, arg1, arg2, arg3, arg4);
        return rawFunc.call(env, arg1, arg2, arg3, arg4);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5) {
        trace(env, arg1, arg2, arg3, arg4, arg5);
        return rawFunc.call(env, arg1, arg2, arg3, arg4, arg5);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6) {
        trace(env, arg1, arg2, arg3, arg4, arg5, arg6);
        return rawFunc.call(env, arg1, arg2, arg3, arg4, arg5, arg6);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7) {
        trace(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
        return rawFunc.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8) {
        trace(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
        return rawFunc.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9) {
        trace(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
        return rawFunc.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10) {
        trace(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
        return rawFunc.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11) {
        trace(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
        return rawFunc.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12) {
        trace(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
        return rawFunc.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11,
                arg12);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13) {
        trace(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13);
        return rawFunc.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11,
                arg12, arg13);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14) {
        trace(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13,
                arg14);
        return rawFunc.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11,
                arg12, arg13, arg14);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14,
                                  BaseAviatorObject arg15) {
        trace(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13,
                arg14, arg15);
        return rawFunc.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11,
                arg12, arg13, arg14, arg15);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14,
                                  BaseAviatorObject arg15, BaseAviatorObject arg16) {
        trace(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13,
                arg14, arg15, arg16);
        return rawFunc.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11,
                arg12, arg13, arg14, arg15, arg16);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14,
                                  BaseAviatorObject arg15, BaseAviatorObject arg16, BaseAviatorObject arg17) {
        trace(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13,
                arg14, arg15, arg16, arg17);
        return rawFunc.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11,
                arg12, arg13, arg14, arg15, arg16, arg17);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14,
                                  BaseAviatorObject arg15, BaseAviatorObject arg16, BaseAviatorObject arg17, BaseAviatorObject arg18) {
        trace(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13,
                arg14, arg15, arg16, arg17, arg18);
        return rawFunc.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11,
                arg12, arg13, arg14, arg15, arg16, arg17, arg18);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14,
                                  BaseAviatorObject arg15, BaseAviatorObject arg16, BaseAviatorObject arg17, BaseAviatorObject arg18,
                                  BaseAviatorObject arg19) {
        trace(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13,
                arg14, arg15, arg16, arg17, arg18, arg19);
        return rawFunc.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11,
                arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14,
                                  BaseAviatorObject arg15, BaseAviatorObject arg16, BaseAviatorObject arg17, BaseAviatorObject arg18,
                                  BaseAviatorObject arg19, BaseAviatorObject arg20) {
        trace(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13,
                arg14, arg15, arg16, arg17, arg18, arg19, arg20);
        return rawFunc.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11,
                arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20);
    }


    @Override
    public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1, BaseAviatorObject arg2,
                                  BaseAviatorObject arg3, BaseAviatorObject arg4, BaseAviatorObject arg5, BaseAviatorObject arg6,
                                  BaseAviatorObject arg7, BaseAviatorObject arg8, BaseAviatorObject arg9, BaseAviatorObject arg10,
                                  BaseAviatorObject arg11, BaseAviatorObject arg12, BaseAviatorObject arg13, BaseAviatorObject arg14,
                                  BaseAviatorObject arg15, BaseAviatorObject arg16, BaseAviatorObject arg17, BaseAviatorObject arg18,
                                  BaseAviatorObject arg19, BaseAviatorObject arg20, BaseAviatorObject... args) {
        trace(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13,
                arg14, arg15, arg16, arg17, arg18, arg19, arg20, "...");
        return this.rawFunc.call(env, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10,
                arg11, arg12, arg13, arg14, arg15, arg16, arg17, arg18, arg19, arg20, args);
    }
}
