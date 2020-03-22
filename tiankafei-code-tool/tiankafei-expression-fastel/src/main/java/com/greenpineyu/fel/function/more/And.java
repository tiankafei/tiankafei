package com.greenpineyu.fel.function.more;

import com.greenpineyu.fel.function.FunctionConstants;
import com.greenpineyu.fel.function.api.BaseMore;

/**
 * AND(logical1,logical2,...)：所有参数的逻辑值为真时，返回TRUE；只要一个参数的逻辑值为假，即返回FALSE。
 * Logical1,logical2,...：为需要进行检验的一个或者多个条件，分别为TRUE或者FALSE。
 * 示例：
 * AND(3=3) 返回TRUE
 * AND(1+1=2,2+2=5) 返回FALSE，其中一个参数的逻辑值为FALSE
 * AND(1+2=3,2+2=4) 返回TRUE，所有参数的逻辑值为TRUE
 *
 * @author tiankafei
 */
public class And extends BaseMore {

    @Override
    public String getName() {
        return FunctionConstants.AND_MORE;
    }

}
