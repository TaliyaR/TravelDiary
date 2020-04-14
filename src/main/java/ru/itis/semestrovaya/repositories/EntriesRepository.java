package ru.itis.semestrovaya.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.semestrovaya.models.Entry;

public interface EntriesRepository extends JpaRepository<Entry, Long> {
}
