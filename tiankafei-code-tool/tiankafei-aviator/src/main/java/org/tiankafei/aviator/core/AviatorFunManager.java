package org.tiankafei.aviator.core;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Options;
import com.googlecode.aviator.lexer.SymbolTable;
import com.googlecode.aviator.lexer.token.OperatorType;
import com.googlecode.aviator.runtime.type.AviatorFunction;
import org.tiankafei.aviator.runtime.function.AviatorFunctionProxy;
import org.tiankafei.aviator.runtime.function.one.Abs;
import org.tiankafei.aviator.runtime.function.other.And;
import org.tiankafei.aviator.runtime.function.other.Or;
import org.tiankafei.aviator.runtime.function.two.Add;
import org.tiankafei.aviator.runtime.function.two.AddOp;
import org.tiankafei.aviator.runtime.function.two.AndOp;
import org.tiankafei.aviator.runtime.function.two.Div;
import org.tiankafei.aviator.runtime.function.two.DivOp;
import org.tiankafei.aviator.runtime.function.two.Equals;
import org.tiankafei.aviator.runtime.function.two.EqualsOp;
import org.tiankafei.aviator.runtime.function.two.GreaterThen;
import org.tiankafei.aviator.runtime.function.two.GreaterThenEquals;
import org.tiankafei.aviator.runtime.function.two.GreaterThenEqualsOp;
import org.tiankafei.aviator.runtime.function.two.GreaterThenOp;
import org.tiankafei.aviator.runtime.function.two.LessThen;
import org.tiankafei.aviator.runtime.function.two.LessThenEquals;
import org.tiankafei.aviator.runtime.function.two.LessThenEqualsOp;
import org.tiankafei.aviator.runtime.function.two.LessThenOp;
import org.tiankafei.aviator.runtime.function.two.Mod;
import org.tiankafei.aviator.runtime.function.two.ModOp;
import org.tiankafei.aviator.runtime.function.two.Mul;
import org.tiankafei.aviator.runtime.function.two.MulOp;
import org.tiankafei.aviator.runtime.function.two.NotEquals;
import org.tiankafei.aviator.runtime.function.two.NotEqualsOp;
import org.tiankafei.aviator.runtime.function.two.OrOp;
import org.tiankafei.aviator.runtime.function.two.Sub;
import org.tiankafei.aviator.runtime.function.two.SubOp;

/**
 * @author tiankafei
 */
public class AviatorFunManager implements IFunManager {

    @Override
    public void initialize() {
        // 开启浮点型精度
        AviatorEvaluator.setOption(Options.ALWAYS_PARSE_FLOATING_POINT_NUMBER_INTO_DECIMAL, true);
        AviatorEvaluator.setOption(Options.ALWAYS_PARSE_INTEGRAL_NUMBER_INTO_DECIMAL, true);

        // 重载操作符运算的函数
        addOpFunction(OperatorType.ADD, new AddOp());
        addOpFunction(OperatorType.SUB, new SubOp());
        addOpFunction(OperatorType.MULT, new MulOp());
        addOpFunction(OperatorType.DIV, new DivOp());
        addOpFunction(OperatorType.MOD, new ModOp());
        addOpFunction(OperatorType.EQ, new EqualsOp());
        addOpFunction(OperatorType.NEQ, new NotEqualsOp());
        addOpFunction(OperatorType.LT, new LessThenOp());
        addOpFunction(OperatorType.LE, new LessThenEqualsOp());
        addOpFunction(OperatorType.GT, new GreaterThenOp());
        addOpFunction(OperatorType.GE, new GreaterThenEqualsOp());
        addOpFunction(OperatorType.AND, new AndOp());
        addOpFunction(OperatorType.OR, new OrOp());

        // 增加自定义函数
        addFunction(new AviatorFunctionProxy(new Add()));
        addFunction(new AviatorFunctionProxy(new Sub()));
        addFunction(new AviatorFunctionProxy(new Mul()));
        addFunction(new AviatorFunctionProxy(new Div()));
        addFunction(new AviatorFunctionProxy(new Mod()));
        addFunction(new AviatorFunctionProxy(new Equals()));
        addFunction(new AviatorFunctionProxy(new NotEquals()));
        addFunction(new AviatorFunctionProxy(new LessThen()));
        addFunction(new AviatorFunctionProxy(new LessThenEquals()));
        addFunction(new AviatorFunctionProxy(new GreaterThen()));
        addFunction(new AviatorFunctionProxy(new GreaterThenEquals()));
        addFunction(new AviatorFunctionProxy(new And()));
        addFunction(new AviatorFunctionProxy(new Or()));

        addFunction(new AviatorFunctionProxy(new Abs()));
    }

    private static void addOpFunction(final OperatorType operatorType, final AviatorFunction function) {
        AviatorEvaluator.getInstance().addOpFunction(operatorType, new AviatorFunctionProxy(function));
    }

    /**
     * 增加函数
     *
     * @param aviatorFunctionProxy
     */
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

    /**
     * 验证函数是否存在
     *
     * @param funName
     * @return
     */
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
