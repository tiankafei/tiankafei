package com.greenpineyu.fel.parser;

import com.greenpineyu.fel.compile.FelMethod;
import com.greenpineyu.fel.compile.InterpreterSourceBuilder;
import com.greenpineyu.fel.compile.SourceBuilder;
import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.exception.EvalException;
import com.greenpineyu.fel.function.FunMgr;
import com.greenpineyu.fel.function.Function;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;

/**
 * 函数节点
 *
 * @author yqs
 */
public class FunNode extends BaseAbstFelNode {
    private Function fun;

    public Function getFun() {
        return fun;
    }

    private static final Function NOT_FOUND_FUN = new Function() {

        @Override
        public String getName() {
            return "未知函数";
        }

        @Override
        public Object call(FelNode node, FelContext context) {
            throw new EvalException("找不到函数[" + node.getText() + "]", null);
        }

        @Override
        public FelMethod toMethod(FelNode node, FelContext ctx) {
            return null;
        }
    };

    public FunNode(CommonTree node) {
        super(node);
    }

    public FunNode(Token token) {
        super(token);

    }

//	{
//		initFun();
//	}

    @Override
    public Object interpret(FelContext context, FelNode node) throws Exception {
        return fun.call(this, context);
    }


    public void initFun(FunMgr funMgr) {
        fun = funMgr.getFun(getText());
        if (fun == null) {
            fun = NOT_FOUND_FUN;
        }
    }

    @Override
    public SourceBuilder toMethod(FelContext ctx) throws Exception {
        if (this.builder != null) {
            return builder;
        }
        if (!this.isDefaultInterpreter()) {
            return InterpreterSourceBuilder.getInstance();
        }
        return this.fun.toMethod(this, ctx);
    }

    @Override
    public boolean stable() {
        if (this.fun instanceof Stable) {
            // 函数是稳定的，并且参数是稳定的
            return ((Stable) fun).stable() && this.isChildrenStable();
        }
        return false;
    }
}