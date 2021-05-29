package org.tiankafei.aviator.runtime.function.special;

import com.googlecode.aviator.runtime.type.AviatorNil;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import java.util.Calendar;
import java.util.Map;
import org.tiankafei.aviator.constant.AviatorConstants;
import org.tiankafei.aviator.util.AviatorUtil;

/**
 * 计算年龄
 *
 * @author tiankafei
 */
public class Age extends SpecialFunction {

    @Override
    public String getName() {
        return AviatorConstants.FUNCTION_AGE;
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
        Object year = getValue(env, arg1);
        Object month = getValue(env, arg2);

        if (AviatorUtil.isNumerics(year) && AviatorUtil.isNumerics(month)) {
            //取得系统时间
            Calendar cal = Calendar.getInstance();
            int currentYear = cal.get(Calendar.YEAR);
            int currentMonth = cal.get(Calendar.MONTH) + 1;

            Integer age = computeAge(Integer.valueOf(year.toString()),
                    Integer.valueOf(month.toString()),
                    currentYear, currentMonth);

            return AviatorRuntimeJavaType.valueOf(age);
        }
        return AviatorNil.NIL;
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4) {
        Object year = getValue(env, arg1);
        Object month = getValue(env, arg2);
        Object standYear = getValue(env, arg3);
        Object standMonth = getValue(env, arg4);

        if (AviatorUtil.isNumerics(year)
                && AviatorUtil.isNumerics(month)
                && AviatorUtil.isNumerics(standYear)
                && AviatorUtil.isNumerics(standMonth)) {

            Integer age = computeAge(Integer.valueOf(year.toString()),
                    Integer.valueOf(month.toString()),
                    Integer.valueOf(standYear.toString()),
                    Integer.valueOf(standMonth.toString()));

            return AviatorRuntimeJavaType.valueOf(age);
        }
        return AviatorNil.NIL;
    }

    private Integer computeAge(Integer year, Integer month, Integer standYear, Integer standMonth) {
        int age = 0;
        if (standMonth - month < 0) {
            age = standYear - year - 1;
        } else {
            age = standYear - year;
        }
        return age;
    }

}
