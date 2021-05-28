package org.tiankafei.aviator.runtime.function.two;

import com.googlecode.aviator.lexer.token.OperatorType;

/**
 * @author tiankafei
 */
public class LessThenOp extends LessThen {

    @Override
    public String getName() {
        return OperatorType.LT.token;
    }

}
