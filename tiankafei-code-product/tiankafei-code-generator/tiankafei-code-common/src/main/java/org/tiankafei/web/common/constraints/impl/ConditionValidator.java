package org.tiankafei.web.common.constraints.impl;

import com.google.common.collect.Maps;
import com.googlecode.aviator.AviatorEvaluator;
import java.util.Map;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.tiankafei.web.common.constraints.Condition;

/**
 * 自定义身份证号码验证注解实现类
 *
 * @author tiankafei
 * @since 1.0
 **/
public class ConditionValidator implements ConstraintValidator<Condition, String> {

    private String expression;

    @Override
    public void initialize(Condition parameters) {
        this.expression = parameters.expression();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        Map<String, Object> env = Maps.newHashMap();
        env.put("a", value);
        Object result = AviatorEvaluator.execute(expression, env);
        if (result instanceof Boolean) {
            return Boolean.valueOf(result.toString());
        }
        return false;
    }
}
