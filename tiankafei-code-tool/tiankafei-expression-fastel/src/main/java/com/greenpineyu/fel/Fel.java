package com.greenpineyu.fel;

import com.greenpineyu.fel.compile.CompileParamVo;
import java.util.Map;

import com.greenpineyu.fel.context.ArrayCtxImpl;
import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.context.MapContext;
import com.greenpineyu.fel.context.Var;

/**
 * @author tiankafei
 */
public class Fel {
    static FelEngineImpl engine = new FelEngineImpl();

    public static Object eval(String exp, Var... vars) throws Exception {
        return engine.eval(exp, vars);
    }

    public static Object eval(String exp, Map<String, Object> vars) throws Exception {
        FelContext ctx = new MapContext(vars);
        return engine.eval(exp, ctx);
    }

    public static Expression compile(String exp, Var... vars) throws Exception {
        return engine.compile(exp, vars);
    }

    public static Expression compile(String exp, CompileParamVo compileParamVo, Var... vars) throws Exception {
        return engine.compile(exp, compileParamVo, vars);
    }

    public static Expression compile(String exp, Map<String, Object> vars) throws Exception {
        return engine.compile(exp, new MapContext(vars));
    }

    public static Expression compile(String exp, Map<String, Object> vars, CompileParamVo compileParamVo) throws Exception {
        return engine.compile(exp, new MapContext(vars), compileParamVo);
    }

    public static String compileJs(String exp, Map<String, Object> vars, CompileParamVo compileParamVo) throws Exception {
        return engine.compileJs(exp, new MapContext(vars), compileParamVo);
    }

    public static FelContext getContext() {
        return new MapContext();
    }

    public static FelContext getContext(Map map) {
        return new MapContext(map);
    }

    public static FelEngine newEngine() {
        return new FelEngineImpl();
    }

    public static FelEngine newEngine(boolean compilerFlag) {
        return new FelEngineImpl(compilerFlag);
    }

    public static FelContext newContext(String name) {
        String value = "Array";
        if (value.equalsIgnoreCase(name)) {
            return new ArrayCtxImpl();
        }
        return new MapContext();
    }

}

