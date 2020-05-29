package cn.tiankafei.aviator.extend;

import cn.tiankafei.aviator.extend.function.impl.And;
import cn.tiankafei.aviator.extend.function.impl.Or;
import com.googlecode.aviator.AviatorEvaluator;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class AviatorFunctionManager {

    static {
        AviatorEvaluator.addFunction(new And());
        AviatorEvaluator.addFunction(new Or());
    }

}
