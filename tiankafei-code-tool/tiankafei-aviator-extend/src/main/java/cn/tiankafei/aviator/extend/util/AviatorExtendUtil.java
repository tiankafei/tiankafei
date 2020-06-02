package cn.tiankafei.aviator.extend.util;

import cn.tiankafei.aviator.extend.exception.AviatorException;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.runtime.type.AviatorFunction;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Slf4j
public abstract class AviatorExtendUtil {

    /**
     * 处理已经存在的函数
     */
    public static void addFunction() {
        addFunction("max");
        addFunction("min");
    }

    private static void addFunction(String alreadyExistsFun) {
        AviatorFunction max = AviatorEvaluator.getInstance().getFunction(alreadyExistsFun);
        AviatorEvaluator.removeFunction(alreadyExistsFun);
        addFunction(max);
    }

    /**
     * 自定义函数
     * @param function
     */
    public static void addFunction(final AviatorFunction function) {
        AviatorEvaluator.getInstance().addFunction(function.getName().toLowerCase(), function);
        AviatorEvaluator.getInstance().addFunction(function.getName().toUpperCase(), function);
    }

    /**
     * 校验错误信息
     * @param errorInfo
     * @param funName
     */
    public static void checkError(StringBuilder errorInfo, String funName){
        if (StringUtils.isNotBlank(errorInfo.toString())) {
            errorInfo.delete(0, 1);
            String error = funName + "函数的" + errorInfo.toString() + "参数类型不合法，请确认！";
            log.error(error);
            throw new AviatorException(error);
        }
    }

    public static void execute(String expression){
        execute(expression, new HashMap<>());
    }

    public static void execute(String expression, Map<String, Object> dataMap){
        try {
            boolean flag = expression.contains("\\\\");
            while(flag){
                expression = expression.replace("\\\\", "^A");
                flag = expression.contains("\\\\");
            }

            flag = expression.contains("^A");
            while(flag){
                expression = expression.replace("^A", "\\\\\\\\");
                flag = expression.contains("^A");
            }

            Object result = AviatorEvaluator.execute(expression, dataMap);
            log.info("表达式：{}的执行结果为：{}", expression, result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
