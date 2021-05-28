package org.tiankafei.aviator.runtime.function.two;

import com.googlecode.aviator.lexer.token.OperatorType;

/**
 * @author tiankafei
 */
public class ModOp extends Mod {

    @Override
    public String getName() {
        return OperatorType.MOD.token;
    }

}
