package com.greenpineyu.fel.function.one;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseOne;

/**
 * NOT(logical)：对参数的逻辑值求反，参数为TRUE时返回FALSE，参数为FALSE时返回TRUE
 * logical：表示计算结果为TRUE或FALSE的任意值或逻辑表达式。
 * 示例：
 * NOT(2>3) 返回TRUE
 * NOT(2+3>4) 返回FALSE
 *
 * @author tiankafei
 */
public class Not extends BaseOne {

    @Override
    public String getName() {
        return FunctionConstants.NOT;
    }
}
