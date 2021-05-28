package org.tiankafei.aviator.runtime.function.one;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorObject;
import java.util.Map;

/**
 * @author tiankafei
 */
public abstract class OneParamFunction extends AbstractFunction {

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1) {
        Object object = arg1.getValue(env);
        return apply(object);
    }

    protected abstract AviatorObject apply(Object object);

}
