package com.greenpineyu.fel.function.one;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseOne;

/**
 * LEN(text)：返回文本串中的字符数。
 * text：需要求其长度的文本，空格也计为字符。
 * 示例：
 * LEN("Hello") 返回5
 * LEN(" ") 返回1
 *
 * @author tiankafei
 */
public class Length extends BaseOne {

    @Override
    public String getName() {
        return FunctionConstants.LENGTH;
    }
}
