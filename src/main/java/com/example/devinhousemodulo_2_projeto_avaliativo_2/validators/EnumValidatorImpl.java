package com.example.devinhousemodulo_2_projeto_avaliativo_2.validators;

import com.example.devinhousemodulo_2_projeto_avaliativo_2.models.enums.EstadoCivil;
import com.example.devinhousemodulo_2_projeto_avaliativo_2.validators.interfaces.EnumValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.data.util.Streamable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class EnumValidatorImpl implements ConstraintValidator<EnumValidator, String> {
    private List<String> acceptedValues;

    @Override
    public void initialize(EnumValidator annotation)
    {
        acceptedValues = Stream.of(annotation.enumClass().getEnumConstants())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context)
    {
        if (value == null) {
            return true;
        }
        return acceptedValues.contains(value);
    }
}
