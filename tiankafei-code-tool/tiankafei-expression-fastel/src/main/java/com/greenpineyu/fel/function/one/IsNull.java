package com.greenpineyu.fel.function.one;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseOne;

/**
 * ISNULL(test)：判断文本字符串是否为空，如果为空返回TRUE，如果不为空则返回FALSE。
 * test：需要进行判断的字符串。
 * 示例：
 * ISNULL("abc") 返回FALSE
 * ISNULL("") 返回TRUE
 *
 * @author tiankafei
 */
public class IsNull extends BaseOne {

    @Override
    public String getName() {
        return FunctionConstants.IS_NULL;
    }
}
