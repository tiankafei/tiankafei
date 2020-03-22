package com.greenpineyu.fel.function.more;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseMore;

/**
 * IF(logical,value_if_true,value_if_false)：判断一个条件是否满足，如果满足返回一个值，如果不满足则返回另一个值。
 * logical：表示计算结果为TRUE或FALSE的任意值或逻辑表达式。
 * value_if_true：logical为TRUE时返回的值。
 * value_if_false：logical为FALSE时返回的值。
 * 示例：
 * IF(3>2,1,-1) 返回1
 * IF(2+3>6,1,-1) 返回-1
 *
 * @author tiankafei
 */
public class If extends BaseMore {

    @Override
    public String getName() {
        return FunctionConstants.IF;
    }

}
