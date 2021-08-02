package com.nix.menshikov.weather.fetcher.stats.rest.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = DateTimeFormatInStringValidator.class)
@Documented
public @interface DateTimeFormatInString {

    String format();

    String message() default "Wrong format of date/time";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
