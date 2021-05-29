package org.tiankafei.aviator.runtime.function.other;

import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;
import java.util.List;
import org.tiankafei.aviator.constant.AviatorConstants;

/**
 * 第一个值是否在后面的值当中：在返回true，否则返回false
 *
 * @author tiankafei
 */
public class InList extends MoreParamFunction {

    @Override
    public String getName() {
        return AviatorConstants.FUNCTION_IN_LIST;
    }

    @Override
    public AviatorObject apply(List<Object> dataList) {
        int length = dataList.size();
        if (length > 1) {
            Object value = dataList.get(0);
            if (value == null) {
                value = "";
            }
            for (int index = 1; index < length; index++) {
                Object object = dataList.get(index);
                if (value.equals(object == null ? "" : object.toString())) {
                    return AviatorBoolean.TRUE;
                }
            }
        }
        return AviatorBoolean.FALSE;
    }

}
