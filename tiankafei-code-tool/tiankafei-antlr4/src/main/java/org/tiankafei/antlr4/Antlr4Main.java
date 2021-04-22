package org.tiankafei.antlr4;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.tiankafei.antlr4.expression.RuleSetBaseVisitor;
import org.tiankafei.antlr4.hello.HelloLexer;
import org.tiankafei.antlr4.hello.HelloParser;
import org.tiankafei.antlr4.math.MathLexer;
import org.tiankafei.antlr4.math.MathParser;

/**
 * @Author 魏双双
 * @Date 2020/5/9
 * @Version V1.0
 **/
public class Antlr4Main {

    public static void main(String[] args) {
        helloAntlr4();
        System.out.println("=================");
        mathAntlr4();

    }

    private static void helloAntlr4(){
        HelloLexer lexer = new HelloLexer(new ANTLRInputStream("hello world"));

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        int numberOfOnChannelTokens = tokens.getNumberOfOnChannelTokens();
        for (int index = 0; index < numberOfOnChannelTokens; index++) {
            System.out.println(tokens.get(index));
        }

        HelloParser parser = new HelloParser(tokens);
        ParseTree tree = parser.r();
        System.out.println(tree);
    }

    private static void mathAntlr4(){
        MathLexer lexer = new MathLexer(new ANTLRInputStream("1+(2-1)+4"));

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        int numberOfOnChannelTokens = tokens.getNumberOfOnChannelTokens();
        for (int index = 0; index < numberOfOnChannelTokens; index++) {
            System.out.println(tokens.get(index));
        }

        MathParser parser = new MathParser(tokens);
        ParseTree tree = parser.expr();
        System.out.println(tree);
    }

}
