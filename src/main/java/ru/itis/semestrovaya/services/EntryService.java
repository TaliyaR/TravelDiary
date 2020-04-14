package ru.itis.semestrovaya.services;

import ru.itis.semestrovaya.dto.EntryDto;
import ru.itis.semestrovaya.models.Entry;

public interface EntryService {
    void save(EntryDto form);
    void delete(Entry entry);
}
