package com.greenpineyu.fel.compile;

import com.greenpineyu.fel.Expression;

/**
 * @author tiankafei
 */
public interface FelCompiler {

    /**
     * 编译代码，并创建Expression
     *
     * @param src
     * @return
     */
    public Expression compile(JavaSource src);

}
