package com.example.devinhousemodulo_2_projeto_avaliativo_2.validators.interfaces;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.*;

import com.example.devinhousemodulo_2_projeto_avaliativo_2.validators.EnumValidatorImpl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotNull;


@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = EnumValidatorImpl.class)
public @interface EnumValidator {
    Class<? extends Enum<?>> enumClass();
    String message() default "";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}