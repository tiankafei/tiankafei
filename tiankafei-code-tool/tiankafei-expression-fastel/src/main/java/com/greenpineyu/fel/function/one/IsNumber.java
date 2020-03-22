package com.greenpineyu.fel.function.one;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseOne;

/**
 * ISNUM(test)：判断文本字符串是否全部为数字，如果是返回TRUE，否则返回FALSE。
 * test：需要进行判断的文本字符串。
 * 示例：
 * ISNUM("567") 返回TRUE
 * ISNUM("abc3") 返回FALSE
 *
 * @author tiankafei
 */
public class IsNumber extends BaseOne {

    @Override
    public String getName() {
        return FunctionConstants.IS_NUMBER;
    }
}
