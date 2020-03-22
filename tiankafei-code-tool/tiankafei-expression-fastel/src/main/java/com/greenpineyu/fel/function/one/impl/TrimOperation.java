package com.greenpineyu.fel.function.one.impl;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.api.BaseOneOperation;

/**
 * TRIM(text)：清除文本中所有空格，单词间的单个空格除外，也可用于带有不规则空格的文本。
 * text：需要清除空格的文本。
 * 示例：
 * TRIM(" Monthly Report") 返回“Monthly Report”
 *
 * @author tiankafei
 */
public class TrimOperation extends BaseOneOperation {

    private TrimOperation() {
    }

    private static class InternalClass {
        private final static BaseOneOperation INSTANCE = new TrimOperation();
    }

    public static BaseOneOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    @Override
    public Object evl(Object object, FelContext context, int location) throws Exception {
        if (object == null) {
            return "";
        }
        return object.toString().trim();
    }
}
