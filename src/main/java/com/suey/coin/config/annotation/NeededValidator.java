package com.suey.coin.config.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.math.BigDecimal;

import static com.suey.coin.util.Message.getMessage;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.math.BigDecimal.ZERO;
import static java.util.Objects.isNull;
import static org.apache.commons.lang3.BooleanUtils.isTrue;

public class NeededValidator implements ConstraintValidator<Needed, Object> {

    private boolean necessary;

    @Override
    public void initialize(final Needed constraintAnnotation) {
        necessary = constraintAnnotation.necessary();
    }

    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();

        if (isNull(value) && isTrue(necessary)) {
            return errorInvalidValue(context);
        }

        if (value instanceof final BigDecimal valueBigDecimal && (ZERO.equals(valueBigDecimal))) {
                return errorInvalidValue(context);
        }

        return TRUE;
    }

    private boolean errorInvalidValue(final ConstraintValidatorContext context) {
        context.buildConstraintViolationWithTemplate(getMessage("error.validation")).addConstraintViolation();
        return FALSE;
    }

}