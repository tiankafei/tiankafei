package com.greenpineyu.fel.function.more.impl;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.api.BaseMoreOperation;
import java.util.ArrayList;
import java.util.List;

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
public class InListOperation extends BaseMoreOperation {

    private InListOperation() {
    }

    private static class InternalClass {
        private final static BaseMoreOperation INSTANCE = new InListOperation();
    }

    public static BaseMoreOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    @Override
    public Object evl(List<Object> dataList, FelContext context, int location) throws Exception {
        int length = dataList.size();
        if (length > 1) {
            Object value = dataList.get(0);
            if (value == null) {
                return Boolean.FALSE;
            }
            List<String> tempList = new ArrayList<>();
            for (int index = 1; index < length; index++) {
                Object object = dataList.get(index);
                if (object != null) {
                    tempList.add(object.toString());
                }
            }
            return tempList.contains(value.toString());
        }
        throw new NullPointerException("传入参数数组为空或者参数个数不正确!");
    }
}
