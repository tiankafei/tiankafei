package com.greenpineyu.fel.function.more;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseMore;

/**
 * INRANGE(text,start_range,end_range)：判断文本字符串是否在另一文本字符串范围内，在范围内返回TRUE，否则返回 FALSE。
 * text：需要进行范围判断的文本字符串
 * start_range：范围开始字符串。
 * end_range：范围结束字符串。
 * 示例：
 * INRANGE("05","01","12") 返回TRUE
 * INRANGE("20","20","30") 返回TRUE
 * INRANGE("abc","db","ef") 返回FALSE
 *
 * @author tiankafei
 */
public class InRange extends BaseMore {

    @Override
    public String getName() {
        return FunctionConstants.INRANGE;
    }

}
