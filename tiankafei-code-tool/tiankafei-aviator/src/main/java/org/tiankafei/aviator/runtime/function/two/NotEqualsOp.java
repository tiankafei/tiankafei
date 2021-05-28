package org.tiankafei.aviator.runtime.function.two;

import com.googlecode.aviator.lexer.token.OperatorType;

/**
 * @author tiankafei
 */
public class NotEqualsOp extends NotEquals {

    @Override
    public String getName() {
        return OperatorType.NEQ.token;
    }

}
