package cn.tiankafei.aviator.extend.function;

import cn.tiankafei.aviator.extend.constant.FunctionConstants;
import cn.tiankafei.aviator.extend.exception.AviatorException;
import cn.tiankafei.aviator.extend.util.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDecimal;
import com.googlecode.aviator.runtime.type.AviatorNil;
import com.googlecode.aviator.runtime.type.AviatorObject;
import java.util.List;

/**
 * @Author 魏双双
 * @Date 2020/6/2
 * @Version V1.0
 **/
public class Min extends MoreParamFunction {

    @Override
    public String getName() {
        return FunctionConstants.MIN;
    }

    @Override
    public AviatorObject apply(List<Object> dataList) {
        int length = dataList.size();
        if (length > 0) {
            Double standValue = null;
            Integer maxLocation = 0;
            for (int index = 0; index < length; index++) {
                Object object = dataList.get(index);

                Double temp = null;
                if (FunctionUtils.isString(object)) {
                    if (FunctionUtils.isNumerics(object.toString())) {
                        temp = Double.parseDouble(object.toString());
                    } else {
                        throw new AviatorException(getName() + "函数传入的数据类型错误，请确认！");
                    }
                } else if (object instanceof Number) {
                    temp = Double.parseDouble(object.toString());
                }
                if (temp == null) {
                    throw new AviatorException(getName() + "函数传入的数据类型错误，请确认！");
                }
                if (index == 0) {
                    //记录标准值
                    standValue = temp;
                    maxLocation = index;
                } else {
                    //进行比较
                    if (standValue > temp) {
                        standValue = temp;
                        maxLocation = index;
                    }
                }
            }
            return AviatorDecimal.valueOf(dataList.get(maxLocation));
        }
//        throw new AviatorException(getName() + "传入参数数组为空或者参数个数不正确!");
        return AviatorNil.NIL;
    }
}
