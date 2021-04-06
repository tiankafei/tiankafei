package org.tiankafei.aviator.extend.function;

import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.tiankafei.aviator.extend.constant.FunctionConstants;
import org.tiankafei.aviator.extend.util.AviatorExtendUtil;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Slf4j
public class AndMore extends MoreParamFunction {

    @Override
    public String getName() {
        return FunctionConstants.AND_MORE;
    }

    @Override
    public AviatorObject apply(List<Object> valueList) {
        boolean result = true;
        StringBuilder errorInfo = new StringBuilder();
        for (int index = 0, length = valueList.size(); index < length; index++) {
            Object object = valueList.get(index);
            if (object instanceof Boolean) {
                boolean flag = (boolean) object;
                if (!flag) {
                    result = false;
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
