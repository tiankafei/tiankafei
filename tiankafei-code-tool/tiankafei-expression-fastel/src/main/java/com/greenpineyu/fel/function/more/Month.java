package com.greenpineyu.fel.function.more;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseMore;

/**
 * MONTH函数
 * 描述：用于检测月份，判断年份是否在[1,12]之间
 * 语法：MONTH(单元格/行/列,CURRENTBGQFULL(),"1")
 * 返回：TRUE OR FALSE
 * 参数说明：有三个参数
 * (1)要检测的月份单元格/行/列
 * (2)CURRENTBGQFULL() 当前报告期全称
 * (3)截止月份标识
 * "0" 判断月份份是否在[1,当前报告期月份]
 * "1" 判断月份是否在[1,12]之间
 * "2" 判断月份是否在[当前报告期月份,12]
 *
 * @author tiankafei
 */
public class Month extends BaseMore {

    @Override
    public String getName() {
        return FunctionConstants.MONTH;
    }

}
