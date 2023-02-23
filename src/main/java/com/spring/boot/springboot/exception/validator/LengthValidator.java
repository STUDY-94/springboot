package com.spring.boot.springboot.exception.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.MessageFormat;

@Component
@RequiredArgsConstructor
public class LengthValidator implements ConstraintValidator<LengthCheck, String> {

    private final int minLength = 4;
    private final int maxLength = 8;

    @Override
    public void initialize(LengthCheck lengthCheck) {

    }

    @Override
    public boolean isValid(String str, ConstraintValidatorContext cxt) {
        if (str == null) {
            return false;
        }

        if (isInvalidLength(str)) {
            cxt.disableDefaultConstraintViolation();
            cxt.buildConstraintViolationWithTemplate(
                            MessageFormat.format("{0} is invalid length", str))
                    .addConstraintViolation();
            return false;
        }

        return true;
    }

    private boolean isInvalidLength(String str) {
        return str.length() < minLength || str.length() > maxLength;
    }
}
