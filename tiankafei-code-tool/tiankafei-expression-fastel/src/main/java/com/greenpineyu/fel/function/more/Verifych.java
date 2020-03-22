package com.greenpineyu.fel.function.more;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseMore;

/**
 * VERIFYCH函数
 * 描述：能检测的功能有：
 * (1)用于检查字符串中的中文个数
 * (2)是否出现特定的字符
 * (3)是否必须全为汉字
 * 语法：VERIFYCH(单元格/行/列,最少汉字个数,关键词,是否全为中文)。
 * 例如：VERIFYCH([3|2],"2","北京","1")
 * VERIFYCH([3|2],"0","","0")
 * VERIFYCH([3|2],"2","公司","0")
 * ....
 * 参数说明：有四个参数
 * (1)待检验的[单元格/行/列]
 * (2)[单元格/行/列] 中汉字最少必须有多少个
 * (3)指明要判断是否在[单元格/行/列] 中出现的特定字符
 * (4)[单元格/行/列] 是否必须全是汉字 "1" 表示全为汉字 "0" 表示不全为汉字
 *
 * @author tiankafei
 */
public class Verifych extends BaseMore {

    @Override
    public String getName() {
        return FunctionConstants.VERIFYCH;
    }

}
