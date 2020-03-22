package com.greenpineyu.fel.function.one.impl;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.function.api.BaseOneOperation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 获取当前系统时间函数：
 * 年的表示形式yyyy
 * 月的表示形式MM
 * 日的表示形式dd
 * 时的表示形式HH
 * 分的表示形式mm
 * 秒的表示形式ss
 * 如：yyyy-MM-dd HH:mm:ss
 * 如：yyyy/MM/dd HH:mm:ss
 * 如：yyyy年MM月dd日HH时mm分ss秒
 * 例：CURRENTTIME("yyyy-MM-dd HH:mm:ss")
 * 例：CURRENTTIME("yyyy/MM/dd HH:mm:ss")
 * 例：CURRENTTIME("yyyy年MM月dd日HH时mm分ss秒")
 *
 * @author tiankafei
 */
public class CurrentTimeOperation extends BaseOneOperation {

    private CurrentTimeOperation() {
    }

    private static class InternalClass {
        private final static BaseOneOperation INSTANCE = new CurrentTimeOperation();
    }

    public static BaseOneOperation getInstance() {
        return InternalClass.INSTANCE;
    }

    @Override
    public Object evl(Object object, FelContext context, int location) throws Exception {
        if (object != null) {
            String param = object.toString();
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(param);
            return localDateTime.format(formatter);
        }
        throw new Exception("数据类型错误，请确认！");
    }
}
