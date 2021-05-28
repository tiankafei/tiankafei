package org.tiankafei.aviator.runtime.function.two;

import com.googlecode.aviator.lexer.token.OperatorType;

/**
 * @author tiankafei
 */
public class EqualsOp extends Equals {

    @Override
    public String getName() {
        return OperatorType.EQ.token;
    }

}
