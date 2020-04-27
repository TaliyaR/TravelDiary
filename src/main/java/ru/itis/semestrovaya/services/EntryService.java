package ru.itis.semestrovaya.services;

import ru.itis.semestrovaya.dto.EntryDto;
import ru.itis.semestrovaya.models.Entry;
import ru.itis.semestrovaya.models.User;

import java.util.List;

public interface EntryService {
    List<Entry> getList(User user);

    List<Entry> getList();

    void save(EntryDto form);

    void delete(Entry entry);
}
