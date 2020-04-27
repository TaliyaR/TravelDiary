package ru.itis.semestrovaya.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.semestrovaya.models.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findTagByName(String name);
}
