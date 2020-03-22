package com.googlecode.aviator.lexer.token;

import com.googlecode.aviator.runtime.LambdaFunctionBootstrap;

import java.util.Map;


/**
 * Delegate token,wrap a token with special syntax structure
 *
 * @author dennis
 */
public class DelegateToken extends AbstractToken<Token<?>> {

    private final Token<?> token;
    private final DelegateTokenType delegateTokenType;
    private LambdaFunctionBootstrap lambdaFunctionBootstrap;


    public LambdaFunctionBootstrap getLambdaFunctionBootstrap() {
        return lambdaFunctionBootstrap;
    }


    public void setLambdaFunctionBootstrap(LambdaFunctionBootstrap lambdaFunctionBootstrap) {
        this.lambdaFunctionBootstrap = lambdaFunctionBootstrap;
    }


    public static enum DelegateTokenType {
        /**
         * And_Left
         */
        And_Left,

        /**
         * Join_Left
         */
        Join_Left,

        /**
         * Ternary_Boolean
         */
        Ternary_Boolean,

        /**
         * Ternary_Left
         */
        Ternary_Left,

        /**
         * Array
         */
        Array,

        /**
         * Index_Start
         */
        Index_Start,

        /**
         * Method_Name
         */
        Method_Name,

        /**
         * Method_Param
         */
        Method_Param,

        /**
         * Lambda_New
         */
        Lambda_New,

        /**
         * Ternay_End
         */
        Ternay_End
    }


    public Token<?> getToken() {
        return token;
    }


    public DelegateTokenType getDelegateTokenType() {
        return delegateTokenType;
    }


    public DelegateToken(int startIndex, Token<?> token, DelegateTokenType type) {
        super(startIndex, token != null ? token.getLexeme() : "");
        this.token = token;
        delegateTokenType = type;
    }


    @Override
    public com.googlecode.aviator.lexer.token.Token.TokenType getType() {
        return TokenType.Delegate;
    }


    @Override
    public Token<?> getValue(Map<String, Object> env) {
        return this.token;
    }

}
