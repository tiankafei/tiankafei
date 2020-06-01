package cn.tiankafei.aviator.extend.function;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorObject;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Slf4j
public abstract class TwoParamFunction extends AbstractFunction {

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
        Object left = arg1.getValue(env);
        Object right = arg2.getValue(env);
        return this.apply(left, right);
    }

    protected abstract AviatorObject apply(Object left, Object right);

}
