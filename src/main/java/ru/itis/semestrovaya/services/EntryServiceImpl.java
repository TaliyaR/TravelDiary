package ru.itis.semestrovaya.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.semestrovaya.dto.EntryDto;
import ru.itis.semestrovaya.models.Entry;
import ru.itis.semestrovaya.models.IsPublic;
import ru.itis.semestrovaya.models.Tag;
import ru.itis.semestrovaya.models.User;
import ru.itis.semestrovaya.repositories.EntriesRepository;
import ru.itis.semestrovaya.repositories.TagRepository;
import ru.itis.semestrovaya.security.UserDetailsImpl;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@Component
public class EntryServiceImpl implements EntryService {

    @Autowired
    EntriesRepository entriesRepository;

    @Autowired
    TagRepository tagRepository;

    @Value("${upload.path}")
    private String uploadPath;

    @Override
    public List<Entry> getList(User user){
        List<Entry> list = entriesRepository.findAllByAuthor(user);
        list.sort(compareByDate);
        return list;
    }

    @Override
    public List<Entry> getList(){
        List<Entry> list = entriesRepository.findAllByIsPublic(IsPublic.PUBLIC);
        list.sort(compareByDate);
        return list;
    }

    @Override
    public void save(EntryDto form) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl)auth.getPrincipal();
        User user = userDetails.getUser();
        ArrayList<Tag> list = new ArrayList<>();
        for (String s : form.getTag()) {
            list.add(tagRepository.findTagByName(s));
        }

        Entry entry = Entry.builder()
                .title(form.getTitle())
                .date(LocalDate.parse(form.getDate()))
                .author(user)
                .text(form.getText())
                .isPublic(IsPublic.valueOf(form.getIsPublic()))
                .location(form.getLocation())
                .tags(list)
                .filename(resultFile(form.getFile()))
                .build();

        entriesRepository.save(entry);
    }

    @Override
    public void delete(Entry entry) {
        entriesRepository.delete(entry);
    }

    Comparator<Entry> compareByDate = (o1, o2) -> o2.getDate().compareTo(o1.getDate());

    private String resultFile(MultipartFile file){
        String fileName = null;

        if(file != null){
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            fileName = uuidFile + "." + file.getOriginalFilename();

            try {
                file.transferTo(new File(uploadPath + "/" + fileName));
            } catch (IOException e) {
                throw new IllegalArgumentException();
            }
        }
        return fileName;
    }

}
