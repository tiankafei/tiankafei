package cn.tiankafei.aviator.extend.util;

import cn.tiankafei.aviator.extend.InitFunction;
import cn.tiankafei.aviator.extend.exception.AviatorException;
import cn.tiankafei.aviator.extend.function.Add;
import cn.tiankafei.aviator.extend.function.And;
import cn.tiankafei.aviator.extend.function.AviatorFunctionProxy;
import cn.tiankafei.aviator.extend.function.Div;
import cn.tiankafei.aviator.extend.function.Equals;
import cn.tiankafei.aviator.extend.function.GreaterThen;
import cn.tiankafei.aviator.extend.function.GreaterThenEquals;
import cn.tiankafei.aviator.extend.function.LessThen;
import cn.tiankafei.aviator.extend.function.LessThenEquals;
import cn.tiankafei.aviator.extend.function.Mod;
import cn.tiankafei.aviator.extend.function.Mul;
import cn.tiankafei.aviator.extend.function.NotEquals;
import cn.tiankafei.aviator.extend.function.NotOper;
import cn.tiankafei.aviator.extend.function.Or;
import cn.tiankafei.aviator.extend.function.Sub;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.Options;
import com.googlecode.aviator.lexer.token.OperatorType;
import com.googlecode.aviator.runtime.type.AviatorFunction;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import sun.misc.Service;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Slf4j
public abstract class AviatorExtendUtil {

    /**
     * 初始化函数
     */
    public static void initFun() {
        Iterator<InitFunction> providers = Service.providers(InitFunction.class);
        InitFunction initFunction = providers.next();
        initFunction.initFun();
    }

    /**
     * 覆盖操作符运算函数的实现
     */
    public static void addOperatorTypeFunction() {
        // 开启浮点型精度
        AviatorEvaluator.setOption(Options.ALWAYS_PARSE_FLOATING_POINT_NUMBER_INTO_DECIMAL, true);
        AviatorEvaluator.setOption(Options.ALWAYS_PARSE_INTEGRAL_NUMBER_INTO_DECIMAL, true);
        // 重载操作符运算的函数
        addOpFunction(OperatorType.ADD, new Add());
        addOpFunction(OperatorType.SUB, new Sub());
        addOpFunction(OperatorType.MULT, new Mul());
        addOpFunction(OperatorType.DIV, new Div());
        addOpFunction(OperatorType.MOD, new Mod());
        addOpFunction(OperatorType.LT, new LessThen());
        addOpFunction(OperatorType.LE, new LessThenEquals());
        addOpFunction(OperatorType.GT, new GreaterThen());
        addOpFunction(OperatorType.GE, new GreaterThenEquals());
        addOpFunction(OperatorType.EQ, new Equals());
        addOpFunction(OperatorType.NEQ, new NotEquals());
        addOpFunction(OperatorType.NOT, new NotOper());
        addOpFunction(OperatorType.AND, new And());
        addOpFunction(OperatorType.OR, new Or());
    }

    private static void addOpFunction(final OperatorType operatorType, final AviatorFunction function) {
        AviatorEvaluator.getInstance().addOpFunction(operatorType, new AviatorFunctionProxy(function));
    }

    /**
     * 新增自定义函数
     *
     * @param function
     */
    public static void addFunction(final AviatorFunction function) {
        AviatorFunctionProxy aviatorFunctionProxy = new AviatorFunctionProxy(function);
        String name = function.getName();
        String lowerCase = name.toLowerCase();
        String upperCase = name.toUpperCase();
        if(lowerCase.equals(upperCase)){
            AviatorEvaluator.getInstance().addFunction(lowerCase, aviatorFunctionProxy);
        }else{
            AviatorEvaluator.getInstance().addFunction(lowerCase, aviatorFunctionProxy);
            AviatorEvaluator.getInstance().addFunction(upperCase, aviatorFunctionProxy);
        }
    }

    /**
     * 删除已经存在的函数
     * @param funName
     */
    public static void delFunction(String funName){
        AviatorEvaluator.getInstance().removeFunction(funName);
    }

    /**
     * 校验错误信息
     *
     * @param errorInfo
     * @param funName
     */
    public static void checkError(StringBuilder errorInfo, String funName) {
        if (StringUtils.isNotBlank(errorInfo.toString())) {
            errorInfo.delete(0, 1);
            String error = funName + "函数的" + errorInfo.toString() + "参数类型不合法，请确认！";
            log.error(error);
            throw new AviatorException(error);
        }
    }

    public static void compile(String expression) {
        compile(expression, null);
    }

    public static void compile(String expression, Map<String, Object> dataMap) {
        try {
            boolean flag = expression.contains("\\\\");
            while (flag) {
                expression = expression.replace("\\\\", "^A");
                flag = expression.contains("\\\\");
            }
            flag = expression.contains("^A");
            while (flag) {
                expression = expression.replace("^A", "\\\\\\\\");
                flag = expression.contains("^A");
            }
            Object result = null;
            Expression exp = AviatorEvaluator.compile(expression);
            if (dataMap != null) {
                result = exp.execute(dataMap);
            } else {
                result = exp.execute();
            }
            log.info("表达式：{}的执行结果为：{}", expression, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void execute(String expression) {
        execute(expression, new HashMap<>());
    }

    public static void execute(String expression, Map<String, Object> dataMap) {
        try {
            boolean flag = expression.contains("\\\\");
            while (flag) {
                expression = expression.replace("\\\\", "^A");
                flag = expression.contains("\\\\");
            }
            flag = expression.contains("^A");
            while (flag) {
                expression = expression.replace("^A", "\\\\\\\\");
                flag = expression.contains("^A");
            }
            Object result = null;
            if (dataMap != null) {
                result = AviatorEvaluator.execute(expression, dataMap);
            } else {
                result = AviatorEvaluator.execute(expression);
            }
            log.info("表达式：{}的执行结果为：{}", expression, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
