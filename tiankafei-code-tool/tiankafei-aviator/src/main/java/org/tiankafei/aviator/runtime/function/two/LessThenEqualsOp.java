package org.tiankafei.aviator.runtime.function.two;

import com.googlecode.aviator.lexer.token.OperatorType;

/**
 * @author tiankafei
 */
public class LessThenEqualsOp extends LessThenEquals {

    @Override
    public String getName() {
        return OperatorType.LE.token;
    }

}
