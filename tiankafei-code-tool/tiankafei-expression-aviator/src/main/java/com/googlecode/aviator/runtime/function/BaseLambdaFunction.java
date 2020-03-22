package com.googlecode.aviator.runtime.function;

import com.googlecode.aviator.BaseExpression;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.runtime.type.BaseAviatorObject;
import com.googlecode.aviator.utils.Env;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * All lamabda function base class
 *
 * @author dennis
 */
public abstract class BaseLambdaFunction extends AbstractFunction {

    protected List<String> arguments;

    protected Expression expression;

    protected Env context;

    public BaseLambdaFunction(final List<String> arguments, final Expression expression,
                              final Env context) {
        super();
        this.arguments = arguments;
        this.context = context;
        Set<String> argumentSet = new HashSet<>(this.arguments);
        for (String var : expression.getVariableNames()) {
            if (!var.contains(".") && !argumentSet.contains(var)) {
                // mark the var is captured.
                context.capture(var, ((BaseExpression) expression).getExpression());
            }
        }
        this.expression = expression;
    }

    protected Map<String, Object> newEnv(final Map<String, Object> parentEnv,
                                         final BaseAviatorObject... args) {
        Env env = new Env(new Env(parentEnv, this.context));
        env.setInstance(this.context.getInstance());

        int i = 0;
        for (String name : this.arguments) {
            env.put(name, args[i++].getValue(parentEnv));
        }
        return env;
    }
}
