package com.greenpineyu.fel.function.more;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseMore;

/**
 * 正则表达式函数:根据正则表达式模式，判断文本字符串是否从指定位置之后存在匹配
 * 语法
 * FIND(text_pattern,text_matcher,start)
 * text_pattern 正则表达式模式
 * text_matcher 文本字符串
 * start 指定位置
 *
 * @author tiankafei
 */
public class Find extends BaseMore {

    @Override
    public String getName() {
        return FunctionConstants.FIND;
    }

}
