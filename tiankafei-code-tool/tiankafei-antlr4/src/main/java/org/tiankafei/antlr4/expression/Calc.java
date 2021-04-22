package org.tiankafei.antlr4.expression;

import java.util.ArrayList;
import java.util.List;

/**
 * The Interpreter
 *
 * @author zhoujiagen<br />
 * Aug 26, 2015 1:20:34 AM
 */
public class Calc {
    static String NEWLINE = "\r\n";

    public static void main(String[] args) {
        System.out.println(eval("123=100+12+12" + NEWLINE, "124 + 125 = 123 + 126" + NEWLINE, "345 <= 346 + 347 + 348" + NEWLINE));
    }

    static List<Boolean> eval(String... stmts) {
        if (stmts != null && stmts.length > 0) {
            List<Boolean> result = new ArrayList<Boolean>();
            for (String stmt : stmts) {
                result.add(eval(stmt));
            }
            return result;
        }
        return null;
    }

    static boolean eval(String stmt) {
        boolean result = false;
        if (stmt != null && stmt.length() > 0) {
            EvalVisitor eval = new EvalVisitor(stmt);
            result = eval.getResult();
            System.out.println(result);
        }
        return result;
    }
}