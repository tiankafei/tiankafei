package com.greenpineyu.fel.function.more;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseMore;

/**
 * OR(logical1,logical2,...)：在其参数组中，任何一个参数逻辑值为TRUE，即返回TRUE；任何一个参数的逻辑值为FALSE，即返回FALSE。
 * Logical1,logical2,...：为需要进行检验的一个或者多个条件，分别为TRUE或者FALSE。
 * 示例：
 * OR(3=3) 返回TRUE
 * OR(1+1=1,2+2=5) 返回FALSE，所有参数的逻辑值为FALSE
 * OR(1+2=3,2+2=5) 返回TRUE，其中一个参数的逻辑值为TRUE
 *
 * @author tiankafei
 */
public class Or extends BaseMore {

    @Override
    public String getName() {
        return FunctionConstants.OR_MORE;
    }
}
