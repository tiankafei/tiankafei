package org.tiankafei.aviator.runtime.function.two;

import com.googlecode.aviator.lexer.token.OperatorType;

/**
 * @author tiankafei
 */
public class DivOp extends Div {

    @Override
    public String getName() {
        return OperatorType.DIV.token;
    }

}
