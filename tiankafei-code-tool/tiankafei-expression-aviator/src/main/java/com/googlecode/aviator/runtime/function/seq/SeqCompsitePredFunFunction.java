package com.googlecode.aviator.runtime.function.seq;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.AbstractVariadicFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorFunction;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import com.googlecode.aviator.runtime.type.BaseAviatorObject;

import java.util.Map;


/**
 * Composite predicate function with && or ||
 *
 * @author dennis
 */
public class SeqCompsitePredFunFunction extends AbstractVariadicFunction {

    public static enum LogicOp {

        /**
         * AND
         */
        AND,

        /**
         * OR
         */
        OR
    }


    @Override
    public String getName() {
        return this.name;
    }

    private LogicOp op;

    private String name;


    public SeqCompsitePredFunFunction(String name, LogicOp op) {
        super();
        this.op = op;
        this.name = name;
    }


    @Override
    public BaseAviatorObject variadicCall(Map<String, Object> env, BaseAviatorObject... args) {
        if (args == null || args.length == 0) {
            return AviatorBoolean.valueOf(op == LogicOp.AND);
        }
        return new AviatorRuntimeJavaType(createFunction(env, args, op));
    }


    private static AviatorFunction createFunction(final Map<String, Object> env,
                                                  final BaseAviatorObject[] args, final LogicOp op) {
        return new AbstractFunction() {

            @Override
            public BaseAviatorObject call(Map<String, Object> env, BaseAviatorObject arg1) {
                switch (op) {
                    case AND:
                        boolean ret = true;
                        for (BaseAviatorObject obj : args) {
                            AviatorFunction fn = FunctionUtils.getFunction(obj, env, 1);
                            if (fn == null) {
                                throw new IllegalArgumentException("Expect " + obj.desc(env) + " as a function.");
                            }
                            ret = fn.call(env, arg1) == AviatorBoolean.TRUE;
                            if (!ret) {
                                break;
                            }
                        }
                        return AviatorBoolean.valueOf(ret);
                    case OR:
                        ret = false;
                        for (BaseAviatorObject obj : args) {
                            AviatorFunction fn = FunctionUtils.getFunction(obj, env, 1);
                            if (fn == null) {
                                throw new IllegalArgumentException("Expect " + obj.desc(env) + " as a function.");
                            }
                            ret = fn.call(env, arg1) == AviatorBoolean.TRUE;
                            if (ret) {
                                break;
                            }
                        }
                        return AviatorBoolean.valueOf(ret);
                    default:
                        break;
                }
                return AviatorBoolean.FALSE;
            }


            @Override
            public String getName() {
                return op == LogicOp.AND ? "seq.and" : "seq.or";
            }
        };

    }
}
