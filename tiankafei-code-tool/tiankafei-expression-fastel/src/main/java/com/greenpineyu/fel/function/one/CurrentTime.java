package com.greenpineyu.fel.function.one;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseOne;

/**
 * 年的表示形式yyyy
 * 月的表示形式MM
 * 日的表示形式dd
 * 时的表示形式HH
 * 分的表示形式mm
 * 秒的表示形式ss
 * 如：yyyy-MM-dd HH:mm:ss
 * 如：yyyy/MM/dd HH:mm:ss
 * 如：yyyy年MM月dd日HH时mm分ss秒
 * Created by WeiShuangShuang on 2016/10/27.
 *
 * @author tiankafei
 */
public class CurrentTime extends BaseOne {

    @Override
    public String getName() {
        return FunctionConstants.CURRENTTIME;
    }
}
