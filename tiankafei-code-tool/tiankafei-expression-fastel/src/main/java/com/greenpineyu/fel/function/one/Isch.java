package com.greenpineyu.fel.function.one;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseOne;

/**
 * ISCH(test)：判断文本字符串是否全部为汉字，如果是返回TRUE，否则返回FALSE。
 * test：需要进行判断的文本字符串。
 * 示例：
 * ISCH("制度") 返回TRUE
 * ISCH("报表101") 返回FALSE
 *
 * @author tiankafei
 */
public class Isch extends BaseOne {

    @Override
    public String getName() {
        return FunctionConstants.ISCH;
    }
}
