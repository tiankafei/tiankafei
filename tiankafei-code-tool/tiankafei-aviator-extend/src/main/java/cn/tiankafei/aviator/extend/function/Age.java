package cn.tiankafei.aviator.extend.function;

import cn.tiankafei.aviator.extend.constant.FunctionConstants;
import cn.tiankafei.aviator.extend.exception.AviatorException;
import cn.tiankafei.aviator.extend.util.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorBigInt;
import com.googlecode.aviator.runtime.type.AviatorObject;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author 魏双双
 * @Date 2020/6/2
 * @Version V1.0
 **/
public class Age extends MoreParamFunction {
    @Override
    public String getName() {
        return FunctionConstants.AGE;
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
        return super.call(env, arg1, arg2);
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4) {
        return super.call(env, arg1, arg2, arg3, arg4);
    }

    @Override
    public AviatorObject apply(List<Object> dataList) {
        if (dataList.get(0) == null || dataList.get(1) == null) {
            return AviatorBigInt.valueOf(0);
        }
        String year = dataList.get(0).toString();
        String month = dataList.get(1).toString();
        int yearInt = 0;
        if (StringUtils.isNotEmpty(year)) {
            if (FunctionUtils.isNumerics(year)) {
                yearInt = (int) Double.parseDouble(year);
            } else {
                throw new AviatorException(getName() + "函数传入的年份只能是数字，请确认!");
            }
        }
        int monthInt = 0;
        if (StringUtils.isNotEmpty(month)) {
            if (FunctionUtils.isNumerics(month)) {
                monthInt = (int) Double.parseDouble(month);
            } else {
                throw new AviatorException(getName() + "函数传入的月份只能是数字，请确认!");
            }
        }
        //取得系统时间
        Calendar cal = Calendar.getInstance();
        int currentYear = cal.get(Calendar.YEAR);
        int currentMonth = cal.get(Calendar.MONTH) + 1;
        int paramCount = 4;
        if (dataList.size() == paramCount) {
            if (dataList.get(2) != null) {
                if (StringUtils.isNotEmpty(dataList.get(2).toString())) {
                    if (FunctionUtils.isNumerics(dataList.get(2).toString())) {
                        currentYear = Integer.parseInt(dataList.get(2).toString());
                    } else {
                        throw new AviatorException(getName() + "函数传入的年份只能是数字，请确认!");
                    }
                }
            }
            if (dataList.get(3) != null) {
                if (StringUtils.isNotEmpty(dataList.get(3).toString())) {
                    if (FunctionUtils.isNumerics(dataList.get(3).toString())) {
                        currentMonth = Integer.parseInt(dataList.get(3).toString());
                    } else {
                        throw new AviatorException(getName() + "函数传入的月份只能是数字，请确认!");
                    }
                }
            }
        }
        int age = 0;
        if (currentMonth - monthInt < 0) {
            age = currentYear - yearInt - 1;
        } else {
            age = currentYear - yearInt;
        }
        return AviatorBigInt.valueOf(age);
    }
}
