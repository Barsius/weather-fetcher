package com.nix.menshikov.weather.fetcher.stats.rest.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateTimeFormatInStringValidator implements ConstraintValidator<DateTimeFormatInString, String> {

    private String format;

    @Override
    public void initialize(DateTimeFormatInString constraintAnnotation) {
        this.format = constraintAnnotation.format();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        DateFormat sdf = new SimpleDateFormat(this.format);
        sdf.setLenient(false);
        try {
            sdf.parse(s);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

}
