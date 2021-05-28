package org.tiankafei.aviator.core;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Options;
import com.googlecode.aviator.lexer.SymbolTable;
import com.googlecode.aviator.runtime.type.AviatorFunction;
import org.tiankafei.aviator.runtime.function.AviatorFunctionProxy;

/**
 * @author tiankafei
 */
public class AviatorFunManager implements IFunManager {

    @Override
    public void initialize() {
        // 开启浮点型精度
        AviatorEvaluator.setOption(Options.ALWAYS_PARSE_FLOATING_POINT_NUMBER_INTO_DECIMAL, true);
        AviatorEvaluator.setOption(Options.ALWAYS_PARSE_INTEGRAL_NUMBER_INTO_DECIMAL, true);
    }

    private void addFunction(final AviatorFunctionProxy aviatorFunctionProxy) {
        String name = aviatorFunctionProxy.getName();
        String lowerCase = name.toLowerCase();
        String upperCase = name.toUpperCase();
        if (checkFunctionExists(lowerCase)) {
            AviatorEvaluator.getInstance().addFunction(lowerCase, aviatorFunctionProxy);
        }
        if (!lowerCase.equals(upperCase)) {
            if (checkFunctionExists(upperCase)) {
                AviatorEvaluator.getInstance().addFunction(upperCase, aviatorFunctionProxy);
            }
        }
    }

    public boolean checkFunctionExists(String funName) {
        AviatorFunction function = AviatorEvaluator.getFunction(funName);
        return "com.googlecode.aviator.RuntimeFunctionDelegator".equals(function.getClass().getName()) && !SymbolTable.isReservedKeyword(funName);
    }

    /**
     * 删除已经存在的函数
     *
     * @param funName
     */
    public void delFunction(String funName) {
        AviatorEvaluator.getInstance().removeFunction(funName);
    }

}
