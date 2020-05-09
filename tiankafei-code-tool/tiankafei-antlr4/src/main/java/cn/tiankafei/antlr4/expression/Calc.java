package cn.tiankafei.antlr4.expression;

import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
/**
 * The Interpreter
 *
 * @author zhoujiagen<br/>
 *         Aug 26, 2015 1:20:34 AM
 */
public class Calc {
    static String NEWLINE = "\r\n";
    public static void main(String[] args) {
        System.out.println(eval("123=100+12+11" + NEWLINE, "124 + 125 = 123 + 126" + NEWLINE, "345 <= 346 + 347 + 348" + NEWLINE));
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
            ANTLRInputStream input = new ANTLRInputStream(stmt);
            RuleSetLexer lexer = new RuleSetLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            RuleSetParser parser = new RuleSetParser(tokens);
            ParseTree tree = parser.stmt(); // parse
            EvalVisitor eval = new EvalVisitor();
            System.out.println(eval.visit(tree));
            // get the final result
            result = eval.getResult();
        }
        return result;
    }
}