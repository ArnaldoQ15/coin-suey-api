package com.suey.coin.config.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;

@Target({FIELD, METHOD, PARAMETER, ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NeededValidator.class)
@Documented
public @interface Needed {

    String message() default "error.validation";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    boolean necessary() default true;

}