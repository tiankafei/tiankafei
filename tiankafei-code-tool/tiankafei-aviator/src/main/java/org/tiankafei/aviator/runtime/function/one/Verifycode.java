package org.tiankafei.aviator.runtime.function.one;

import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.aviator.constant.AviatorConstants;

/**
 * 组织机构代码校验函数
 *
 * @author tiankafei
 */
public class Verifycode extends OneParamFunction {

    @Override
    public String getName() {
        return AviatorConstants.FUNCTION_VERIFY_CODE;
    }

    @Override
    protected AviatorObject apply(Object object) {
        if (object == null || StringUtils.isBlank(object.toString())) {
            return AviatorBoolean.valueOf(Boolean.FALSE);
        }
        Boolean result = Boolean.FALSE;
        String code = object.toString();
        //长度为9
        if (code.length() == 9) {
            String code12 = code.substring(0, 2);
            String code38 = code.substring(2, 8);
            String code9 = code.substring(8, 9);
            //1-2位是大写字母或数字
            if (code12.matches("[A-Z_0-9]{2}")) {
                //3-8位是数字
                if (code38.matches("[0-9]{6}")) {
                    //A-65-17-7=10
                    //Z-91-42-7=35
                    char[] codeArray = code.toCharArray();
                    int[] codeInt = new int[8];
                    for (int i = 0; i < codeArray.length - 1; i++) {
                        codeInt[i] = ((int) codeArray[i]) - 48;
                    }

                    //9位通过前八位计算的值 在{123456789X0}中获取
                    //A=10;B=11;C=12......
                    //第一位*3+第二位*7+第三位*9......
                    int calCode9 = 11 -
                            ((codeInt[0] > 16 ? codeInt[0] - 7 :
                                    codeInt[0]) * 3
                                    +
                                    (codeInt[1] > 16 ? codeInt[1] - 7 :
                                            codeInt[1]) * 7
                                    + codeInt[2] * 9 + codeInt[3] * 10 +
                                    codeInt[4] * 5 + codeInt[5] * 8 +
                                    codeInt[6] * 4 + codeInt[7] * 2) % 11;

                    if (code9.equals("123456789X0".substring(calCode9 - 1, calCode9))) {
                        result = true;
                    }
                }
            }
        }
        return AviatorBoolean.valueOf(result.booleanValue());
    }

}
