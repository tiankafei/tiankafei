package org.tiankafei.aviator.runtime.function.one;

import com.googlecode.aviator.lexer.token.OperatorType;

/**
 * @author tiankafei
 */
public class NotOp extends Not {

    @Override
    public String getName() {
        return OperatorType.NOT.token;
    }

}
