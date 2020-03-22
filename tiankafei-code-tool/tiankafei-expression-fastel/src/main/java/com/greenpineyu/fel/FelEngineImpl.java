package com.greenpineyu.fel;

import com.greenpineyu.fel.compile.CompileParamVo;
import com.greenpineyu.fel.compile.CompileService;
import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.context.MapContext;
import com.greenpineyu.fel.context.Var;
import com.greenpineyu.fel.function.Function;
import com.greenpineyu.fel.optimizer.Optimizer;
import com.greenpineyu.fel.optimizer.VarVisitOpti;
import com.greenpineyu.fel.parser.AntlrParser;
import com.greenpineyu.fel.parser.FelNode;
import com.greenpineyu.fel.parser.Parser;

/**
 * 执行引擎
 *
 * @author yqs
 */
public class FelEngineImpl implements FelEngine {

    private FelContext context;

    private CompileService compiler;

    private static Parser parser = new AntlrParser();

    public FelEngineImpl(FelContext context) {
        this.context = context;
        compiler = new CompileService();
    }

    public FelEngineImpl(FelContext context, boolean compilerFlag) {
        this.context = context;
        if (compilerFlag) {
            compiler = new CompileService();
        }
    }

    public FelEngineImpl() {
//         this(new ArrayCtxImpl(), true);
        this(new MapContext(), true);
    }

    public FelEngineImpl(boolean compilerFlag) {
        // this(new ArrayCtxImpl());
        this(new MapContext(), compilerFlag);
    }

    @Override
    public FelNode parse(String exp) {
        return parser.parse(exp);
    }

    @Override
    public Parser getParser() {
        return parser;
    }

    @Override
    public Object eval(String exp) throws Exception {
        return this.eval(exp, this.context);
    }

    public Object eval(String exp, Var... vars) throws Exception {
        FelNode node = parse(exp);
        Optimizer opt = new VarVisitOpti(vars);
        node = opt.call(context, node);
        return node.eval(context);
    }

    @Override
    public Object eval(String exp, FelContext ctx) throws Exception {
        return parse(exp).eval(ctx);
    }

    public Expression compile(String exp, Var... vars) throws Exception {
        return compile(exp, null, new VarVisitOpti(vars));
    }

    public Expression compile(String exp, CompileParamVo compileParamVo, Var... vars) throws Exception {
        compiler.setCompileParamVo(compileParamVo);
        return this.compile(exp, vars);
    }

    @Override
    public Expression compile(String exp, FelContext ctx, Optimizer... opts) throws Exception {
        if (ctx == null) {
            ctx = this.context;
        }
        FelNode node = parse(exp);
        if (opts != null) {
            for (Optimizer opt : opts) {
                if (opt != null) {
                    node = opt.call(ctx, node);
                }
            }
        }
        return compiler.compile(ctx, node, exp);
    }

    @Override
    public Expression compile(String exp, FelContext ctx, CompileParamVo compileParamVo, Optimizer... opts) throws Exception {
        compiler.setCompileParamVo(compileParamVo);
        return this.compile(exp, ctx, opts);
    }

    @Override
    public String toString() {
        return "FelEngine";
    }

    @Override
    public void addFun(Function fun) {
        parser.getFunMgr().add(fun);
    }

    @Override
    public FelContext getContext() {
        return this.context;
    }

    @Override
    public void setContext(FelContext context) {
        this.context = context;
    }

}
