package cn.tiankafei.aviator.extend.function.impl;

import cn.tiankafei.aviator.extend.function.MoreParamFunction;
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.utils.Env;

import java.util.List;
import java.util.Map;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class Or extends MoreParamFunction {

    @Override
    public String getName() {
        return "or";
    }

    @Override
    public AviatorObject call() throws Exception {
        return this.call(Env.EMPTY_ENV);
    }

    @Override
    public AviatorObject call(Map<String, Object> env) {
        return throwArity(0);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, List<AviatorObject> valueList) {
        super.call(env, valueList);

        boolean result = false;

        for (int index = 0, length = valueList.size(); index < length; index++) {
            AviatorObject aviatorObject = valueList.get(index);
            if(aviatorObject instanceof AviatorBoolean){
                AviatorBoolean aviatorBoolean = (AviatorBoolean) aviatorObject;
                boolean flag = aviatorBoolean.booleanValue(env);
                if(flag){
                    result = true;
                    break;
                }
            }
        }
        return AviatorBoolean.valueOf(result);
    }
}
