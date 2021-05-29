package org.tiankafei.aviator.runtime.function.other;

import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import java.util.List;
import org.tiankafei.aviator.constant.AviatorConstants;
import org.tiankafei.aviator.util.AviatorUtil;

/**
 * @author tiankafei
 */
public class MinIndex extends MoreParamFunction {

    @Override
    public String getName() {
        return AviatorConstants.FUNCTION_MIN_INDEX;
    }

    @Override
    public AviatorObject apply(List<Object> valueList) {
        int maxLocation = 0;

        Double value = AviatorUtil.objectToDouble(valueList.get(0));
        for (int index = 1, length = valueList.size(); index < length; index++) {
            Double right = AviatorUtil.objectToDouble(valueList.get(index));
            if(value != null && right != null){
                if(value > right){
                    value = right;
                    maxLocation = index;
                }
            }
        }

        return AviatorRuntimeJavaType.valueOf(maxLocation);
    }
    
}
