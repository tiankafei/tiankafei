package cn.tiankafei.aviator.extend.function;

import cn.tiankafei.aviator.extend.constant.FunctionConstants;
import cn.tiankafei.aviator.extend.exception.AviatorException;
import cn.tiankafei.aviator.extend.util.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDecimal;
import com.googlecode.aviator.runtime.type.AviatorObject;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author 魏双双
 * @Date 2020/6/2
 * @Version V1.0
 **/
public class TimeCompare extends MoreParamFunction {
    @Override
    public String getName() {
        return FunctionConstants.TIMECOMPARE;
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4) {
        return super.call(env, arg1, arg2, arg3, arg4);
    }

    @Override
    public AviatorObject apply(List<Object> dataList) {
        int length = dataList.size();
        int number4 = 4;
        if (length == number4) {
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
        throw new AviatorException(getName() + "传入参数数组为空或者参数个数不正确!");
    }
}
