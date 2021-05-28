package org.tiankafei.aviator.runtime.function.other;

import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;
import java.util.List;
import org.tiankafei.aviator.constant.AviatorConstants;
import org.tiankafei.aviator.util.AviatorUtil;

/**
 * @author tiankafei
 */
public class Or extends MoreParamFunction {

    @Override
    public String getName() {
        return AviatorConstants.FUNCTION_OR;
    }

    @Override
    public AviatorObject apply(List<Object> valueList) {
        boolean result = false;
        for (int index = 0, length = valueList.size(); index < length; index++) {
            Boolean value = AviatorUtil.toBooleanObj(valueList.get(index));
            if (value) {
                result = true;
                break;
            }
        }
        return AviatorBoolean.valueOf(result);
    }

}
