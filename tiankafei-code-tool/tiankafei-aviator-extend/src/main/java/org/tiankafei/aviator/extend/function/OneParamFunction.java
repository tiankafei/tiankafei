package org.tiankafei.aviator.extend.function;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorObject;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Slf4j
public abstract class OneParamFunction extends AbstractFunction {

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1) {
        Object object = arg1.getValue(env);
        return apply(object);
    }

    protected abstract AviatorObject apply(Object object);

}
