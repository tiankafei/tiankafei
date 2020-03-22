package com.googlecode.aviator.parser;

import com.googlecode.aviator.code.CodeGenerator;

/**
 * @author tiankafei
 */
public interface Parser {

    /**
     * getCodeGenerator
     *
     * @return
     */
    CodeGenerator getCodeGenerator();

    /**
     * setCodeGenerator
     *
     * @param codeGenerator
     */
    void setCodeGenerator(CodeGenerator codeGenerator);

    /**
     * enterScope
     *
     * @return
     */
    ScopeInfo enterScope();

    /**
     * restoreScope
     *
     * @param info
     */
    void restoreScope(ScopeInfo info);

}
