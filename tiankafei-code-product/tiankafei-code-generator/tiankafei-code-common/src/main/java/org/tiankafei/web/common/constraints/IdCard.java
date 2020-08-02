package org.tiankafei.web.common.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import org.tiankafei.web.common.constraints.impl.IdCardValidator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 自定义身份证号码正则验证注解
 *
 * @author tiankafei
 */
@Documented
@Constraint(validatedBy = {IdCardValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
public @interface IdCard {

    String message() default "请输入有效的身份证号码";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
