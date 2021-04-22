package org.tiankafei.antlr4;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.tiankafei.antlr4.hello.HelloLexer;
import org.tiankafei.antlr4.hello.HelloParser;

/**
 * @Author 魏双双
 * @Date 2020/5/9
 * @Version V1.0
 **/
public class Antlr4Main {

    public static void main(String[] args) {
        helloAntlr4();


    }

    private static void helloAntlr4(){
        HelloLexer lexer = new HelloLexer(new ANTLRInputStream("hello world"));

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        HelloParser parser = new HelloParser(tokens);
        HelloParser.RContext r = parser.r();
        System.out.println(r);
    }

}
