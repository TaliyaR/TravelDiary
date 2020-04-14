package ru.itis.semestrovaya.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.itis.semestrovaya.dto.EntryDto;
import ru.itis.semestrovaya.models.Entry;
import ru.itis.semestrovaya.models.User;
import ru.itis.semestrovaya.repositories.EntriesRepository;
import ru.itis.semestrovaya.security.UserDetailsImpl;

public class EntryServiceImpl implements EntryService {

    @Autowired
    EntriesRepository entriesRepository;

    @Autowired
    UserDetailsImpl userDetails;

    @Override
    public void save(EntryDto form) {
        User user = userDetails.getUser();
        Entry entry = Entry.builder()
                .title(form.getTitle())
                .date(form.getDate())
                .author(user)
                .text(form.getText())
                .isPublic(form.getIsPrivate())
                .location(form.getLocation())
                .build();
    }

    @Override
    public void delete(Entry entry) {
        entriesRepository.delete(entry);
    }

}
