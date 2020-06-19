package com.greenpineyu.fel.parser;

import com.greenpineyu.fel.common.Callable;
import com.greenpineyu.fel.exception.ParseException;
import com.greenpineyu.fel.function.FunMgr;
import com.greenpineyu.fel.function.operator.Dot;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

/**
 * 使用Antlr进行语法分析
 *
 * @author yuqingsong
 */
public class AntlrParser implements Parser {

    private static FunMgr funMgr = new FunMgr();

    public static final Callable<Boolean, FelNode> FUN_FILTER = new Callable<Boolean, FelNode>() {
        @Override
        public Boolean call(FelNode... node) {
            FelNode n = node[0];
            if (n == null) {
                return false;
            }
            boolean isFun = n instanceof FunNode;
            if (isFun) {
                if (n instanceof CommonTree) {
                    CommonTree treeNode = (CommonTree) n;
                    CommonTree p = treeNode.parent;
                    if (p != null) {
                        if (Dot.DOT.equals(p.getText())) {
                            // 点运算符后的函数节点不是真正意义上的变量节点。
                            isFun = p.getChildren().get(0) == n;
                        }
                    }
                }
            }
            return isFun;
        }
    };

    @Override
    public FelNode parse(String exp) {
        if (exp == null || "".equals(exp)) {
            return null;
        }
        ByteArrayInputStream is = new ByteArrayInputStream(exp.getBytes());
        ANTLRInputStream input = null;
        try {
            input = new ANTLRInputStream(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FelLexer lexer = new FelLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FelParser parser = new FelParser(tokens);
        parser.setTreeAdaptor(new NodeAdaptor());
        ParserRuleReturnScope r = null;
        try {
            r = parser.program();
        } catch (RecognitionException e) {
            throw new ParseException(e.getMessage(), e);
        }
        if (r != null) {
            Object tree = r.getTree();
            if (tree instanceof FelNode) {
                initFun((FelNode) tree);
                return (FelNode) tree;
            }
        }
        return null;
    }

    public void initFun(FelNode node) {
        List<FelNode> nodes = BaseAbstFelNode.getNodes(node, FUN_FILTER);
        if (nodes != null) {
            for (FelNode n : nodes) {
                FunNode funNode = (FunNode) n;
                funNode.initFun(funMgr);
            }
        }
    }

    @Override
    public FunMgr getFunMgr() {
        return funMgr;
    }
}
