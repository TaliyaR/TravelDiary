package ru.itis.semestrovaya.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.semestrovaya.dto.UserDto;
import ru.itis.semestrovaya.repositories.UsersRepository;

public interface ProfileService {

    void edit(UserDto userDto);
}