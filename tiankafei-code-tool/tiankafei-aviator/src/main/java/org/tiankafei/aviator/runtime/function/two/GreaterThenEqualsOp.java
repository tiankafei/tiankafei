package org.tiankafei.aviator.runtime.function.two;

import com.googlecode.aviator.lexer.token.OperatorType;

/**
 * @author tiankafei
 */
public class GreaterThenEqualsOp extends GreaterThenEquals {

    @Override
    public String getName() {
        return OperatorType.GE.token;
    }

}
