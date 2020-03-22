package com.greenpineyu.fel.function.more;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseMore;

/**
 * YEAR函数
 * 描述：用于检测年份
 * 语法：YEAR(单元格/行/列,CURRENTBGQFULL(),"0")
 * 返回：TRUE OR FALSE
 * 参数说明：有三个参数
 * (1)要检测的年份
 * (2)CURRENTBGQFULL() 当前报告期全称
 * (3)截止年份标识
 * "0" 判断年份是否在1800年到当前报告期所在的年份 [1800,当前报告期]
 * "1" 判断年份是否大于等于1800年 [1800,]
 * "2" 判断年份是否大于等当前报告期所在的年份 [当前报告期,]
 *
 * @author tiankafei
 */
public class Year extends BaseMore {

    @Override
    public String getName() {
        return FunctionConstants.YEAR;
    }

}
