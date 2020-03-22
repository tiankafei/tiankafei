package com.greenpineyu.fel.function.more;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseMore;

/**
 * INLIST(text,text1_list,text2_list,...)：判断文本字符串是否在列表中，在列表中返回TRUE，否则返回FALSE。
 * text：需要进行判断的文本字符串。
 * text1_list,text2_list,...：字符串列表。
 * 示例：
 * INLIST("02","02") 返回TRUE
 * INLIST("06","03","06","09") 返回TRUE
 * INLIST("23","16","33") 返回FALSE
 *
 * @author tiankafei
 */
public class InList extends BaseMore {

    @Override
    public String getName() {
        return FunctionConstants.INLIST;
    }

}
