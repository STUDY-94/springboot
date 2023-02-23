package com.spring.boot.springboot.exception.validator;

import com.spring.boot.springboot.exception.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.MessageFormat;

@Component
@RequiredArgsConstructor
public class IdDuplicationValidator implements ConstraintValidator<IdUnique, String> {

    private final MemberService memberRepository;

    @Override
    public void initialize(IdUnique IdUnique) {

    }

    @Override
    public boolean isValid(String id, ConstraintValidatorContext cxt) {
        if (memberRepository.isExistId(id)) {
            cxt.disableDefaultConstraintViolation();
            cxt.buildConstraintViolationWithTemplate(
                            MessageFormat.format("ID {0} already exists!", id))
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}