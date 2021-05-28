package org.tiankafei.aviator.runtime.function.two;

import com.googlecode.aviator.lexer.token.OperatorType;
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;
import org.tiankafei.aviator.util.AviatorUtil;

/**
 * @author tiankafei
 */
public class AndOp extends TwoParamFunction {

    @Override
    public String getName() {
        return OperatorType.AND.token;
    }

    @Override
    protected AviatorObject apply(Object left, Object right) {
        Boolean leftValue = AviatorUtil.toBooleanObj(left);
        Boolean rightValue = AviatorUtil.toBooleanObj(right);

        if (leftValue.booleanValue() && rightValue.booleanValue()) {
            return AviatorBoolean.TRUE;
        } else {
            return AviatorBoolean.FALSE;
        }
    }

}
