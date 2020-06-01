package cn.tiankafei.aviator.extend.function;

import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;

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
    public AviatorObject apply(Map<String, Object> env, List<AviatorObject> valueList) {
        boolean result = false;

        for (int index = 0, length = valueList.size(); index < length; index++) {
            AviatorObject aviatorObject = valueList.get(index);
            if (aviatorObject instanceof AviatorBoolean) {
                AviatorBoolean aviatorBoolean = (AviatorBoolean) aviatorObject;
                boolean flag = aviatorBoolean.booleanValue(env);
                if (flag) {
                    result = true;
                    break;
                }
            }
        }
        return AviatorBoolean.valueOf(result);
    }
}
