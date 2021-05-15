package org.tiankafei.aviator.extend.util;

import org.tiankafei.aviator.extend.model.ExpModel;

/**
 * 解析表达式
 *
 * @author tiankafei
 */
public class ParseExpression {

    private static final String LEFT_BRACKETS = "(";
    private static final String RIGHT_BRACKETS = ")";

    public static void main(String[] args) {
        String expression = "AND(a1+a2==a3, a4+a5=a6)";
        parseExp(expression);
    }

    public static void parseExp(String expression) {
        ExpModel expModel = new ExpModel();
        expModel.setLeftBracketsCount(0);

        StringBuilder expBuilder = new StringBuilder();

        int length = expression.length();
        for (int index = 1; index < length; index++) {
            String substring = expression.substring(index - 1, index);
            if (LEFT_BRACKETS.equals(substring)) {
                // 左括号
                expModel.setMethodName(expBuilder.toString());
                expModel.setStartIndex(index);
                parseLeftBrackets(expression, expModel);
            } else {
                expBuilder.append(substring);
            }
        }

        System.out.println(expModel);
    }

    private static void parseLeftBrackets(String expression, ExpModel expModel) {

    }

}
