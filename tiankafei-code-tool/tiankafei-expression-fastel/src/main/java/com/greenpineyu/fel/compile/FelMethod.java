package com.greenpineyu.fel.compile;

import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.parser.FelNode;

import java.util.List;

/**
 * @author tiankafei
 */
public class FelMethod implements SourceBuilder {

    private Class<?> returnType;

    private String code;

    private List<String> programList;

    public FelMethod(Class<?> returnType, String code) {
        this.returnType = returnType;
        this.code = code;
    }

    public FelMethod(String code) {
        this.code = code;
    }

    public FelMethod(String code, List<String> programList) {
        this.code = code;
        if (this.programList != null) {
            this.programList.addAll(programList);
        } else {
            this.programList = programList;
        }
    }

    @Override
    public Class<?> returnType(FelContext ctx, FelNode node) {
        return returnType;
    }

    public void setReturnType(Class<?> returnType) {
        this.returnType = returnType;
    }

    @Override
    public String source(FelContext ctx, FelNode node) {
        return code;
    }

    @Override
    public String sourceJs(FelContext ctx, FelNode node) throws Exception {
        return code;
    }

    public List<String> getProgramList() {
        return programList;
    }
}
