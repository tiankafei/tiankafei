package org.tiankafei.aviator.runtime.function.two;

import com.googlecode.aviator.lexer.token.OperatorType;

/**
 * @author tiankafei
 */
public class SubOp extends Sub {

    @Override
    public String getName() {
        return OperatorType.SUB.token;
    }

}
