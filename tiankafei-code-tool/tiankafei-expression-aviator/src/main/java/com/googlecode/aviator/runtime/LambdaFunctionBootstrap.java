package com.googlecode.aviator.runtime;

import com.googlecode.aviator.Expression;
import com.googlecode.aviator.exception.ExpressionRuntimeException;
import com.googlecode.aviator.runtime.function.BaseLambdaFunction;
import com.googlecode.aviator.utils.Env;

import java.lang.invoke.MethodHandle;
import java.util.List;

/**
 * A lambda function creator.
 *
 * @author dennis
 */
public class LambdaFunctionBootstrap {
    private String name;
    private Expression expression;
    private MethodHandle constructor;
    private List<String> arguments;


    public String getName() {
        return this.name;
    }

    public LambdaFunctionBootstrap(String name, Expression expression, MethodHandle constructor,
                                   List<String> arguments) {
        super();
        this.name = name;
        this.expression = expression;
        this.constructor = constructor;
        this.arguments = arguments;
    }


    /**
     * Create a lambda function.
     *
     * @param env
     * @return
     */
    public BaseLambdaFunction newInstance(Env env) {
        try {
            return (BaseLambdaFunction) constructor.invoke(arguments, expression, env);
        } catch (ExpressionRuntimeException e) {
            throw e;
        } catch (Throwable t) {
            throw new ExpressionRuntimeException("Fail to create lambda instance.", t);
        }
    }
}
