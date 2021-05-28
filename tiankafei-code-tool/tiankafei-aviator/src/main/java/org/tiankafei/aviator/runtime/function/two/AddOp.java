package org.tiankafei.aviator.runtime.function.two;

import com.googlecode.aviator.lexer.token.OperatorType;

/**
 * @author tiankafei
 */
public class AddOp extends Add {

    @Override
    public String getName() {
        return OperatorType.ADD.token;
    }

}
