package com.spring.boot.springboot.exception.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IdDuplicationValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IdUnique {

    String message() default "ID is duplication";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
