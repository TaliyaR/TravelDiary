package ru.itis.semestrovaya.services;

import ru.itis.semestrovaya.models.Tag;

import java.util.List;

public interface TagService {
    List<Tag> getAll();
    Tag findByName(String name);
}
