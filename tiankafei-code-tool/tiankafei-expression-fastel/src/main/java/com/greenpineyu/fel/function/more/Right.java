package com.greenpineyu.fel.function.more;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseMore;

/**
 * RIGHT(text,num_chars)：根据指定的字符数从右开始返回文本串中的最后一个或几个字符。
 * text：需要提取字符的文本串。
 * num_chars：指定RIGHT函数从文本串中提取的字符数，必须等于或大于0。
 * 示例：
 * RIGHT("Huge sale",4) 返回“sale”
 *
 * @author tiankafei
 */
public class Right extends BaseMore {

    @Override
    public String getName() {
        return FunctionConstants.RIGHT;
    }

}
