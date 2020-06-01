package cn.tiankafei.aviator.extend.function;

import cn.tiankafei.aviator.extend.constant.FunctionConstants;
import cn.tiankafei.aviator.extend.util.AviatorExtendUtil;
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Slf4j
public class Or extends MoreParamFunction {

    @Override
    public String getName() {
        return FunctionConstants.OR_MORE;
    }

    @Override
    public AviatorObject apply(Map<String, Object> env, List<AviatorObject> valueList) {
        boolean result = false;
        StringBuilder errorInfo = new StringBuilder();
        for (int index = 0, length = valueList.size(); index < length; index++) {
            AviatorObject aviatorObject = valueList.get(index);
            if (aviatorObject instanceof AviatorBoolean) {
                AviatorBoolean aviatorBoolean = (AviatorBoolean) aviatorObject;
                boolean flag = aviatorBoolean.booleanValue(env);
                if (flag) {
                    result = true;
                    break;
                }
            } else {
                errorInfo.append(",第" + (index + 1) + "个");
            }
        }
        AviatorExtendUtil.checkError(errorInfo, getName());
        return AviatorBoolean.valueOf(result);
    }
}
