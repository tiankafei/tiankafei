package cn.tiankafei.aviator.extend.function;

import cn.tiankafei.aviator.extend.constant.FunctionConstants;
import cn.tiankafei.aviator.extend.util.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author 魏双双
 * @Date 2020/6/1
 * @Version V1.0
 **/
public class VerifyIdCard extends OneParamFunction {

    private static final String idCardSuffix = "0123456789X";

    private static Map<String, String> provinceMap = new HashMap<String, String>();
    private static Map<Integer, Integer> provinceCoefficientMap = new HashMap<Integer, Integer>();
    private static Map<Integer, String> provinceRemainderMap = new HashMap<Integer, String>();

    static {
        provinceMap.put("11", "");
        provinceMap.put("12", "");
        provinceMap.put("13", "");
        provinceMap.put("14", "");
        provinceMap.put("15", "");
        provinceMap.put("21", "");
        provinceMap.put("22", "");
        provinceMap.put("23", "");
        provinceMap.put("31", "");
        provinceMap.put("32", "");
        provinceMap.put("33", "");
        provinceMap.put("34", "");
        provinceMap.put("35", "");
        provinceMap.put("36", "");
        provinceMap.put("37", "");
        provinceMap.put("41", "");
        provinceMap.put("42", "");
        provinceMap.put("43", "");
        provinceMap.put("44", "");
        provinceMap.put("45", "");
        provinceMap.put("46", "");
        provinceMap.put("50", "");
        provinceMap.put("51", "");
        provinceMap.put("52", "");
        provinceMap.put("53", "");
        provinceMap.put("54", "");
        provinceMap.put("61", "");
        provinceMap.put("62", "");
        provinceMap.put("63", "");
        provinceMap.put("64", "");
        provinceMap.put("65", "");
        provinceMap.put("71", "");
        provinceMap.put("81", "");
        provinceMap.put("82", "");

        provinceCoefficientMap.put(1, 7);
        provinceCoefficientMap.put(2, 9);
        provinceCoefficientMap.put(3, 10);
        provinceCoefficientMap.put(4, 5);
        provinceCoefficientMap.put(5, 8);
        provinceCoefficientMap.put(6, 4);
        provinceCoefficientMap.put(7, 2);
        provinceCoefficientMap.put(8, 1);
        provinceCoefficientMap.put(9, 6);
        provinceCoefficientMap.put(10, 3);
        provinceCoefficientMap.put(11, 7);
        provinceCoefficientMap.put(12, 9);
        provinceCoefficientMap.put(13, 10);
        provinceCoefficientMap.put(14, 5);
        provinceCoefficientMap.put(15, 8);
        provinceCoefficientMap.put(16, 4);
        provinceCoefficientMap.put(17, 2);

        provinceRemainderMap.put(0, "1");
        provinceRemainderMap.put(1, "0");
        provinceRemainderMap.put(2, "X");
        provinceRemainderMap.put(3, "9");
        provinceRemainderMap.put(4, "8");
        provinceRemainderMap.put(5, "7");
        provinceRemainderMap.put(6, "6");
        provinceRemainderMap.put(7, "5");
        provinceRemainderMap.put(8, "4");
        provinceRemainderMap.put(9, "3");
        provinceRemainderMap.put(10, "2");
    }

    @Override
    protected AviatorObject apply(Object object) {
        if (object == null || StringUtils.isBlank(object.toString())) {
            return AviatorBoolean.valueOf(Boolean.FALSE);
        }
        String verifyIdCard = object.toString();
        if (verifyIdCard.length() != 18) {
            return AviatorBoolean.valueOf(Boolean.FALSE);
        }
        //验证前17位是数字
        String prefix = verifyIdCard.substring(0, 17);
        if (!FunctionUtils.isNumerics(prefix)) {
            return AviatorBoolean.valueOf(Boolean.FALSE);
        }
        //验证最后一位是0-9和X
        String suffix = verifyIdCard.substring(17);
        if (!idCardSuffix.contains(suffix)) {
            return AviatorBoolean.valueOf(Boolean.FALSE);
        }
        //验证前两位是省码
        String province = verifyIdCard.substring(0, 2);
        if (!provinceMap.containsKey(province)) {
            return AviatorBoolean.valueOf(Boolean.FALSE);
        }
        //验证年份的范围
        int tempYear = Integer.parseInt(verifyIdCard.substring(6, 10));
        int year = Calendar.getInstance().get(Calendar.YEAR);
        if (tempYear < 1890 || tempYear > year) {
            return AviatorBoolean.valueOf(Boolean.FALSE);
        }
        //身份证第十八位数字的校验方法
        int sum = 0;
        for (int index = 0, length = prefix.length(); index < length; index++) {
            String str = prefix.substring(index, index + 1);
            int value = Integer.parseInt(str);
            sum += value * provinceCoefficientMap.get(index + 1);
        }
        //余数
        int remainderValue = sum % 11;
        if (!suffix.equals(provinceRemainderMap.get(remainderValue))) {
            return AviatorBoolean.valueOf(Boolean.FALSE);
        }
        return AviatorBoolean.valueOf(Boolean.TRUE);
    }

    @Override
    public String getName() {
        return FunctionConstants.VERIFYIDCARD;
    }
}
