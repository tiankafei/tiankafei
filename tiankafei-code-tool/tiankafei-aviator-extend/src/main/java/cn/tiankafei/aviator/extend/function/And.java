package cn.tiankafei.aviator.extend.function;

import cn.tiankafei.aviator.extend.util.NumberUtil;
import com.googlecode.aviator.lexer.token.OperatorType;
import com.googlecode.aviator.runtime.type.AviatorBoolean;
import com.googlecode.aviator.runtime.type.AviatorObject;

/**
 * @Author 魏双双
 * @Date 2020/6/5
 * @Version V1.0
 **/
public class And extends TwoParamFunction {

    @Override
    public String getName() {
        return OperatorType.AND.token;
    }

    @Override
    protected AviatorObject apply(Object left, Object right) {
        Boolean leftValue = NumberUtil.toBooleanObj(left);
        Boolean rightValue = NumberUtil.toBooleanObj(right);

        if (leftValue.booleanValue() && rightValue.booleanValue()) {
            return AviatorBoolean.TRUE;
        } else {
            return AviatorBoolean.FALSE;
        }
    }
}
