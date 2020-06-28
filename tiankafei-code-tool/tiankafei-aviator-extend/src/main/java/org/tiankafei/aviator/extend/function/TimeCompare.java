package org.tiankafei.aviator.extend.function;

import org.tiankafei.aviator.extend.constant.FunctionConstants;
import org.tiankafei.aviator.extend.exception.AviatorException;
import org.tiankafei.aviator.extend.util.FunctionUtils;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorDecimal;
import com.googlecode.aviator.runtime.type.AviatorObject;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author 魏双双
 * @Date 2020/6/2
 * @Version V1.0
 **/
public class TimeCompare extends AbstractFunction {
    @Override
    public String getName() {
        return FunctionConstants.TIMECOMPARE;
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4) {
        return this.call(env, Arrays.asList(arg1, arg2, arg3, arg4));
    }

    protected AviatorObject call(Map<String, Object> env, List<AviatorObject> valueList) {
        List<Object> dataList = new ArrayList<>();
        for (int index = 0, length = valueList.size(); index < length; index++) {
            AviatorObject aviatorObject = valueList.get(index);
            dataList.add(aviatorObject.getValue(env));
        }
        Object arriveHoursObj = dataList.get(0);
        Object arriveMinuteObj = dataList.get(1);
        Object leaveHoursObj = dataList.get(2);
        Object leaveMinuteObj = dataList.get(3);

        boolean flag = arriveHoursObj != null && StringUtils.isNotBlank(arriveHoursObj.toString()) && FunctionUtils.isNumerics(arriveHoursObj)
                && arriveMinuteObj != null && StringUtils.isNotBlank(arriveMinuteObj.toString()) && FunctionUtils.isNumerics(arriveMinuteObj)
                && leaveHoursObj != null && StringUtils.isNotBlank(leaveHoursObj.toString()) && FunctionUtils.isNumerics(leaveHoursObj)
                && leaveMinuteObj != null && StringUtils.isNotBlank(leaveMinuteObj.toString()) && FunctionUtils.isNumerics(leaveMinuteObj);
        if (flag) {
            int arriveHours = Integer.parseInt(arriveHoursObj.toString());
            int arriveMinute = Integer.parseInt(arriveMinuteObj.toString());
            int leaveHours = Integer.parseInt(leaveHoursObj.toString());
            int leaveMinute = Integer.parseInt(leaveMinuteObj.toString());

            if (arriveHours < 2) {
                arriveHours += 24;
            }

            return AviatorDecimal.valueOf((arriveHours * 60 + arriveMinute) - (leaveHours * 60 + leaveMinute));
        } else {
            throw new AviatorException(getName() + "传入参数不能为空且必须得是数字，请确认!");
        }
    }
}
