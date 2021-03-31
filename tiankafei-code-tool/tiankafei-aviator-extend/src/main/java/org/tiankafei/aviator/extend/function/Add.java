package org.tiankafei.aviator.extend.function;

import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import org.tiankafei.aviator.extend.util.NumberUtil;
import com.googlecode.aviator.lexer.token.OperatorType;

import java.math.BigDecimal;

/**
 * @Author 魏双双
 * @Date 2020/6/2
 * @Version V1.0
 **/
public class Add extends TwoParamFunction {

    @Override
    public String getName() {
        return OperatorType.ADD.token;
    }

    @Override
    protected AviatorObject apply(Object left, Object right) {
        if(left == null && right == null){
            return AviatorRuntimeJavaType.valueOf(null);
        }else if(left == null){
            return AviatorRuntimeJavaType.valueOf(right);
        }else if(right == null){
            return AviatorRuntimeJavaType.valueOf(left);
        }else{
            return super.apply(left, right);
        }
    }

    @Override
    public Object evlNormalOperation(Object left, Object right) {
        BigDecimal leftBigDecimal = new BigDecimal(left.toString());
        BigDecimal rightBigDecimal = new BigDecimal(right.toString());
        return leftBigDecimal.add(rightBigDecimal).doubleValue();
    }

    @Override
    public Object evlAbnormalOperation(Object left, Object right) {
        return left.toString() + right.toString();
    }

    @Override
    public Object getReturnValue(Object object) {
        if (object instanceof Number) {
            object = NumberUtil.parseNumber(object.toString());
        }
        return object;
    }
}
