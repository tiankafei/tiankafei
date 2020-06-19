package com.greenpineyu.fel.common;

import com.greenpineyu.fel.Fel;
import com.greenpineyu.fel.parser.FelNode;
import com.greenpineyu.fel.parser.FunNode;
import com.greenpineyu.fel.parser.Parser;
import com.greenpineyu.fel.parser.VarAstNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author tiankafei
 * @Date 2019/12/10
 * @Version V1.0
 **/
public class FindElement {

    private static Parser parser = Fel.newEngine().getParser();

    public static Parser getParser() {
        return parser;
    }

    public static void main(String[] args) {
        String expression = "if(age(a, b, c, d)==e, f==g, h==i)";
        List<String> expressionList = parse(expression);
        System.out.println(expressionList);
    }

    public static List<String> parse(String exp) {
        List<String> expressionList = new ArrayList<>();

        FelNode felNode = parser.parse(exp);
        if (felNode instanceof VarAstNode) {
            expressionList.add(felNode.getText());
        } else if (felNode instanceof FunNode) {
            parse(felNode.getChildren(), expressionList);
        }
        return expressionList;
    }

    public static void parse(List<FelNode> children, List<String> expressionList) {
        if (children != null && !children.isEmpty()) {
            for (int index = 0, length = children.size(); index < length; index++) {
                FelNode node = children.get(index);
                String str = node.getText();
                boolean flag = parser.getFunMgr().exists(str);
                if (!flag) {
                    if (node instanceof VarAstNode) {
                        expressionList.add(node.getText());
                    }
                }

                List<FelNode> felNodeList = node.getChildren();
                if (felNodeList != null && !felNodeList.isEmpty()) {
                    parse(felNodeList, expressionList);
                }
            }

        }
    }

}
