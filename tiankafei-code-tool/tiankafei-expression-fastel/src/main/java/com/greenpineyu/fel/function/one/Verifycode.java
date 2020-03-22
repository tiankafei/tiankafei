package com.greenpineyu.fel.function.one;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseOne;

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
public class Verifycode extends BaseOne {

    @Override
    public String getName() {
        return FunctionConstants.VERIFYCODE;
    }
}
