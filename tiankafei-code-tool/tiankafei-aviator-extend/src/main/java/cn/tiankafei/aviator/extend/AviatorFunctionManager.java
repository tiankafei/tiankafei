package cn.tiankafei.aviator.extend;

import cn.tiankafei.aviator.extend.function.Abs;
import cn.tiankafei.aviator.extend.function.And;
import cn.tiankafei.aviator.extend.function.Or;
import com.googlecode.aviator.AviatorEvaluator;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class AviatorFunctionManager {

    public void initFun() {
        AviatorEvaluator.addFunction(new And());
        AviatorEvaluator.addFunction(new Or());
        AviatorEvaluator.addFunction(new Abs());
    }

}
