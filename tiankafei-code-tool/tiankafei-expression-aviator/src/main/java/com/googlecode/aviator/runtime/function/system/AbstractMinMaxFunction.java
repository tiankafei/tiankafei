package com.googlecode.aviator.runtime.function.system;

import com.googlecode.aviator.runtime.function.AbstractVariadicFunction;
import com.googlecode.aviator.runtime.type.AviatorNil;
import com.googlecode.aviator.runtime.type.BaseAviatorObject;

import java.util.Map;

/**
 * Abstract base class for system min/max function.
 *
 * @author dennis
 */
public abstract class AbstractMinMaxFunction extends AbstractVariadicFunction {
    static enum Op {
        /**
         * Min
         */
        Min,

        /**
         * Max
         */
        Max
    }


    @Override
    public BaseAviatorObject variadicCall(Map<String, Object> env, BaseAviatorObject... args) {

        if (args == null || args.length == 0) {
            return AviatorNil.NIL;
        }

        boolean wasFirst = true;
        BaseAviatorObject result = AviatorNil.NIL;
        for (BaseAviatorObject obj : args) {
            result = compareObjects(env, result, obj, wasFirst);
            if (wasFirst) {
                wasFirst = false;
            }
            if (getOp() == Op.Min && result.isNull(env)) {
                break;
            }
        }

        return result;
    }

    /**
     * 获取Op
     *
     * @return
     */
    protected abstract Op getOp();


    private BaseAviatorObject compareObjects(Map<String, Object> env, BaseAviatorObject result,
                                             BaseAviatorObject obj, boolean wasFirst) {
        if (obj.isNull(env)) {
            switch (getOp()) {
                case Min:
                    return obj;
                case Max:
                    return result;
                default:
                    break;
            }
        }
        if (wasFirst || compare(env, result, obj)) {
            result = obj;
        }
        return result;
    }

    private boolean compare(Map<String, Object> env, BaseAviatorObject result, BaseAviatorObject obj) {
        int c = obj.compare(result, env);
        switch (getOp()) {
            case Min:
                return c < 0;
            case Max:
                return c > 0;
            default:
                break;
        }
        return false;
    }
}
