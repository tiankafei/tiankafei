package com.greenpineyu.fel.function.one;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseOne;

/**
 * TRIM(text)：清除文本中所有空格，单词间的单个空格除外，也可用于带有不规则空格的文本。
 * text：需要清除空格的文本。
 * 示例：
 * TRIM(" Monthly Report") 返回“Monthly Report”
 *
 * @author tiankafei
 */
public class Trim extends BaseOne {

    @Override
    public String getName() {
        return FunctionConstants.TRIM;
    }
}
