package ru.itis.semestrovaya.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.semestrovaya.models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findById(Long id);
}
