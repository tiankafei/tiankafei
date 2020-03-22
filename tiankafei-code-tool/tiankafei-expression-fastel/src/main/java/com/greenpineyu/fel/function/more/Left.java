package com.greenpineyu.fel.function.more;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseMore;

/**
 * LEFT(text,num_chars)：根据指定的字符数返回文本串中的第一个或前几个字符。
 * text：需要选取字符的文本串。
 * num_chars：指定返回的字符串长度，必须等于或大于0。
 * 示例：
 * LEFT("Hello Everyone",5) 返回“Hello”。
 *
 * @author tiankafei
 */
public class Left extends BaseMore {

    @Override
    public String getName() {
        return FunctionConstants.LEFT;
    }

}
