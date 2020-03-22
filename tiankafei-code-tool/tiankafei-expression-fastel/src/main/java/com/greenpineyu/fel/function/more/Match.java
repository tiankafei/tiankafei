package com.greenpineyu.fel.function.more;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseMore;

/**
 * 正则表达式函数:根据正则表达式模式，判断文本字符串是否完全匹配
 * 语法
 * MATCH(text_pattern,text_matcher)
 * text_pattern 正则表达式模式
 * text_matcher 文本字符串
 *
 * @author tiankafei
 */
public class Match extends BaseMore {

    @Override
    public String getName() {
        return FunctionConstants.MATCH;
    }

}
