package ru.itis.semestrovaya.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.semestrovaya.dto.PassForm;
import ru.itis.semestrovaya.dto.UserDto;
import ru.itis.semestrovaya.models.User;
import ru.itis.semestrovaya.repositories.UsersRepository;
import ru.itis.semestrovaya.security.UserDetailsImpl;


@Component
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void edit(UserDto form) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = usersRepository.findByUsername(auth.getName()).orElse(new User());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setEmail(form.getEmail());

        usersRepository.save(user);
    }

    @Override
    public void changePassword(PassForm form) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl)auth.getPrincipal();
        User user = userDetails.getUser();
        if(passwordEncoder.matches(form.getOldPassword(), user.getPassword())){
            user.setPassword(passwordEncoder.encode(form.getNewPassword()));
            usersRepository.save(user);
        }else {
            throw new IllegalArgumentException();
        }
    }
}
