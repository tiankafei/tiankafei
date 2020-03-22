package com.greenpineyu.fel.function.more;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseMore;

/**
 * MID(text,start_num,num_chars)：返回文本串中从指定位置开始的一定数目的字符，该数目由用户指定。
 * text：包含要提取字符的文本串。
 * start_num：文本中需要提取字符的起始位置。文本中第一个字符的start_num为1，依此类推。
 * num_chars：返回字符的长度。
 * 示例:
 * MID("Hello",1,3)返回“Hel”
 * MID("Hello Everyone",7,8)返回“Everyone”
 *
 * @author tiankafei
 */
public class Mid extends BaseMore {

    @Override
    public String getName() {
        return FunctionConstants.MID;
    }

}
