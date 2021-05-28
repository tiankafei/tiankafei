package org.tiankafei.aviator.runtime.function.other;

import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;
import java.util.List;
import org.tiankafei.aviator.constant.AviatorConstants;
import org.tiankafei.aviator.util.AviatorUtil;

/**
 * @author tiankafei
 */
public class And extends MoreParamFunction {

    @Override
    public String getName() {
        return AviatorConstants.FUNCTION_AND;
    }

    @Override
    public AviatorObject apply(List<Object> valueList) {
        boolean result = true;
        for (int index = 0, length = valueList.size(); index < length; index++) {
            Boolean value = AviatorUtil.toBooleanObj(valueList.get(index));
            if (!value) {
                result = false;
                break;
            }
        }
        return AviatorBoolean.valueOf(result);
    }

}
