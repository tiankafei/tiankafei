package com.greenpineyu.fel.function.one;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseOne;

/**
 * NOTNULL(test)：判断文本字符串是否不为空，如果不为空返回TRUE，如果为空则返回FALSE。
 * test：需要进行判断的字符串。
 * 示例：
 * NOTNULL("abc") 返回TRUE
 * NOTNULL("") 返回FALSE
 *
 * @author tiankafei
 * @author tiankafei
 */
public class NotNull extends BaseOne {

    @Override
    public String getName() {
        return FunctionConstants.NOT_NULL;
    }
}
