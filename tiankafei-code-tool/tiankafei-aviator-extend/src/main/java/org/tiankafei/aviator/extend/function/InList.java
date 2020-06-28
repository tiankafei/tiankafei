package org.tiankafei.aviator.extend.function;

import org.tiankafei.aviator.extend.constant.FunctionConstants;
import org.tiankafei.aviator.extend.exception.AviatorException;
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 魏双双
 * @Date 2020/6/2
 * @Version V1.0
 **/
public class InList extends MoreParamFunction {

    @Override
    public String getName() {
        return FunctionConstants.INLIST;
    }

    @Override
    public AviatorObject apply(List<Object> dataList) {
        int length = dataList.size();
        if (length > 1) {
            Object value = dataList.get(0);
            if (value == null) {
                return AviatorBoolean.FALSE;
            }
            List<String> tempList = new ArrayList<>();
            for (int index = 1; index < length; index++) {
                Object object = dataList.get(index);
                if (object != null) {
                    tempList.add(object.toString());
                }
            }
            return AviatorBoolean.valueOf(tempList.contains(value.toString()));
        }
        throw new AviatorException(getName() + "参数个数不正确，请确认!");
    }
}
