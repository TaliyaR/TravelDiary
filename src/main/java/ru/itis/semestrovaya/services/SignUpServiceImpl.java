package ru.itis.semestrovaya.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.itis.semestrovaya.dto.UserDto;
import ru.itis.semestrovaya.models.Role;
import ru.itis.semestrovaya.models.User;
import ru.itis.semestrovaya.repositories.UsersRepository;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void signUp(UserDto form) {

        String emailRegEx = "^(.+)@(.+)$";
        String passwordRegEx = ".{8,}";

        if ((form.getUsername().length() != 0)
                && (form.getEmail().matches(emailRegEx)) && (form.getPassword().matches(passwordRegEx))) {

            User user = User.builder()
                    .firstName(form.getFirstName())
                    .lastName(form.getLastName())
                    .username(form.getUsername())
                    .email(form.getEmail())
                    .password(passwordEncoder.encode(form.getPassword()))
                    .role(Role.USER)
                    .build();

            usersRepository.save(user);
        }
    }
}
