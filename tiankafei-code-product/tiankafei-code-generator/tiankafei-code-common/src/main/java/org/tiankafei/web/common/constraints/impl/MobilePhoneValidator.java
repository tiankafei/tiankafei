package org.tiankafei.web.common.constraints.impl;

import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.tiankafei.web.common.constraints.MobilePhone;

/**
 * @author tiankafei
 * @since 1.0
 **/
public class MobilePhoneValidator implements ConstraintValidator<MobilePhone, String> {

    private static final String REG_EX = "^1[3,4,5,6,7,8,9]\\d{9}$";
    private static final Pattern PATTERN = Pattern.compile(REG_EX);

    @Override
    public void initialize(MobilePhone parameters) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return true;
        }
        return PATTERN.matcher(value).matches();
    }
}
