package org.tiankafei.aviator.runtime.function.special;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorObject;
import java.util.Map;

/**
 * @author tiankafei
 */
public abstract class SpecialFunction extends AbstractFunction {

    /**
     * 获取值
     *
     * @param env
     * @param arg
     * @return
     */
    protected Object getValue(Map<String, Object> env, AviatorObject arg) {
        Object value = arg.getValue(env);
        if (value == null) {
            value = "";
        }
        return value;
    }

}
