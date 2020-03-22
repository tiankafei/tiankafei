package com.greenpineyu.fel.function.one.impl;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.api.BaseOneOperation;
import org.apache.commons.lang3.StringUtils;

/**
 * 校验组织机构代码
 * 语法
 * VERIFYCODE(组织机构代码)
 * 1 长度9位
 * 2 1-2位是大写字母或数字
 * 3 3-8位是数字
 * 4 9位通过前八位计算的值 在{123456789X0}中获取
 *
 * @author tiankafei
 */
public class VerifycodeOperation extends BaseOneOperation {

    private VerifycodeOperation() {
    }

    private static class InternalClass {
        private final static BaseOneOperation INSTANCE = new VerifycodeOperation();
    }

    public static BaseOneOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    @Override
    public Object evl(Object object, FelContext context, int location) throws Exception {
        if (object == null || StringUtils.isBlank(object.toString())) {
            return Boolean.FALSE;
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
        return Boolean.valueOf(result);
    }
}
