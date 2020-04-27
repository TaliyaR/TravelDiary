package ru.itis.semestrovaya.repositories;

import jdk.nashorn.internal.ir.Optimistic;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.semestrovaya.models.Entry;
import ru.itis.semestrovaya.models.IsPublic;
import ru.itis.semestrovaya.models.User;

import java.util.ArrayList;
import java.util.List;

public interface EntriesRepository extends JpaRepository<Entry, Long> {
    ArrayList<Entry> getAllByAuthor(User user);
    List<Entry> findAllByAuthor(User user);
    List<Entry> findAllByIsPublic(IsPublic isPublic);
}
