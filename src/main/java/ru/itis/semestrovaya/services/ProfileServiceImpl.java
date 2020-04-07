package ru.itis.semestrovaya.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ru.itis.semestrovaya.dto.UserDto;
import ru.itis.semestrovaya.models.User;
import ru.itis.semestrovaya.repositories.UsersRepository;


@Component
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public void edit(UserDto form) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = usersRepository.findByUsername(auth.getName()).orElse(new User());
        User editUser = User.builder()
                .id(user.getId())
                .password(user.getPassword())
                .username(user.getUsername())
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .email(form.getEmail())
                .role(user.getRole())
                .build();

        usersRepository.save(editUser);


    }
}
