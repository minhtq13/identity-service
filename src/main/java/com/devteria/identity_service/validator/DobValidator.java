package com.devteria.identity_service.validator;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DobValidator implements ConstraintValidator<DobConstraint, LocalDate> {

    private int min;

    @Override
    public boolean isValid(LocalDate dob, ConstraintValidatorContext context) {
        if (Objects.isNull(dob)) return true;

        long years = ChronoUnit.YEARS.between(dob, LocalDate.now());
        return years >= min;
    }

    @Override
    public void initialize(DobConstraint constraint) {
        ConstraintValidator.super.initialize(constraint);
        min = constraint.min();
    }
}
