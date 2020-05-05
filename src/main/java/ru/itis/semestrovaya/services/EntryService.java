package ru.itis.semestrovaya.services;

import org.springframework.security.access.annotation.Secured;
import ru.itis.semestrovaya.dto.EntryDto;
import ru.itis.semestrovaya.models.Entry;
import ru.itis.semestrovaya.models.User;

import java.util.List;

public interface EntryService {
    List<Entry> getList(User user);

    List<Entry> getList();

    void save(EntryDto form);

    void deleteById(Long id);

    List<Entry> getEntriesSortedByInterests(User user);

    Entry getById(Long id);
}
