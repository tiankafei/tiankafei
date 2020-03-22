package com.greenpineyu.fel.function.one;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseOne;

/**
 * ISEN(test)：判断文本字符串是否全部为英文字母，如果是返回TRUE，否则返回FALSE。
 * test：需要进行判断的文本字符串。
 * 示例：
 * ISEN("abc") 返回TRUE
 * ISEN("def5") 返回FALSE
 *
 * @author tiankafei
 */
public class Isen extends BaseOne {

    @Override
    public String getName() {
        return FunctionConstants.ISEN;
    }
}
