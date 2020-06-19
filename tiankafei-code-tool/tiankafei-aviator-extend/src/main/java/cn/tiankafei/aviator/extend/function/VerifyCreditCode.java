package cn.tiankafei.aviator.extend.function;

import cn.tiankafei.aviator.extend.constant.FunctionConstants;
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 魏双双
 * @Date 2020/6/1
 * @Version V1.0
 **/
public class VerifyCreditCode extends OneParamFunction {

    private static Map<String, Integer> characterStringMap = new HashMap<String, Integer>();
    private static Map<Integer, String> characterIntegerMap = new HashMap<Integer, String>();

    static {
        characterStringMap.put("0", 0);
        characterStringMap.put("1", 1);
        characterStringMap.put("2", 2);
        characterStringMap.put("3", 3);
        characterStringMap.put("4", 4);
        characterStringMap.put("5", 5);
        characterStringMap.put("6", 6);
        characterStringMap.put("7", 7);
        characterStringMap.put("8", 8);
        characterStringMap.put("9", 9);
        characterStringMap.put("A", 10);
        characterStringMap.put("B", 11);
        characterStringMap.put("C", 12);
        characterStringMap.put("D", 13);
        characterStringMap.put("E", 14);
        characterStringMap.put("F", 15);
        characterStringMap.put("G", 16);
        characterStringMap.put("H", 17);
        characterStringMap.put("J", 18);
        characterStringMap.put("K", 19);
        characterStringMap.put("L", 20);
        characterStringMap.put("M", 21);
        characterStringMap.put("N", 22);
        characterStringMap.put("P", 23);
        characterStringMap.put("Q", 24);
        characterStringMap.put("R", 25);
        characterStringMap.put("T", 26);
        characterStringMap.put("U", 27);
        characterStringMap.put("W", 28);
        characterStringMap.put("X", 29);
        characterStringMap.put("Y", 30);

        characterIntegerMap.put(0, "0");
        characterIntegerMap.put(1, "1");
        characterIntegerMap.put(2, "2");
        characterIntegerMap.put(3, "3");
        characterIntegerMap.put(4, "4");
        characterIntegerMap.put(5, "5");
        characterIntegerMap.put(6, "6");
        characterIntegerMap.put(7, "7");
        characterIntegerMap.put(8, "8");
        characterIntegerMap.put(9, "9");
        characterIntegerMap.put(10, "A");
        characterIntegerMap.put(11, "B");
        characterIntegerMap.put(12, "C");
        characterIntegerMap.put(13, "D");
        characterIntegerMap.put(14, "E");
        characterIntegerMap.put(15, "F");
        characterIntegerMap.put(16, "G");
        characterIntegerMap.put(17, "H");
        characterIntegerMap.put(18, "J");
        characterIntegerMap.put(19, "K");
        characterIntegerMap.put(20, "L");
        characterIntegerMap.put(21, "M");
        characterIntegerMap.put(22, "N");
        characterIntegerMap.put(23, "P");
        characterIntegerMap.put(24, "Q");
        characterIntegerMap.put(25, "R");
        characterIntegerMap.put(26, "T");
        characterIntegerMap.put(27, "U");
        characterIntegerMap.put(28, "W");
        characterIntegerMap.put(29, "X");
        characterIntegerMap.put(30, "Y");
        characterIntegerMap.put(31, "0");
    }

    @Override
    protected AviatorObject apply(Object object) {
        if (object == null || StringUtils.isBlank(object.toString())) {
            return AviatorBoolean.FALSE;
        }
        String verifycreditcode = object.toString();
        if (verifycreditcode.length() == 18) {
            int length = 17;
            int[] c = new int[length];
            int[] w = new int[length];
            for (int i = 0; i < length; i++) {
                String value = verifycreditcode.substring(i, i + 1);
                if (characterStringMap.containsKey(value)) {
                    c[i] = characterStringMap.get(value);

                    int productResult = 1;
                    //3的（i-1）次幂
                    for (int j = 0; j < i; j++) {
                        productResult *= 3;
                    }
                    //求31的余数
                    w[i] = productResult % 31;
                } else {
                    return AviatorBoolean.FALSE;
                }
            }

            int sum = 0;
            //求总数
            for (int i = 0; i < length; i++) {
                sum += c[i] * w[i];
            }
            //根据公式求得标准值
            int standardValue = 31 - sum % 31;
            try {
                //传入码的最后一位
                String endValue = verifycreditcode.substring(17, 18);
                if (endValue.equals(characterIntegerMap.get(standardValue))) {
                    return AviatorBoolean.TRUE;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return AviatorBoolean.FALSE;
    }

    @Override
    public String getName() {
        return FunctionConstants.VERIFYCREDITCODE;
    }
}
