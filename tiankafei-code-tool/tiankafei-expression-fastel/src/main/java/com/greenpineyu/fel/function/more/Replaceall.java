package com.greenpineyu.fel.function.more;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseMore;

/**
 * 字符串替换函数 返回将源串中的匹配项全部替换为替换项之后的新串
 * 语法
 * REPLACEALL(text, regex, replacement)
 * text 源字符串
 * regex 匹配项字符串
 * replacement 替换字符串
 *
 * @author tiankafei
 */
public class Replaceall extends BaseMore {

    @Override
    public String getName() {
        return FunctionConstants.REPLACEALL;
    }

}
