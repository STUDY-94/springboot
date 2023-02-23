package com.spring.boot.springboot.exception.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = LengthValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface LengthCheck {

    String message() default "length is invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
