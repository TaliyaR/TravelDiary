package ru.itis.semestrovaya.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.itis.semestrovaya.models.User;
import ru.itis.semestrovaya.repositories.UsersRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UsersRepository usersRepository;

    @Override
    public User getByUsername(String username){
        return usersRepository.findByUsername(username).orElse(null);
    }

    @Override
    public void save(User user){
        usersRepository.save(user);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMIN')")
    public void delete(User user){
        usersRepository.delete(user);
    }

    @Override
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<User> getAllUser() {
        return usersRepository.findAll();
    }

    @Override
    public User getById(Long id){
        return usersRepository.findById(id).orElse(null);
    }
}
