package ru.itis.semestrovaya.services;

import org.springframework.security.access.annotation.Secured;
import ru.itis.semestrovaya.models.User;

import java.util.List;

public interface UserService {
    User getByUsername(String username);

    void save(User user);

    void delete(User user);

    List<User> getAllUser();

    User getById(Long id);
}
