package org.tiankafei.aviator.extend.util;

import com.googlecode.aviator.BaseExpression;
import org.apache.commons.collections4.CollectionUtils;
import org.tiankafei.aviator.extend.InitFunction;
import org.tiankafei.aviator.extend.constant.FunctionConstants;
import org.tiankafei.aviator.extend.exception.AviatorException;
import org.tiankafei.aviator.extend.function.Add;
import org.tiankafei.aviator.extend.function.And;
import org.tiankafei.aviator.extend.function.AviatorFunctionProxy;
import org.tiankafei.aviator.extend.function.Div;
import org.tiankafei.aviator.extend.function.Equals;
import org.tiankafei.aviator.extend.function.GreaterThen;
import org.tiankafei.aviator.extend.function.GreaterThenEquals;
import org.tiankafei.aviator.extend.function.LessThen;
import org.tiankafei.aviator.extend.function.LessThenEquals;
import org.tiankafei.aviator.extend.function.Mod;
import org.tiankafei.aviator.extend.function.Mul;
import org.tiankafei.aviator.extend.function.NotEquals;
import org.tiankafei.aviator.extend.function.NotOper;
import org.tiankafei.aviator.extend.function.Or;
import org.tiankafei.aviator.extend.function.Sub;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.Options;
import com.googlecode.aviator.lexer.token.OperatorType;
import com.googlecode.aviator.runtime.type.AviatorFunction;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.tiankafei.common.util.JdkSpiUtil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
        Iterator<InitFunction> providers = JdkSpiUtil.service(InitFunction.class);
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
        AviatorEvaluator.getInstance().addOpFunction(operatorType, new AviatorFunctionProxy(function, true));
    }

    public static void addFunction(final AviatorFunction function) {
        addFunction(function, true);
    }

    /**
     * 新增自定义函数
     *
     * @param function
     */
    public static void addFunction(final AviatorFunction function, boolean proxyFlag) {
        AviatorFunctionProxy aviatorFunctionProxy = new AviatorFunctionProxy(function, proxyFlag);
        addFunction(aviatorFunctionProxy);
    }

    public static void addFunction(final AviatorFunctionProxy aviatorFunctionProxy) {
        String name = aviatorFunctionProxy.getName();
        String lowerCase = name.toLowerCase();
        String upperCase = name.toUpperCase();
        if(AviatorEvaluator.getFunction(lowerCase) == null){
            AviatorEvaluator.getInstance().addFunction(lowerCase, aviatorFunctionProxy);
        }
        if (!lowerCase.equals(upperCase)) {
            if(AviatorEvaluator.getFunction(upperCase) == null){
                AviatorEvaluator.getInstance().addFunction(upperCase, aviatorFunctionProxy);
            }
        }
    }

    /**
     * 删除已经存在的函数
     *
     * @param funName
     */
    public static void delFunction(String funName) {
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

    /**
     * 编译js
     *
     * @param expression
     */
    public static String compileJs(String expression) {
        return compileJs(expression, new HashMap<>());
    }

    /**
     * 编译js
     *
     * @param expression
     * @param dataMap
     */
    public static String compileJs(String expression, Map<String, Object> dataMap) {
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        return compileJs(expression, dataMap, id);
    }

    /**
     * 编译js
     *
     * @param expression
     * @param id
     */
    public static String compileJs(String expression, String id) {
        return compileJs(expression, new HashMap<>(), id);
    }

    /**
     * 编译js
     *
     * @param expression
     * @param dataMap
     * @param id
     */
    public static String compileJs(String expression, Map<String, Object> dataMap, String id) {
        try {
            expression = parseExpression(expression);
            Expression exp = AviatorEvaluator.compile(expression);
            dataMap.put(FunctionConstants.AVIATOR_COMPILE_JS, true);
            Object result = exp.execute(dataMap);

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("function fun_").append(id).append("(obj){ \n");
            List<String> aliasList = (List<String>) dataMap.get(FunctionConstants.AVIATOR_FUNCTION_ALIAS);
            if (CollectionUtils.isNotEmpty(aliasList)) {
                for (int index = 0, length = aliasList.size(); index < length; index++) {
                    String aliasName = aliasList.get(index);
                    stringBuilder.append("\t").append("var ").append(aliasName).append(" = ").append("obj.").append(aliasName).append("; \n");
                }
            }
            stringBuilder.append("\treturn ").append(result).append("; \n");
            stringBuilder.append("}\n");
            log.info("表达式：{}编译的js结果为：{}", expression, stringBuilder.toString());

            dataMap.remove(FunctionConstants.AVIATOR_FUNCTION_ALIAS);

            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            throw new AviatorException(e.getMessage());
        }
    }

    /**
     * 编译class执行审核
     *
     * @param expression
     */
    public static void compile(String expression) {
        compile(expression, null);
    }

    /**
     * 编译class执行审核
     *
     * @param expression
     * @param dataMap
     */
    public static void compile(String expression, Map<String, Object> dataMap) {
        try {
            expression = parseExpression(expression);
            Object result = null;
            Expression exp = AviatorEvaluator.compile(expression);
//            System.out.println(exp.getClass());
//            byte[] serialize = ObjectUtil.serialize(exp);
//
//            String filePath = "D:\\Script_1615568517996_56.class";
//            FileUtil.writeByteFile(serialize, filePath);
//
//            byte[] bytes = FileUtil.readByteFile(filePath);
//            Expression exp1 = ObjectUtil.deserialize(bytes);
//            System.out.println(exp1);
//            System.out.println(exp1.getVariableNames());
//            System.out.println(exp1.getVariableFullNames());
//            System.out.println(exp1.getSourceFile());

            String name = exp.getClass().getName();
            System.out.println(name);
            String className = name.split("/")[0];
            System.out.println(className);



            System.out.println(exp.getVariableNames());
            System.out.println(exp.getVariableFullNames());
            System.out.println(exp.getSourceFile());
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

    /**
     * 直接执行审核
     *
     * @param expression
     */
    public static void execute(String expression) {
        execute(expression, new HashMap<>());
    }

    /**
     * 直接执行审核
     *
     * @param expression
     * @param dataMap
     */
    public static void execute(String expression, Map<String, Object> dataMap) {
        try {
            expression = parseExpression(expression);
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

    private static String parseExpression(String expression) {
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
        return expression;
    }

}
