package org.tiankafei.aviator.runtime.function.two;

import com.googlecode.aviator.lexer.token.OperatorType;

/**
 * @author tiankafei
 */
public class GreaterThenOp extends GreaterThen {

    @Override
    public String getName() {
        return OperatorType.GT.token;
    }

}
