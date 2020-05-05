package ru.itis.semestrovaya.validators;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.semestrovaya.dto.UserDto;
import ru.itis.semestrovaya.models.User;
import ru.itis.semestrovaya.security.UserDetailsImpl;
import ru.itis.semestrovaya.services.UserService;

import javax.validation.*;

public class UniqueValidator implements ConstraintValidator<Unique, UserDto> {

    @Autowired
    UserService userService;

    @Override
    public void initialize(Unique annotation) {
    }

    @Override
    public boolean isValid(UserDto dto, ConstraintValidatorContext ctx) {
        if (userService.getByUsername(dto.getUsername()) != null) {
            ctx.disableDefaultConstraintViolation();
            ctx.buildConstraintViolationWithTemplate(
                    "ru.itis.semestrovaya.constraints.Unique.message.username")
                    .addPropertyNode("username").addConstraintViolation();
            return false;
        }
        return true;
    }

}
