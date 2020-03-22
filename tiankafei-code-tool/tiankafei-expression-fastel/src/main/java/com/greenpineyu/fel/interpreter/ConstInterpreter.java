package com.greenpineyu.fel.interpreter;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.parser.FelNode;

/**
 * @author tiankafei
 */
public class ConstInterpreter implements Interpreter {

    private Object value;

    public ConstInterpreter(FelContext context, FelNode node) throws Exception {
        this.value = node.eval(context);
    }

    @Override
    public Object interpret(FelContext context, FelNode node) {
        return value;
    }

}
