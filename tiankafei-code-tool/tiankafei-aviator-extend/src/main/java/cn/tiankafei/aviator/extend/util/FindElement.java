package cn.tiankafei.aviator.extend.util;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import java.util.List;

/**
 * @Author 魏双双
 * @Date 2020/6/3
 * @Version V1.0
 **/
public class FindElement {

    public static void main(String[] args) {
        AviatorExtendUtil.initFun();

        String expression = "AGE(a, b, c, d)==e";
        List<String> expressionList = parse(expression);
        System.out.println(expressionList);
    }

    public static List<String> parse(String exp) {
        Expression compile = AviatorEvaluator.compile(exp);
        return compile.getVariableFullNames();
    }

}
