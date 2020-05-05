package ru.itis.semestrovaya.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {UniqueValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Unique {

    String message() default "ru.itis.semestrovaya.constraints.Unique.message.username";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
